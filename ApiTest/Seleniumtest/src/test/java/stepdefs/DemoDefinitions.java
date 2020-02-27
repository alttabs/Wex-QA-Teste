package stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DemoDefinitions {


    private String endPoint;
    private String jsonResult;


    @Given("path movies")
    public void pathMovies() throws Throwable {
        endPoint = "http://localhost:8080/Question3/api/movies";
    }

    @Given("^path customer with ID (1|2|3|4|6)$")
    public void pathMovies(String id) throws Throwable {
        endPoint = "http://localhost:8080/Question3/api/customer/" + id;
    }

    @When("I call api")
    public void callApi() throws Throwable {
        StringBuilder result = new StringBuilder();
        URL url = new URL(endPoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        jsonResult = result.toString();
    }

    @Then("verify the api results")
    public void printResult() throws Throwable {
        System.out.println(jsonResult);
    }
}