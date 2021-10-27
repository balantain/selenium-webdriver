package hardcore_task_with_steps_package.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailMailBoxPage extends AbstractPage{

    @FindBy(xpath = "//div[@id='mail']//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement mailTitle;

    @FindBy(xpath = "//iframe[@name='ifmail']")
    private WebElement mailFrame;

    @FindBy(xpath = "//div[@id='message']")
    private WebElement message;

    public YopmailMailBoxPage(WebDriver driver) {
        super(driver);
    }

    public String getResultPriceFromEmail(){
        for (int i = 0; i < 5; i++){
            if (message.getText().contains("Этот почтовый ящик пуст")){
                driver.navigate().refresh();
            }
            else break;
        }
        new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(mailFrame));
        driver.switchTo().frame(mailFrame);
        return new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(mailTitle)).getText();
    }
}
