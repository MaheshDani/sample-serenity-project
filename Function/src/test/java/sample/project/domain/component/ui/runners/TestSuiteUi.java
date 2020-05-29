package sample.project.domain.component.ui.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {""},
        plugin = {"pretty"},
        features = "classpath:features/ui/spamuitests.feature:15",
        glue = {"sample.project.domain.component.ui.steps;"}
)
public class TestSuiteUi  {

}
