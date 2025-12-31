import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {


    @Test
    public void softAssert() {
    WebDriver driver = new ChromeDriver();
    SoftAssert soft = new SoftAssert();

        driver.get("https://demoqa.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";
        soft.assertEquals(actualTitle, actualTitle);
        System.out.println("SoftAssert passed - 1");

        soft.assertNotEquals(actualTitle, "Google");

        System.out.println("SoftAssert passed - 2");
        boolean isElementDisplayed =
                driver.findElement(By.xpath("//h5[text()='Elements']")).isDisplayed();
        soft.assertTrue(isElementDisplayed);
        System.out.println("SoftAssert passed - 3");
        soft.assertFalse(isElementDisplayed);
        System.out.println("SoftAssert passed - 4");

        String a = "anull";
        soft.assertNotNull(a);
        System.out.println("SoftAssert passed - 5");

        String b = null;
        soft.assertNull(b);
        System.out.println("SoftAssert passed - 6");

        soft.assertAll();

        System.out.println("SoftAssert passed ");
        driver.quit();
    }
}
