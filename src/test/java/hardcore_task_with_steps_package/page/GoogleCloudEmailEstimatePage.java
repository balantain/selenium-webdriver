package hardcore_task_with_steps_package.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudEmailEstimatePage extends AbstractPage{

    public GoogleCloudEmailEstimatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailBtn;

    public void sendEmail(String emailAddress){
        driver.switchTo()
                .frame(new WebDriverWait(driver, WAITING_TIME)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe"))));
        driver.switchTo()
                .frame(new WebDriverWait(driver, WAITING_TIME)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id=\'myFrame\']"))));
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(emailAddressField)).sendKeys(emailAddress);
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.elementToBeClickable(sendEmailBtn)).click();
    }
}
