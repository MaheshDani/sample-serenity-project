package sample.project.domain.component.ui.stepLib;

import io.cucumber.core.gherkin.Scenario;
import io.cucumber.core.gherkin.ScenarioOutline;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.project.domain.component.ui.pages.GovHomePage;
import sample.project.domain.component.ui.pages.GovUkSearchResultPage;

public class UiStepLib {

    private static final Logger LOGGER = LoggerFactory.getLogger(UiStepLib.class);
    private GovHomePage govHomePage;
    private GovUkSearchResultPage searchResultPage;

    public void navigateToGovUkHomePage() {
        govHomePage.open();
    }

    public void searchForTerm(String term) {
        Serenity.setSessionVariable("searchTerm").to(term);
        govHomePage.Search(term);
    }

    public void verifySearchTermInResult(String expectedResultTerm) {
        Assert.assertTrue(searchResultPage.hasAtLeastOneMatchingSearchResult(expectedResultTerm));
    }

    public void verifyUserIsOnSearchResultPage() {
        searchResultPage.verifyIsOnSearchResultPage();
    }
}

