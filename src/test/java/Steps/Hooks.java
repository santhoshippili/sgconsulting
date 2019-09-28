package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import gherkin.deps.com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks extends BaseUtil {
    private BaseUtil base;
    public final String baseDir = System.getProperty("user.dir");


    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTests(Scenario scenario) {
        String _browser = System.getProperty("browser");
        System.out.println("Base Dir: " + baseDir);
        System.out.println("Current Browser value from the POM: " + _browser);
        if (null == _browser || _browser.isEmpty()) {
            _browser = "Chrome";
            System.out.println("By default setting the value to chrome");
        }
        if (_browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\User\\IdeaProjects\\nz\\drivers\\windows\\Chrome\\chromedriver.exe");
            base.Driver = new ChromeDriver();
        } else if (_browser.equalsIgnoreCase("firefox")) {
            System.out.println("Going into firefox driver....");
            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\User\\IdeaProjects\\nz\\drivers\\windows\\FireFox\\geckodriver.exe");
            base.Driver = new FirefoxDriver();
        }
    }

//    @BeforeStep
//    public void printStepName(Scenario scenario) {
//        System.out.println("Current Scenario Name--->" + scenario.getName());
//    }

    @After
    public void tearDown() {
        base.Driver.close();
        base.Driver.quit();
    }
}
