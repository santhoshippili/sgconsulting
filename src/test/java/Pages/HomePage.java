package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/ul/li[8]/a/span")
    protected WebElement loggedUser;

    public String getLoggedUserName()
    {
       return loggedUser.getText();
    }
}
