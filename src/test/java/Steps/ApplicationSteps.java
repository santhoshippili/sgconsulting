package Steps;

import Base.BaseUtil;
import Pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApplicationSteps extends BaseUtil {
    private BaseUtil baseUtil;

    public ApplicationSteps(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    LoginPage loginPage = new LoginPage(baseUtil.Driver);
    HomePage homePage = new HomePage(baseUtil.Driver);

    @Given("I open the browser and navigate to MDC")
    public void iOpenTheBrowserAndNavigateToMDC() {
        baseUtil.Driver.get("http://dev.mdc.consentsonline.com");
    }

    @And("I give valid {string} and {string}")
    public void iGiveValidAnd(String userName, String pwd) {
        loginPage.doSigIn(userName, pwd);
    }

    @When("I click on SignIn button")
    public void iClickOnSignInButton() {
        loginPage.clickSubmit();
    }

    @Then("I should be on the Home Page")
    public void iShouldBeOnTheHomePage() {
        Assert.assertEquals("Proper User name is not displayed", "Hello Anand",
                homePage.getLoggedUserName());

    }

    @And("I give invalid combinations of Username and Password")
    public void iGiveInvalidCombinationsOfUsernameAndPassword(DataTable DT) throws InterruptedException {
        List<Map<String, String>> userNames = DT.asMaps(String.class, String.class);
        System.out.println("Username1--" + userNames.get(0));
        System.out.println("Password1--" + userNames.get(0));
        loginPage.doSigIn(userNames.get(0).get("UserName"), userNames.get(0).get("Password"));
        Thread.sleep(10000);
    }

    @And("I give invalid combinations of Username and Password with condition and Submit")
    public void iGiveInvalidCombinationsOfUsernameAndPasswordWithConditionAndSubmit
            (DataTable dt) {
        List<String> userNames = dt.asList(String.class);
        loginPage.doSigIn(userNames.get(0), userNames.get(1));
        loginPage.clickSubmit();
        if (userNames.get(2).equalsIgnoreCase("invalid password")) {
            Assert.assertEquals("Proper validation error message is not displayed",
                    loginPage.getValidationErrorText(), userNames.get(3));
        }
    }

}
