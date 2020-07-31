import com.cda.init.BddDataTestBean;
import org.junit.jupiter.api.Test;

public class InitialisationTest {
    @Test
    public void initialisationTest() throws Exception {
        BddDataTestBean bdd = new BddDataTestBean();
        bdd.initialisation();
    }
}
