import io.cwl.avro.CWL;

/**
 * Run tests using cwltool
 */
public class CWLToolTest extends AbstractClientTest {
    @Override
    public CWL getCWL() {
        return new CWL(null);
    }
}
