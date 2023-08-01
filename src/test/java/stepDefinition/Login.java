package stepDefinition;

import io.cucumber.java.en.*;
import utils.CommonMethods;

public class Login extends CommonMethods {
    @Given("user navigated to HRMS applicaiotn")
    public void user_navigated_to_hrms_applicaiotn() {
        System.out.println("Open Application");

    }
    @When("user enters valid user name and password")
    public void user_enters_valid_user_name_and_password() {
        System.out.println("enter user name and password");
    }
    @When("click on Login button")
    public void click_on_login_button() {
        System.out.println("Login button");

    }
    @Then("user should be successfully logged in to the application")
    public void user_should_be_successfully_logged_in_to_the_application() {
        System.out.println("logged in");

    }
}
