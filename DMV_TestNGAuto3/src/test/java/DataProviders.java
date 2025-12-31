import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviders {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {"john007", "3412Bcsg1205@@"},
                {"alice123", "Test@123"},
                {"maxUser", "SecurePass!"}
        };

    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));

        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys(username);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();

        Assert.assertEquals(driver.getTitle(), "DEMOQA");

        System.out.println("UserName: " + username + " | Password: " + password);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
