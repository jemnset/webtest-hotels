package stepdefinition;

import framework.webPages.HomePage;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSD {

    private HomePage homePage = new HomePage();

    @Given("^I am on the home page$")
    public void iAmOnHomePage(){

        Assert.assertTrue(homePage.isValidTitle(), "Invalid Home Page");
    }
}
