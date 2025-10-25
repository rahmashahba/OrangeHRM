package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class P04_AddAdmin extends PageBase {


    //Define constractor
    public P04_AddAdmin(WebDriver driver) {

        super(driver);
    }

    private By addAdmin = By.xpath("//button[normalize-space()='Add']");
    private By userRole = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private By userStatus = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    private By EmpName = By.xpath("//input[@placeholder='Type for hints...']");
    private By EmpUsername = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By password = By.xpath("(//input[@type='password'])[1]");
    private By ConfirmPassword = By.xpath("(//input[@type='password'])[2]");
    private By SaveButton = By.xpath("(//button[normalize-space()='Save'])[1]");
    private By successmsg = By.xpath("(//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text'])[1]");



    public P04_AddAdmin clickingAddingAdmin() {
        longWait(ExpectedConditions.elementToBeClickable(this.addAdmin)).click();
        return this;
    }

    public P04_AddAdmin clickingUserStatus()  {
        longWait(ExpectedConditions.elementToBeClickable(this.userStatus)).click();
        // Get all dropdown options
        List<WebElement> options = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector("div[role='option']")
                )
        );

        // Filter out "-- Select --" option
        List<WebElement> validOptions = options.stream()
                .filter(option -> {
                    String text = option.getText().trim();
                    return !text.isEmpty() &&
                            !text.equals("-- Select --") &&
                            !text.contains("Select");
                })
                .collect(Collectors.toList());

        if (validOptions.isEmpty()) {
            System.out.println("No valid options found in dropdown");
        }
        // Select a random option
        Random random = new Random();
        int randomIndex = random.nextInt(validOptions.size());
        WebElement randomOption = validOptions.get(randomIndex);
        String selectedText = randomOption.getText().trim();
        System.out.println("Selecting random option: " + selectedText);

        // Click the random option
        randomOption.click();

        return this;
    }

    public P04_AddAdmin clickingUserRole()  {
        longWait(ExpectedConditions.elementToBeClickable(this.userRole)).click();
        // Get all dropdown options
        List<WebElement> options = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector("div[role='option']")
                )
        );

        // Filter out "-- Select --" option
        List<WebElement> validOptions = options.stream()
                .filter(option -> {
                    String text = option.getText().trim();
                    return !text.isEmpty() &&
                            !text.equals("-- Select --") &&
                            !text.contains("Select");
                })
                .collect(Collectors.toList());

        if (validOptions.isEmpty()) {
            System.out.println("No valid options found in dropdown");
        }
        // Select a random option
        Random random = new Random();
        int randomIndex = random.nextInt(validOptions.size());
        WebElement randomOption = validOptions.get(randomIndex);
        String selectedText = randomOption.getText().trim();
        System.out.println("Selecting random option: " + selectedText);

        // Click the random option
        randomOption.click();

        return this;
    }

    public P04_AddAdmin FillEmpName(String UserName) {
        WebElement empNameField = longWait(ExpectedConditions.visibilityOfElementLocated(this.EmpName));
        empNameField.clear();
        empNameField.click();
        empNameField.sendKeys(UserName);

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
    public P04_AddAdmin FillUsername(String UserName) {
    longWait(ExpectedConditions.visibilityOfElementLocated(this.EmpUsername)).sendKeys(UserName);

        return this;
    }
    public P04_AddAdmin FillPassword(String password) {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(password);
        return this;
    }
    public P04_AddAdmin FillConfirmPassword(String Confirm_password ) {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.ConfirmPassword)).sendKeys(Confirm_password);
        return this;
    }
    public P04_AddAdmin clickingSave() {
        longWait(ExpectedConditions.elementToBeClickable(this.SaveButton)).click();
        return this;
    }
    public P04_AddAdmin empAddedToastsucess() {
        longWait(ExpectedConditions.visibilityOfElementLocated(this.successmsg)).isDisplayed();
        System.out.println(longWait(ExpectedConditions.visibilityOfElementLocated(this.successmsg)).getText());
        return this;
    }

}







