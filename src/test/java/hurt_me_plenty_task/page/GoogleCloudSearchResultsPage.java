package hurt_me_plenty_task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultsPage extends AbstractPage{
    private String searchTerm;

    public GoogleCloudSearchResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    @FindBy(xpath = "//div[contains(@class, 'gsc-result')]//*[contains(text(), 'Google Cloud Platform Pricing Calculator')]")
    private WebElement resultCalculator;


    private String buildLocatorForSearch(){
        String defaultLocator = "//div[@class='gsc-webResult gsc-result']";
        return defaultLocator.concat("//b[text()=\"").concat(searchTerm).concat("\"]");
    }

    public GoogleCloudPlatformPricingCalculator openCorrespondingResult(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(resultCalculator)).click();
        return new GoogleCloudPlatformPricingCalculator(driver);
    }
}
