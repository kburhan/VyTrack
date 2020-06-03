package com.vytrack.step_definitions.login;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
       String URL = ConfigurationReader.getProperty("qa1");
       Driver.getDriver().get(URL);
    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        loginPage.login(ConfigurationReader.getProperty("sales_manager"), ConfigurationReader.getProperty("password"),false);

    }

    @Then("user should verify title is a dashboard")
    public void user_should_verify_title_is_a_dashboard() {
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    }

    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        loginPage.login(ConfigurationReader.getProperty("store_manager"), ConfigurationReader.getProperty("password"),false);
    }

    @When("user logged in as a driver")
    public void user_logged_in_as_a_driver() {
        loginPage.login(ConfigurationReader.getProperty("driver"), ConfigurationReader.getProperty("password"),false);
    }

    @Given("user logs in as a {string}")
    public void user_logs_in_as_a(String username) {
        loginPage.login(username);
    }

    @Then("user should verify {string} is displayed")
    public void user_should_verify_is_displayed(String title) {
        Assert.assertEquals(title,Driver.getDriver().getTitle());
    }

}