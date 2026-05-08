package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends Base {

    private final By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private final By timeAtWork = By.xpath("//p[text()='Time at Work']");
    private final By quickLaunch = By.xpath("//p[text()='Quick Launch']");

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isDashboardTitleVisible() {
        waitForElement(dashboardTitle);
        return isDisplayed(dashboardTitle);
    }

    public boolean areWidgetsVisible() {
        waitForElement(timeAtWork);
        waitForElement(quickLaunch);
        return isDisplayed(timeAtWork) && isDisplayed(quickLaunch);
    }

    public String getDashboardUrl() {
        waitForUrlContains("dashboard");
        return getCurrentUrl();
    }
}
