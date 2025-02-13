package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import DriverManager.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/main/resources",
        glue = "StepDefs",
        tags = {"@Regression"}
)
public class CucumberRunner {

    @AfterClass
    public static void teardown() {
        DriverManager.getDriver().close();
    }
}