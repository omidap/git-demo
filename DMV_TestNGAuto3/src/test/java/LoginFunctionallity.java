import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class LoginFunctionallity {

    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Inside beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Inside beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Inside beforeClass");
    }

    @BeforeMethod(groups = {"regression"})
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";
        Assert.assertEquals(actualTitle, expectedTitle, "The actual title: " + actualTitle + "\nexpected title: " + expectedTitle);
    }

    @Test(description = "test001", groups = {"regression"})
    public void test001() {
        try {
            WebElement useranme = driver.findElement(By.xpath("//input[@id='userName']"));
            useranme.sendKeys("john007");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("3412Bcsg1205@@");
            driver.findElement(By.xpath("//button[@id='login']")).click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            String actualTitle = driver.getTitle();
            String expectedTitle = "DEMOQA";
            Assert.assertEquals(actualTitle, expectedTitle, "The actual and expected values are matched.");
        }
    }

    @Test(description = "test002", groups = {"regression"})
    public void test002() {
        try {
            driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("john007");
            WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
            pass.sendKeys("invalid password");
            driver.findElement(By.xpath("//button[@id='login']")).click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errMessage = driver.findElement(By.xpath("//p[text()='Invalid username or password!']"));
            wait.until(ExpectedConditions.visibilityOfAllElements(errMessage));
            String errorMessageTxt = errMessage.getText();
            String expectedErrorMessage = "Invalid username or password!";
            Assert.assertEquals(errorMessageTxt, expectedErrorMessage);
        }
    }

    @Test(description = "test003", groups = {"regression"})
    public void test003() {
        try {
            WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
            userName.sendKeys("john007");
            WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
            pass.sendKeys("Net@876");
            driver.findElement(By.xpath("//button[@id='login']")).click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errMessage = driver.findElement(By.xpath("//p[text()='Invalid username or password!']"));
            wait.until(ExpectedConditions.visibilityOfAllElements(errMessage));
            String errorMessageTxt = errMessage.getText();
            String expectedErrorMessage = "Invalid username or password!";
            Assert.assertEquals(errorMessageTxt, expectedErrorMessage);
        }
    }

    @Test(description = "test004", groups = "regression")
    public void test004() {
        try {
            WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
            userName.sendKeys("invalid username");
            WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
            pass.sendKeys("Invalid password");
            driver.findElement(By.xpath("//button[@id='login']")).click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errMessage = driver.findElement(By.xpath("//p[text()='Invalid username or password!']"));
            wait.until(ExpectedConditions.visibilityOfAllElements(errMessage));
            String errorMessageTxt = errMessage.getText();
            String expectedErrorMessage = "Invalid 333433username or password!";
            Assert.assertEquals(errorMessageTxt, expectedErrorMessage);
        }
    }

    @Test(description = "test005", groups = "regression")
    public void test005() {
        try {
            driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("john007");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("3412Bcsg1205@@");
            driver.findElement(By.xpath("//button[@id='login']")).click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {

            String actualTitle = driver.getTitle();
            String expectedTitle = "DEMOQA";
            Assert.assertEquals(actualTitle, expectedTitle, "the expected title is: " + expectedTitle + "acutal title is " + actualTitle);
        }
    }

    @Test(description = "test006", groups = "regression")
    public void test006() {
        try {
            driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("john007");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("3412Bcsg1205@@");
            driver.findElement(By.xpath("//button[@id='login']")).click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errMessage = driver.findElement(By.xpath("//p[text()='Invalid username or password!']"));
            wait.until(ExpectedConditions.visibilityOfAllElements(errMessage));
            String errorMessageTxt = errMessage.getText();
            String expectedErrorMessage = "Invalid username or password!";
            Assert.assertEquals(errorMessageTxt, expectedErrorMessage);
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destination = System.getProperty("user.dir")
                    + File.separator
                    + "src"
                    + File.separator
                    + "main"
                    + File.separator
                    + "screenshot"
                    + File.separator
                    + "loginPage_"
                    + timestamp + ".png";

            File destFile = new File(destination);
            destFile.getParentFile().mkdirs(); // ensure folders exist
            FileUtils.copyFile(source, destFile);

            System.out.println("Screenshot saved at: " + destination);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        } finally {
            if (driver != null)
                driver.quit();
        }
    }
}
