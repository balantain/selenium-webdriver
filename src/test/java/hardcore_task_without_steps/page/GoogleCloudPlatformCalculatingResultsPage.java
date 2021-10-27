package hardcore_task_without_steps.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformCalculatingResultsPage extends AbstractPage {

    public GoogleCloudPlatformCalculatingResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(), 'Email Estimate')]")
    private WebElement emailEstimateButton;

    public GoogleCloudEmailEstimatePage sendEstimateByEmail(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return new GoogleCloudEmailEstimatePage(driver);
    }
}
