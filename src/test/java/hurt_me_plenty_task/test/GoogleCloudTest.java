package hurt_me_plenty_task.test;

import hurt_me_plenty_task.page.GoogleCloudHomePage;
import hurt_me_plenty_task.page.GoogleCloudPlatformCalculatingResults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleCloudTest {
    WebDriver webDriver;
    private final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void startingSearch() {
        GoogleCloudPlatformCalculatingResults results = new GoogleCloudHomePage(webDriver)
                .openPage()
                .searchForTerm(SEARCH_QUERY)
                .openCorrespondingResult()
                .fillTheForm(4);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(results.getVMClass().contains("regular"), "VM class in estimate doesn't match regular!");
        softAssert.assertTrue(results.getInstanceType().contains("n1-standard-8"), "Instance type in estimate doesn't match \"n1 - standard - 8\"!");
        softAssert.assertTrue(results.getRegion().contains("Frankfurt"), "Region in estimate doesn't match \"Frankfurt\"");
        softAssert.assertTrue(results.getLocalSSDValue().contains("2x375 GiB"), "Local SSD value in estimate doesn't match \"2x375 GiB\"");
        softAssert.assertTrue(results.getCommitmentTermValue().contains("1 Year"), "Commitment term in estimate doesn't match 1 year");
        softAssert.assertTrue(results.getTotalEstimatedCostValue().contains("1,085.25"), "Total Estimated Cost Value doesn't match 1,085.25");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        webDriver.quit();
        webDriver = null;
    }
}
