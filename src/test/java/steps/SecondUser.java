package steps;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.en.*;

public class SecondUser {
    Response response;

    @Given("base is set")
    public void baseIsSet() {
        baseURI = "https://jsonplaceholder.typicode.com/users";
    }

    @When("I send Post request")
    public void iSendPostRequest() {
        String requestBody = "{ \"name\": \"Ismail\", \"job\": \"QA\" }";

        response = given().contentType(ContentType.JSON).body(requestBody).when().post(baseURI);
    }

    @Then("status code should be {int}")
    public void verifyStatusCode(int code) {
        assertEquals(response.getStatusCode(), code);
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Then("print response")
    public void printResponse() {
        String res = response.getBody().asPrettyString();
        System.out.println("Full Response:\n" + res);
    }

}