import org.testng.annotations.Test;

public class InvocationCount {
    @Test
    public void openBrowser(){
        System.out.println("open Browser");
    }

    @Test(invocationCount = 100)
    public void repeatTest(){
        System.out.println("repeated Test");
    }

    @Test
    public void zcloseBrowser(){
        System.out.println("close Browser");
    }
}
