import com.cda.init.BddDataTestBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class InitialisationTest {
    @Autowired
    BddDataTestBean bdd;

    @Test
    public void initialisationTest() throws Exception {
        System.out.println("bonjour");
    }
}
