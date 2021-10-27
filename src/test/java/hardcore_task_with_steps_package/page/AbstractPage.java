package hardcore_task_with_steps_package.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAITING_TIME = 10;

    public int getWAITING_TIME() {
        return WAITING_TIME;
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
