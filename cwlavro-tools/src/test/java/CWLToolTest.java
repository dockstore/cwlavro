import io.cwl.avro.CWL;

/**
 * Run tests using cwltool-in-heterodon
 */
public class CWLToolTest extends AbstractClientTest {
    @Override
    public CWL getCWL() {
        return new CWL();
    }
}
