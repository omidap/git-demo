import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQAAllAsserts {
    @Test
    public void verifyAllHardAsserts() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        /* ==============================
           assertEquals()
           ============================== */
        String actualTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";

        Assert.assertEquals(actualTitle, expectedTitle,
                "Page title does not match");

        /* ==============================
           assertNotEquals()
           ============================== */
        String wrongTitle = "Google";
        Assert.assertNotEquals(actualTitle, wrongTitle,
                "Title should not match Google");

        /* ==============================
            assertTrue()
           ============================== */
        boolean isElementsDisplayed =
                driver.findElement(By.xpath("//h5[text()='Elements']")).isDisplayed();

        Assert.assertTrue(isElementsDisplayed,
                "Elements card is not displayed");

        /* ==============================
            assertFalse()
           ============================== */
        boolean isFakeElementDisplayed = false;

        Assert.assertFalse(isFakeElementDisplayed,
                "Condition should be false");

        /* ==============================
           assertNotNull()
           ============================== */
        WebDriver driverRef = driver;

        Assert.assertNotNull(driverRef,
                "Driver object is null");

        /* ==============================
            assertNull()
           ============================== */
        String value = null;

        Assert.assertNull(value,
                "Value is not null");

        /* ==============================
            Assert.fail()
           ============================== */
        if (driver.getCurrentUrl().contains("wrongurl")) {
            Assert.fail("URL validation failed forcefully");
        }

        driver.quit();
    }
}
