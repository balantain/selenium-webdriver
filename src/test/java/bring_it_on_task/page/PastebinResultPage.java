package bring_it_on_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//textarea")
    private WebElement postText;

    // in case vpn
    @FindBy(xpath = "//button[text()=\"AGREE\"]")
    private WebElement cookiesAgreement;

    @FindBy(xpath = "//div[@class='highlighted-code']//a")
    private WebElement syntaxHighlight;

    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPasteText(){
//        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(cookiesAgreement));
//        cookiesAgreement.click();
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(postText)).getText();
    }

    public String getPasteSyntaxHighlight(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(syntaxHighlight)).getText();
    }

    public String getPostTitle(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("developers"));
        return driver.getTitle();
    }
}
