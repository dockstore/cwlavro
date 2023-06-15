/*
 * Copyright (C) 2015 Collaboratory
 *
 */

package io.cwl.avro;

import com.google.common.base.Optional;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.output.TeeOutputStream;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author xliu
 */
public class Utilities {

    private static final Logger LOG = LoggerFactory.getLogger(Utilities.class);

    /**
     * Execute a command and return stdout and stderr
     * @param command the command to execute
     * @return the stdout and stderr
     */
    public static ImmutablePair<String, String> executeCommand(String command, final boolean dumpOutput, Optional<OutputStream> stdoutStream, Optional<OutputStream> stderrStream) {
        // TODO: limit our output in case the called program goes crazy

        // these are for returning the output for use by this
        try (ByteArrayOutputStream localStdoutStream = new ByteArrayOutputStream();
                ByteArrayOutputStream localStdErrStream = new ByteArrayOutputStream()
        ) {
            OutputStream stdout = localStdoutStream;
            OutputStream stderr = localStdErrStream;
            if (stdoutStream.isPresent()) {
                assert stderrStream.isPresent();
                // in this branch, we want a copy of the output for Consonance
                stdout = new TeeOutputStream(localStdoutStream, stdoutStream.get());
                stderr = new TeeOutputStream(localStdErrStream, stderrStream.get());
            }

            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            String utf8 = StandardCharsets.UTF_8.name();
            try {
                final CommandLine parse = CommandLine.parse(command);
                Executor executor = new DefaultExecutor();
                executor.setExitValue(0);
                if (dumpOutput) {
                    System.out.println("CMD: " + command);
                }
                // get stdout and stderr
                executor.setStreamHandler(new PumpStreamHandler(stdout, stderr));
                executor.execute(parse, resultHandler);
                resultHandler.waitFor();
                // not sure why commons-exec does not throw an exception
                if (resultHandler.getExitValue() != 0) {
                    System.err.println("problems running command: " + command);
                    if (!stdoutStream.isPresent() && !localStdoutStream.toString().isEmpty()){
                        System.err.println("stdout for command:\n\t" + localStdoutStream.toString(utf8).replaceAll("\n","\n\t"));
                    }
                    if (!stderrStream.isPresent() && !localStdErrStream.toString().isEmpty()){
                        System.err.println("stderr for command:\n\t" + localStdErrStream.toString(utf8).replaceAll("\n","\n\t"));
                    }
                    throw new ExecuteException("problems running command: " + command, resultHandler.getExitValue());
                }
                return new ImmutablePair<>(localStdoutStream.toString(utf8), localStdErrStream.toString(utf8));
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException("problems running command: " + command, e);
            } finally {
                if (dumpOutput) {
                    System.out.println("exit code: " + resultHandler.getExitValue());
                    try {
                        System.err.println("stderr was: " + localStdErrStream.toString(utf8));
                        System.out.println("stdout was: " + localStdoutStream.toString(utf8));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException("utf-8 does not exist?", e);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("could not close output streams", e);
        }
    }


}
