package hardcore_task_without_steps.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultsPage extends AbstractPage {
    private String searchTerm;

    public GoogleCloudSearchResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    @FindBy(xpath = "//div[contains(@class, 'gsc-result')]//*[contains(text(), 'Google Cloud Platform Pricing Calculator')]")
    private WebElement resultCalculator;

    public GoogleCloudPlatformPricingCalculatorPage openCorrespondingResult(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.elementToBeClickable(resultCalculator)).click();
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}
