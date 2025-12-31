import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
    @Parameters({"browser", "username", "pass"})
    @Test
    public void lunch(String browser, String username, String pass) {
        System.out.println("Parameter " + browser);
        System.out.println("Parameter " + username);
        System.out.println("Parameter " + pass);
    }
}
