package i_can_win_tast.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private WebDriver driver;
    private final String PASTEBIN_URL = "https://pastebin.com/";

    @FindBy(id = "hideSlideBanner")
    private WebElement slideBannerExit;

    @FindBy(id = "postform-text")
    private WebElement postFormTextInput;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']//span[contains(@class,\"arrow\")]")
    private WebElement expirationDropdownMenu;

    @FindBy(xpath="//li[text()=\"10 Minutes\"]")
    private WebElement expirationTime;

    @FindBy(id="postform-name")
    private WebElement postFormName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    //in case we use VPN
    @FindBy(xpath = "//button[text()=\"AGREE\"]")
    private WebElement cookiesAgreement;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage(){
        driver.get(PASTEBIN_URL);
//  in case VPN
//        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(cookiesAgreement));
//        cookiesAgreement.click();
        return this;
    }

    public PastebinPasteResultPage addNewPaste (String post, String name){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(slideBannerExit)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(postFormTextInput)).sendKeys(post);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(expirationDropdownMenu)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(expirationDropdownMenu)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(postFormName)).sendKeys(name);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return new PastebinPasteResultPage(driver);
    }
}
