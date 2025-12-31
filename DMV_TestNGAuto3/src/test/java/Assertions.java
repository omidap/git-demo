import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {

    @Test
    public void demoTest() {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        String actual = driver.getTitle();
        String Expected = "DEMOQA";

//        Assert.assertEquals(actual, Expected); // assertEquals()
        Assert.assertNotEquals(actual, Expected); //

        System.out.println("Login Successful");
    }
}
