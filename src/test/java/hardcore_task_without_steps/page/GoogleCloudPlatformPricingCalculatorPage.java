package hardcore_task_without_steps.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {
    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(), \"Number of instances\")]/.././/input[@name='quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(), \"Series\")]/..//md-select-value[@class='md-select-value']")
    private WebElement seriesField;

    @FindBy(xpath = "//div[contains(text(), 'N1')]/..")
    private WebElement seriesSelection;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(), \"Machine type\")]/..//md-select-value[@class='md-select-value']")
    private WebElement machineTypeField;

    @FindBy(xpath = "//div[contains(text(), 'n1-standard-8')]")
    private WebElement getMachineTypeSelection;

    @FindBy(xpath = "//div[@class='ng-scope layout-row']//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUMenu;

    @FindBy(xpath = "//md-option[contains(@ng-repeat, 'GpuNumbers')]/div[contains(text(), '1')]/..")
    private WebElement numberOfGPUSelection;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeMenu;

    @FindBy(xpath = "//*[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuTypeSelection;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDMenu;

    @FindBy(xpath = "//div[contains(text(), '2x375 GB')]" )
    private WebElement getLocalSSDSelection;

    @FindBy(xpath = "//md-select[contains(@placeholder, 'Datacenter location')]")
    private WebElement datacenterLocationMenu;

    @FindBy(xpath = "//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']//div[contains(text(), 'Frankfurt')]/..")
    private WebElement getDatacenterLocationSelection;

    @FindBy(xpath = "//md-select[contains(@placeholder, 'Committed usage')]")
    private WebElement committedUsageMenu;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(), '1 Year')]")
    private WebElement getCommittedUsageSelection;

    @FindBy(xpath = "//div[@class='compute-engine-block']//form[@name='ComputeEngineForm']//button[contains(text(), 'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public GoogleCloudPlatformCalculatingResultsPage fillTheForm(int instances){
        driver.switchTo()
                .frame(new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe"))));
        driver.switchTo()
                .frame(new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id=\'myFrame\']"))));
        fillInNumberOfInstances(4);
        chooseSeries();
        chooseMachineType();
        addGPUs();
        addNumberOfGPUs();
        addGPUTypes();
        addLocalSSD();
        addDataCenterLocation();
        chooseCommittedUsage();
        addToEstimate();
        return new GoogleCloudPlatformCalculatingResultsPage(driver);
    }

    public void fillInNumberOfInstances(int numberOfInstances){
        numberOfInstancesField.sendKeys(String.valueOf(numberOfInstances));
    }

    public void chooseSeries(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(seriesField)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(seriesSelection)).click();
    }

    public void chooseMachineType(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(machineTypeField)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(getMachineTypeSelection)).click();
    }

    public void addGPUs(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(addGPUCheckbox)).click();
    }

    public void addNumberOfGPUs(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(numberOfGPUMenu)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(numberOfGPUSelection)).click();
    }

    public void addGPUTypes(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(gpuTypeMenu)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(gpuTypeSelection)).click();
    }

    public void addLocalSSD(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(localSSDMenu)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(getLocalSSDSelection)).click();
    }

    public void addDataCenterLocation(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(datacenterLocationMenu)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.elementToBeClickable(getDatacenterLocationSelection)).click();
    }

    public void chooseCommittedUsage(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(committedUsageMenu)).click();
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(getCommittedUsageSelection)).click();
    }

    public void addToEstimate(){
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.elementToBeClickable(addToEstimateButton)).click();
    }
}
