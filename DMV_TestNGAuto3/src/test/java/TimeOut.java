import org.testng.annotations.Test;

public class TimeOut {
    @Test
    public void openBrowser(){
        System.out.println("Open Browser");
    }

    @Test(timeOut = 2000)
    public void performance() throws InterruptedException{
        System.out.println("Performance Test");
        Thread.sleep(2500);
        System.out.println("Performance Test completed.");
    }

    @Test
    public void closeBrowser() {
        System.out.println("Close Browser");
    }
}
