package hardcore_task_without_steps.test;

import hardcore_task_without_steps.page.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleCloudTest {
    private WebDriver webDriver;
    private final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void startingSearch() {
        GoogleCloudEmailEstimatePage page = new GoogleCloudHomePage(webDriver)
                .openPage()
                .searchForTerm(SEARCH_QUERY)
                .openCorrespondingResult()
                .fillTheForm(4)
                .sendEstimateByEmail();

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.open()");
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));

        YopmailEmailGeneratorPage yopmailEmailGeneratorPage = new YopmailPage(webDriver).openPage().createEmail();
        String emailAddress = yopmailEmailGeneratorPage.getEmail();
        webDriver.switchTo().window(handles.get(0));

        page.sendEmail(emailAddress);
        webDriver.switchTo().window(handles.get(1));
        String result = yopmailEmailGeneratorPage.checkEmail().getResultPriceFromEmail();
        Assert.assertTrue(result.contains("1,085.25"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        webDriver.quit();
        webDriver = null;
    }
}
