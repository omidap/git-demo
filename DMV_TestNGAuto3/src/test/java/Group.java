import org.testng.annotations.Test;

public class Group {
    @Test(groups = "smoke")
    public void openapp(){
        System.out.println("Opening app");
    }

    @Test(groups = "E2E")
    public void login() {
        System.out.println("Login to Application");
    }

    @Test(groups = "smoke")
    public void searchProduct(){
        System.out.println("Searching Product");
    }

    @Test(groups = "E2E")
    public void addToCart(){
        System.out.println("Adding to cart");
    }

    @Test(groups = "E2E")
    public void removeFromCart(){
        System.out.println("Removing from cart");
    }

    @Test(groups ="Regression")
    public void closeapp(){
        System.out.println("Closing app");
    }
}
