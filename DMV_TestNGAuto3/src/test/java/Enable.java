import org.testng.annotations.Test;

public class Enable {
    @Test
    public void openBrowser(){
        System.out.println("open Browser");
    }

    @Test(enabled = false)
    public void skipTest() {
        System.out.println("This test will NOT execute");
    }

    @Test
    public void closeBrowser(){
        System.out.println("app closed");
    }

    public static void main(String[] args) {
        System.out.println("app");
    }
}
