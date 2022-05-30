import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // path to the feature files
        features = {"src/test/resources"},

        // specify the path of step definition files
        glue = {"StepDefinition", "Web"},

        // tag to be executed
        tags = {"@ddtDarksky"},
        /*
            To run the test runner file fro the command line
            use below command:
                mvn clean test

            If you want to supply tags form the command line
            comment tags line in the testRunner file, and use below command:
                mvn clean test -Dcucumber.options="--tags @tag1,@tag2"
         */

        // this creates a default cucumber report
        plugin = {"pretty", "html:Reports/Default/"}
)
public class TestRunner {
}