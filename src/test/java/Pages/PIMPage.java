package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage extends Base {

    private final By employeeTable = By.xpath("//div[@class='oxd-table-body']");
    private final By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By employmentStatusDropdown = By.xpath("//label[text()='Employment Status']/following::div[1]");
    private final By fullTimeOption = By.xpath("//div[@role='option']//span[text()='Full-Time Permanent']");
    private final By selectedEmploymentStatus = By.xpath("//label[contains(text(),'Employment Status')]/following::div[1]//div[contains(@class,'oxd-select-text')]");

    public PIMPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isEmployeeTableVisible() {
        waitForElement(employeeTable);
        return isDisplayed(employeeTable);
    }

    public void searchEmployee(String name) {
        type(employeeNameInput, name);
        click(searchButton);
    }

    public boolean areSearchResultsVisible() {
        waitForElement(employeeTable);
        return isDisplayed(employeeTable);
    }

    public void selectEmploymentStatus() {
        click(employmentStatusDropdown);
        waitForElement(fullTimeOption);
        click(fullTimeOption);
    }

    public String getSelectedEmploymentStatus() {
        waitForElement(selectedEmploymentStatus);
        return getText(selectedEmploymentStatus);
    }
}
