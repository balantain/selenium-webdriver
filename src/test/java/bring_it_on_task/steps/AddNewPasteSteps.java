package bring_it_on_task.steps;

import bring_it_on_task.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;

public class AddNewPasteSteps {

    private WebDriver webDriver;
    private PastebinHomePage page;

    public AddNewPasteSteps(WebDriver webDriver, PastebinHomePage page) {
        this.webDriver = webDriver;
        this.page = page;
    }

    public void addNewPaste(String post, String name){
        page.closeBanner();
        page.fillInTextInForm(post);
        page.selectSyntaxHighlight();
        page.selectExpirationTime();
        page.fillInPasteName(name);
        page.submitInput();
    }
}
