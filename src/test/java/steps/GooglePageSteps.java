package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GooglePageSteps extends TestBase {
    @Before
    public void start() {
        initialize();
        googlePage = new GooglePage(webDriver);
    }

    @After
    public void stop() {
        tearDown();
    }

    @Given("^Open start page \"([^\"]*)\"$")
    public void openPage(String arg0) {
        googlePage.open(arg0);
    }

    @When("Page is opened")
    public void pageIsOpened() {
        googlePage.isOpened();
    }

    @And("Navigate to search line")
    public void navigateToSearchLine() {
        googlePage.navigateToSearchLine();
    }

    @And("Enter your data {string}")
    public void enterYourData(String arg0) {
        googlePage.enterText(arg0);
    }

    @Then("Success reg message is displayed")
    public void successRegMessageIsDisplayed() {
        googlePage.checkTaskSuccess();
    }
}

