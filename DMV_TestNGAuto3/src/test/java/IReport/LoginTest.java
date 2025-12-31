package IReport;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        driver.get("https://demoqa.com/login");
        // your test steps...
    }
    @Test
    public void passTest() {
        Assert.assertTrue(true);
    }
    @Test
    public void failTest() {
        Assert.assertFalse(false);
    }
    @Test(dependsOnMethods = "failTest")
    public void SkippedTest(){
        System.out.println("SkippedTest");
    }
}