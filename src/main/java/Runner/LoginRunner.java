package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features/Login.feature" ,
        glue = "/src/main/java/AppSteps/Subscribtion_Steps.java",
        monochrome = true,
        format = "json:target/cucumber-json-report.json"

)
public class LoginRunner {
}