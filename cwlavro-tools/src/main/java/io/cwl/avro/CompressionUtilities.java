package io.cwl.avro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.io.File;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ripped from https://stackoverflow.com/questions/315618/how-do-i-extract-a-tar-file-in-java
 */
public class CompressionUtilities {

    private static final Logger LOG = LoggerFactory.getLogger(CompressionUtilities.class);


    /** Untar an input file into an output file.

     * The output file is created in the output folder, having the same name
     * as the input file, minus the '.tar' extension.
     *
     * @param inputFile     the input .tar file
     * @param outputDir     the output directory file.
     * @throws IOException
     * @throws FileNotFoundException
     *
     * @return  The {@link List} of {@link File}s with the untared content.
     * @throws ArchiveException
     */
    public static List<File> unTar(final File inputFile, final File outputDir) throws IOException,
            ArchiveException {

        LOG.info(String.format("Untaring %s to dir %s.", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));

        final List<File> untaredFiles = new LinkedList<>();
        final InputStream is = new FileInputStream(inputFile);
        try(TarArchiveInputStream debInputStream = (TarArchiveInputStream) new ArchiveStreamFactory().createArchiveInputStream("tar", is)) {
            TarArchiveEntry entry;
            while ((entry = (TarArchiveEntry)debInputStream.getNextEntry()) != null) {
                final File outputFile = new File(outputDir, entry.getName());
                if (entry.isDirectory()) {
                    LOG.info(String.format("Attempting to write output directory %s.", outputFile.getAbsolutePath()));
                    if (!outputFile.exists()) {
                        LOG.info(String.format("Attempting to create output directory %s.", outputFile.getAbsolutePath()));
                        if (!outputFile.mkdirs()) {
                            throw new IllegalStateException(String.format("Couldn't create directory %s.", outputFile.getAbsolutePath()));
                        }
                    }
                } else {
                    LOG.info(String.format("Creating output file %s.", outputFile.getAbsolutePath()));
                    FileUtils.forceMkdirParent(outputFile);
                    final OutputStream outputFileStream = new FileOutputStream(outputFile);
                    IOUtils.copy(debInputStream, outputFileStream);
                    outputFileStream.close();
                }
                untaredFiles.add(outputFile);
            }
        }
        return untaredFiles;
    }

    /**
     * Ungzip an input file into an output file.
     * <p>
     * The output file is created in the output folder, having the same name
     * as the input file, minus the '.gz' extension.
     *
     * @param inputFile     the input .gz file
     * @param outputDir     the output directory file.
     * @throws IOException
     * @throws FileNotFoundException
     *
     * @return  The {@File} with the ungzipped content.
     */
    public static File unGzip(final File inputFile, final File outputDir) throws IOException {

        LOG.info(String.format("Ungzipping %s to dir %s.", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));

        final File outputFile = new File(outputDir, inputFile.getName().substring(0, inputFile.getName().length() - 3));

        try( GZIPInputStream in = new GZIPInputStream(new FileInputStream(inputFile)); FileOutputStream out = new FileOutputStream(outputFile)) {
            IOUtils.copy(in, out);
        }

        return outputFile;
    }
}
