import org.testng.annotations.Test;

public class ExceptionTest {
    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZero(){
        int result = 10/0;
        System.out.println("dividedByZero Test");
    }
}
