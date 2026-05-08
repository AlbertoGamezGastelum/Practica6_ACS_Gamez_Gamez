package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends Base {

    private final By userTable = By.xpath("//div[@class='oxd-table-body']");
    private final By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[1]");
    private final By adminOption = By.xpath("//div[@role='option']//span[text()='Admin']");
    private final By selectedUserRole = By.xpath("//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isUserTableVisible() {
        waitForElement(userTable);
        return isDisplayed(userTable);
    }

    public void selectUserRoleAdmin() {
        click(userRoleDropdown);
        waitForElement(adminOption);
        click(adminOption);
    }

    public String getSelectedUserRole() {
        waitForElement(selectedUserRole);
        return getText(selectedUserRole);
    }
}
