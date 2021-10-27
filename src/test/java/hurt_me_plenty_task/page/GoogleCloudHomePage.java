package hurt_me_plenty_task.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage{
    private final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchBtn;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage(){
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public GoogleCloudSearchResultsPage searchForTerm(String searchTerm){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchBtn)).sendKeys(searchTerm);
        searchBtn.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchResultsPage(driver, searchTerm);
    }
}
