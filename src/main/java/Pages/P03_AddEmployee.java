package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class P03_AddEmployee extends PageBase {


    //Define constractor
    public P03_AddEmployee(WebDriver driver) {

        super(driver);
    }

    private By addEmp = By.xpath("//button[normalize-space()='Add']");
    private By EmpFirstName = By.xpath("//input[@placeholder='First Name']");
    private By EmpMiddName = By.xpath("//input[@placeholder='Middle Name']");
    private By EmpLastName = By.xpath("//input[@placeholder='Last Name']");
    private By EmployeeId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");
    private By addEmpSuccessMsg = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    private By SuccessMsg = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
    private By recordsFound = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private By searchEmpName = By.xpath("//input[@placeholder=\"Type for hints...\"][1]");
    private By searchButton = By.xpath("//button[normalize-space()='Search']");
    private By dropdownLocator = By.xpath("//div[@role='listbox']");

    private By firstOptionLocator = By.xpath("//div[@role='listbox']//div[@role='option'][1]");

    public P03_AddEmployee clickingAddingEmp() {
        longWait(ExpectedConditions.elementToBeClickable(this.addEmp)).click();
        return this;
    }


    public P03_AddEmployee fillEmpFirstName(String FirstName) {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.EmpFirstName)).sendKeys(FirstName);
        System.out.println("First Name : " + FirstName);
        return this;
    }

    public P03_AddEmployee fillEmpMiddName(String MiddName) {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.EmpMiddName)).sendKeys(MiddName);
        System.out.println("Middle Name : " + MiddName);

        return this;
    }

    public P03_AddEmployee fillEmpLastName(String LastName) {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.EmpLastName)).sendKeys(LastName);
        System.out.println("Last Name : " + LastName);

        return this;
    }

    public P03_AddEmployee fillEmployeeId(String empId) {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.EmployeeId)).sendKeys(empId);
        return this;
    }

    public P03_AddEmployee clickingSaveButton() {
        longWait(ExpectedConditions.elementToBeClickable(this.saveButton)).click();
        return this;
    }

    public P03_AddEmployee empAddedToast() {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.addEmpSuccessMsg)).isDisplayed();
        System.out.println(longWait(ExpectedConditions.visibilityOfElementLocated(this.SuccessMsg)).getText());
        return this;
    }

    public int recordsFoundShow() {
        String recordsText = longWait(ExpectedConditions.visibilityOfElementLocated(this.recordsFound))
                .getText()
                .trim();

        System.out.println("Records Found Text: " + recordsText);

        // Extract the number from text like "(2) Records Found"
        String numberStr = recordsText.replaceAll("[^0-9]", "");
        int count = numberStr.isEmpty() ? 0 : Integer.parseInt(numberStr);

        System.out.println("Extracted Count: " + count);
        return count;
    }

    public P03_AddEmployee searchEmployeeName(String EmpName) {
        WebElement empNameField = longWait(ExpectedConditions.visibilityOfElementLocated(this.searchEmpName));
        empNameField.sendKeys(EmpName);


        // Wait longer for dropdown
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Try clicking the first option directly
        try {
            WebElement firstOption = longWait(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div[role='listbox'] div[role='option']")
            ));
            firstOption.click();
        } catch (Exception e) {
            // Fallback to keyboard navigation
            empNameField.sendKeys(Keys.ARROW_DOWN);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            empNameField.sendKeys(Keys.ENTER);
        }
        return this;
    }


    public P03_AddEmployee searchButton() {
        longWait(ExpectedConditions.elementToBeClickable(this.searchButton)).click();
        return this;
    }
}







