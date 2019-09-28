package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//*[@id='login-Form']/div[3]/div[2]/button")
    public WebElement submitBtn;
    @FindBy(xpath = "//*[@id='login-Form']/div[1]/ul/li")
    protected WebElement validationError;

    public void doSigIn(String email, String pwd) {
        userName.sendKeys(email);
        password.sendKeys(pwd);
    }

    public void clickSubmit() {
        submitBtn.submit();
    }

    public String getValidationErrorText()
    {
        return validationError.getText();
    }
}
