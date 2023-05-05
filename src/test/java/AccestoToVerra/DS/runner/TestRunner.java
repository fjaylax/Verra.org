package AccestoToVerra.DS.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {

        } ,
        features="src/test/java/recources/features",
        glue = "com/DS/step_definitions",
        dryRun = false,
        tags=""



)








public class TestRunner {
}
