import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "." },tags = {"@codeGen"}, dryRun = false, strict = false, monochrome = false,plugin = {"com.github.kirlionik.cucumberallure.AllureReporter"})

public class RunAdminTest {

}
