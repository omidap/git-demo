import org.testng.annotations.Test;

public class DependencyTest {
    @Test
    public void login() {
        System.out.println("Login successfully done.");
    }

    @Test(dependsOnMethods = {"login"})
    public void logout() {
        System.out.println("Logout Test.");
    }
}
