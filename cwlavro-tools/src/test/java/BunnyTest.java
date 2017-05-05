import io.cwl.avro.CWL;

/**
 * Run tests using cwltool
 */
public class BunnyTest extends AbstractClientTest {
    @Override
    public CWL getCWL() {
        return new CWL(true);
    }
}
