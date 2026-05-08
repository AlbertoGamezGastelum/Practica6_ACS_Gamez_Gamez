package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage extends Base {

    private final By vacanciesTab = By.xpath("//a[contains(text(),'Vacancies')]");
    private final By addButton = By.xpath("//button[contains(.,'Add')]");
    private final By jobTitleDropdown = By.xpath("//label[text()='Job Title']/following::div[1]");
    private final By firstOption = By.xpath("(//div[@role='option'])[1]");
    private final By selectedJobTitle = By.xpath("//label[text()='Job Title']/following::div[1]//div[contains(@class,'oxd-select-text')]");

    public RecruitmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isRecruitmentLoaded() {
        waitForUrlContains("recruitment");
        return getCurrentUrl().contains("recruitment");
    }

    public void goToVacancies() {
        click(vacanciesTab);
    }

    public boolean isAddButtonVisible() {
        waitForElement(addButton);
        return isDisplayed(addButton);
    }

    public void selectJobTitle() {
        click(jobTitleDropdown);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstOption));
        wait.until(ExpectedConditions.elementToBeClickable(firstOption));
        driver.findElement(firstOption).click();
    }

    public boolean isJobTitleSelected() {
        waitForElement(selectedJobTitle);
        return !getText(selectedJobTitle).isEmpty();
    }
}
