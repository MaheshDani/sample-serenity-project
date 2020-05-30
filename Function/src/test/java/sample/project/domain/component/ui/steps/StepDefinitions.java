package sample.project.domain.component.ui.steps;

import io.cucumber.core.gherkin.ScenarioOutline;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.project.domain.component.ui.runners.TestSuiteUi;
import sample.project.domain.component.ui.stepLib.UiStepLib;

public class StepDefinitions {

    @Steps
    UiStepLib uiStepLib;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSuiteUi.class);

    @Before
    public void before(Scenario scenario) {
        LOGGER.info("######################## before StepDefinitions");
        LOGGER.info("######################## Scenario {}: {}", scenario.getName(), scenario.getId());
        Serenity.recordReportData().withTitle("Scenario Name").andContents(scenario.getName());
    }

    @Given("^I open Gov.uk home page$")
    public void iOpenGoogle() {
        uiStepLib.navigateToGovUkHomePage();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String term) {
        uiStepLib.searchForTerm(term);
    }

    @Then("^I should find \"([^\"]*)\" related results$")
    public void iShouldFind(String expectedResultTerm) {
        uiStepLib.verifySearchTermInResult(expectedResultTerm);
    }

    @Then("I am on search result page")
    public void iAmOnSearchResultPage() {
        uiStepLib.verifyUserIsOnSearchResultPage();
    }


}

