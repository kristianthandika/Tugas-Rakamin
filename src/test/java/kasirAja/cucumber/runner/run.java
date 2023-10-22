package kasirAja.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/kasirAja/cucumber/resources/features/", // Specify the path to your feature files
        glue = "kasirAja.cucumber.stepDef",    // Specify the package where your step definitions are located
        plugin = {"html:target/HTML_report.html"} // You can specify the format and location of the test reports
)
public class run {
}
