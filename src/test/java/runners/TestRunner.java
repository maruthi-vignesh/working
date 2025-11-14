package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",plugin = {"pretty", "html:target/cucumber-report.html"},glue = {"src/test/java/stepDefinitions"},
    monochrome = true
    
)
public class TestRunner {

}
