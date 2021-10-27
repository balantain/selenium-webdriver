package bring_it_on_task.test;

import bring_it_on_task.page.PastebinHomePage;
import bring_it_on_task.page.PastebinResultPage;
import bring_it_on_task.steps.AddNewPasteSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebDriverPastebinTest {
    private WebDriver driver;
    private final static String PASTE_TEXT =
            "git config --global user.name \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private final static String PASTE_NAME = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void startingBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Testing if the results of pasting correspond conditions")
    public void checkPastingResults(){
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver).openPage();
        AddNewPasteSteps addNewPasteSteps = new AddNewPasteSteps(driver, pastebinHomePage);
        addNewPasteSteps.addNewPaste(PASTE_TEXT, PASTE_NAME);
        PastebinResultPage pastebinResultPage = new PastebinResultPage(driver);

        String actualPageTitle = pastebinResultPage.getPostTitle().replace(" - Pastebin.com", "");
        String actualSyntax = pastebinResultPage.getPasteSyntaxHighlight();
        String actualPasteText = pastebinResultPage.getPasteText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualPageTitle, PASTE_NAME, "Actual page title doesn't match expected");
        softAssert.assertEquals(actualSyntax, "Bash", "Actual syntax doesn't match expected");
        softAssert.assertEquals(actualPasteText, PASTE_TEXT, "Actual syntax doesn't match expected");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver = null;
    }
}
