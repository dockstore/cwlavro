import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Resources;
import io.cwl.avro.CWL;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;

/**
 * Run tests using cwltool
 */
public class CustomBunnyTest extends AbstractClientTest {
    @Override
    public CWL getCWL() {
        final URL resource = Resources.getResource("testConfig");
        ReloadingFileBasedConfigurationBuilder<INIConfiguration> builder = new ReloadingFileBasedConfigurationBuilder<>(
            INIConfiguration.class).configure(new Parameters().properties().setFileName(resource.getFile()));
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(), null, 1, TimeUnit.MINUTES);
        trigger.start();
        return new CWL();
    }
}
