package i_can_win_tast.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import i_can_win_tast.page.PastebinHomePage;

public class WebDriverPastebinTest {
    private WebDriver driver;
    private final static String PASTE_TEXT = "Hello from WebDriver";
    private final static String PASTE_NAME = "helloweb";

    @BeforeMethod(alwaysRun = true)
    public void startingBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Adding new paste at pastebin.com")
    public void postIsPasted(){
        String actualText = new PastebinHomePage(driver).openPage().addNewPaste(PASTE_TEXT, PASTE_NAME).getPasteText();
        System.out.println("EXPECTED: " + actualText);
        Assert.assertEquals(actualText, PASTE_TEXT, "Posted text doesn't match text info");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver = null;
    }
}
