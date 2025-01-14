package StepDefs;

import io.cucumber.java.en.And;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs extends AbstractStepDefs {

    @Given("I fill fields with login (.*)")
    public void i_fill_fields_with_login(String username) {
        onLoginForm().typeUsername(username);
    }

    @When("I click on the further button")
    public void i_click_on_the_further_button() {
        onLoginForm().clickToSubmitUserName();
    }

    @And("I fill fields with password (.*)")
    public void i_fill_fields_with_password(String password) {
        onLoginForm().typePassword(password);
    }

    @And("I click on the enter button")
    public void i_click_on_the_enter_button() {
        onLoginForm().clickToSubmitPassword();
    }

    @Then("I check successful log in")
    public void i_check_successful_log_in() {
        Assert.assertTrue("Element should be visiale",
                onLoginForm().inputIsSuccessful());
    }

    @And("I am logging out")
    public void i_am_logging_out() {
        onLoginForm().logOut();
    }

    @And("I check logout")
    public void i_check_logout() {
        onMainPage().isPleaseLoginMessageVisible();
    }

    @Then("I check an exception")
    public void i_check_an_exception() {
        Assert.assertTrue("Element should be visiale", onLoginForm().anExceptionShowed());
    }

    @Given("I log out of the previous account")
    public void i_log_out_of_the_previous_account() {
        onLoginForm().deleteOldUser();
    }
}