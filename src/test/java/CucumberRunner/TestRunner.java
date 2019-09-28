package CucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "Steps",
        features = "src\\test\\Resources\\features",
        plugin = {
                "json:target/cucumber/cucumber.json",
                "pretty:target/cucumber.txt",
                "usage:target/cucumberUsage.json",
                "junit:target/cucumberResults.xml",
                "html:target/cucumber-reports"
        },tags = {"@sanity"})

public class TestRunner {
}
