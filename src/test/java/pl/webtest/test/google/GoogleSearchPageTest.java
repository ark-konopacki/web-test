package pl.webtest.test.google;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.webtest.page.Page;
import pl.webtest.page.google.SearchPage;
import pl.webtest.page.google.SearchResultsPage;
import pl.webtest.test.SeleniumTestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchPageTest extends SeleniumTestBase {

    @Test
    @Parameters({"searchString", "expectedResult"})
    public void googleSearchTest(String searchString, String expectedResult) {
        SearchPage searchPage = Page.getInstance(getWebDriver(),
                "http://www.google.com/webhp?complete=1&hl=en",
                SearchPage.class);

        assertThat(searchPage.getTitle()).isEqualTo("Google");

        SearchResultsPage results = searchPage.search(searchString);
        String topResultTitle = results.getTopResultTitle();

        assertThat(topResultTitle).contains(expectedResult);
    }

}
