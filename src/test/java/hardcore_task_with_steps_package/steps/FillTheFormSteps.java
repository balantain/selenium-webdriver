package hardcore_task_with_steps_package.steps;

import hardcore_task_with_steps_package.page.GoogleCloudPlatformPricingCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillTheFormSteps {
    private WebDriver driver;
    private GoogleCloudPlatformPricingCalculatorPage page;

    public FillTheFormSteps(WebDriver driver, GoogleCloudPlatformPricingCalculatorPage page) {
        this.driver = driver;
        this.page = page;
    }

    public void fillTheForm(int instances){
        driver.switchTo()
                .frame(new WebDriverWait(driver, page.getWAITING_TIME())
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe"))));
        driver.switchTo()
                .frame(new WebDriverWait(driver, page.getWAITING_TIME())
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id=\'myFrame\']"))));
        page.fillInNumberOfInstances(instances);
        page.chooseSeries();
        page.chooseMachineType();
        page.addGPUs();
        page.addNumberOfGPUs();
        page.addGPUTypes();
        page.addLocalSSD();
        page.addDataCenterLocation();
        page.chooseCommittedUsage();
        page.addToEstimate();
    }
}
