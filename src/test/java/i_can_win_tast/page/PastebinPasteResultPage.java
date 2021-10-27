package i_can_win_tast.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPasteResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//textarea")
    private WebElement postText;

    //in case we use VPN
    @FindBy(xpath = "//button[text()=\"AGREE\"]")
    private WebElement cookiesAgreement;

    public PastebinPasteResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPasteText(){
        //in case we use VPN
//        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(cookiesAgreement));
//        cookiesAgreement.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//textarea"), "Hello from WebDriver"));
        return postText.getText();
    }
}
