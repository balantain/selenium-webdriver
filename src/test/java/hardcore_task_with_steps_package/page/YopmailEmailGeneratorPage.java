package hardcore_task_with_steps_package.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailEmailGeneratorPage extends AbstractPage{

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='egen']")
    private WebElement email;

    @FindBy(xpath = "//span[contains(text(), \'Проверить почту\')]/..")
    private WebElement checkEmailButton;

    public String getEmail(){
        return new WebDriverWait(driver, WAITING_TIME).until(ExpectedConditions.visibilityOf(email)).getText();
    }

    public YopmailMailBoxPage checkEmail(){
        checkEmailButton.click();
        return new YopmailMailBoxPage(driver);
    }
}
