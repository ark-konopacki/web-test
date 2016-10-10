package pl.webtest.page.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.webtest.page.Page;

import java.util.List;

/**
 * Google search results page
 */
public class SearchResultsPage extends Page {

    @FindBy(css = "#ires .srg a")
    private List<WebElement> results;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTopResultTitle() {
        String topResultTitle = "";
        if (results.size() > 0) {
            topResultTitle = results.get(0).getText();
        }

        return topResultTitle;
    }
}