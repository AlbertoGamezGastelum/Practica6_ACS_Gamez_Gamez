package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By txtUsername = By.name("username");
    private final By txtPassword = By.name("password");
    private final By btnLogin = By.xpath("//button[contains(@class,'orangehrm-login-button')]");
    private final By errorMessage = By.xpath("//div[@role='alert']//p");
    private final By requiredMessages = By.xpath("//span[text()='Required']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername)).clear();
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).clear();
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public int getRequiredMessageCount() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(requiredMessages));
            return driver.findElements(requiredMessages).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isUsernameFieldDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordFieldDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
