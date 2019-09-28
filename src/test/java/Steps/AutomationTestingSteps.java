package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AutomationTestingSteps extends BaseUtil {
    private BaseUtil baseUtil;
    public Alert popUpAlert;
    public AutomationTestingSteps(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Given("I navigate to a Test App")
    public void iNavigateToATestApp() {
        Driver.manage().window().maximize();
        Driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
        Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("I click on Simple Alert button")
    public void iClickOnSimpleAlertButton() throws InterruptedException {
        Driver.findElement(By.id("cookie_action_close_header")).click();
        WebElement simpleAlertButton = Driver.findElement(By.xpath("//*[@id='content']/p[3]/button"));
        simpleAlertButton.click();
        Alert confirmationAlert = Driver.switchTo().alert();
        String confirmationAlertText = confirmationAlert.getText();
        System.out.println("This is my Alert Text: " + confirmationAlertText);
        if (!confirmationAlertText.isEmpty()) {
            confirmationAlert.dismiss();
        }
        Thread.sleep(10000);
    }

    @And("I click on Simple PopUp button")
    public void iClickOnSimplePopUpButton() {
        Driver.findElement(By.id("cookie_action_close_header")).click();
        Driver.findElement(By.xpath("//*[@id='content']/p[7]/button")).click();
        popUpAlert = Driver.switchTo().alert();
        System.out.println("PopUp Alert Text: " + popUpAlert.getText());
    }

    @And("I click {string} on the PopUp alert")
    public void iClickOnThePopUpAlert(String YesOrNo) {
        if (YesOrNo.equalsIgnoreCase("Yes")) {
            popUpAlert.accept();
        }
        if (YesOrNo.equalsIgnoreCase("No"))
        {
            popUpAlert.dismiss();
        }
    }
}
