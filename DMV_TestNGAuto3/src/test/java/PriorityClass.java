import org.testng.annotations.Test;

public class PriorityClass {
    @Test(priority = 1)
    public void openBrowser(){
        System.out.println("openBrowser");
    }

    @Test(priority = 1)
    public void login(){
        System.out.println("login");
    }

    @Test(priority = 4)
    public void addToCart() {
        System.out.println("Add to Cart");
    }

    @Test(priority = 2)
    public void search(){
        System.out.println("search");
    }

    @Test(priority = 5)
    public void logout (){
        System.out.println("search1");
    }
}
