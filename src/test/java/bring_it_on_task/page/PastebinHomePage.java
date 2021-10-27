package bring_it_on_task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private WebDriver driver;
    private final static String PASTEBIN_URL = "https://pastebin.com/";

    @FindBy(id = "hideSlideBanner")
    private WebElement slideBannerExit;

    @FindBy(id = "postform-text")
    private WebElement postFormTextInput;

    @FindBy(xpath = "//div[@class='form-group field-postform-format']//span[@class='select2-selection select2-selection--single']")
    private WebElement syntaxHighlightingDropdownMenu;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingLanguage;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection select2-selection--single']")
    private WebElement pasteExpirationDropdownMenu;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement expirationTime;

    @FindBy(xpath = "//input[@id='postform-name']")
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
    //in case VPN
//        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(cookiesAgreement));
//        cookiesAgreement.click();
        return this;
    }

    public void fillInTextInForm(String text){
        postFormTextInput.sendKeys(text);
    }

    public void selectSyntaxHighlight(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(syntaxHighlightingDropdownMenu)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(syntaxHighlightingLanguage)).click();
    }

    public void selectExpirationTime(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(pasteExpirationDropdownMenu)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(expirationTime)).click();
    }

    public void fillInPasteName(String name){
        postFormName.sendKeys(name);
    }

    public void submitInput(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public void closeBanner(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(slideBannerExit)).click();
    }
}
