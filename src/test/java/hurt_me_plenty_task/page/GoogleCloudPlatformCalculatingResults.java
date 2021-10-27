package hurt_me_plenty_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformCalculatingResults extends AbstractPage{

    @FindBy(xpath = "//div[contains(text(), 'VM class')]")
    private WebElement vmClassValue;

    @FindBy(xpath = "//div[contains(text(), 'Instance type')]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[contains(text(), 'Region')]")
    private WebElement region;

    @FindBy(xpath = "//div[contains(text(), 'Local SSD')]")
    private WebElement localSSDValue;

    @FindBy(xpath = "//div[contains(text(), 'Commitment term')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//*[contains(text(), 'Total Estimated Cost')]")
    private WebElement totalEstimatedCost;

    public GoogleCloudPlatformCalculatingResults(WebDriver driver) {
        super(driver);
    }
    public String getVMClass(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(vmClassValue)).getText();
    }

    public String getInstanceType(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(instanceType)).getText();
    }

    public String getRegion(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(region)).getText();
    }

    public String getLocalSSDValue(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(localSSDValue)).getText();
    }

    public String getCommitmentTermValue(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(commitmentTerm)).getText();
    }

    public String getTotalEstimatedCostValue(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(totalEstimatedCost)).getText();
    }
}
