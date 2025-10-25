package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P01_Login_orangehrm extends PageBase {


    //Define constractor
    public P01_Login_orangehrm(WebDriver driver) {

        super(driver);
    }

    //Define locators
    private final By userNameF = By.xpath("//input[@placeholder='Username']");
    private final By passwordF = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By error_msg = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    private final By profile = By.xpath("//span[@class='oxd-userdropdown-tab']");

    //public action method
    public P01_Login_orangehrm fillUsername(String userName) {

        shortWait(ExpectedConditions.visibilityOfElementLocated(this.userNameF)).sendKeys(userName);
        return this;

    }

    public P01_Login_orangehrm fillPassword(String password) throws InterruptedException {

        shortWait(ExpectedConditions.visibilityOfElementLocated(this.passwordF)).sendKeys(password);


        return this;
    }

    public P01_Login_orangehrm clickLoginButton() {

        longWait(ExpectedConditions.elementToBeClickable(this.loginButton)).click();
        return this;
    }


    public String getErrorMessage() {
        try {
            return shortWait(ExpectedConditions.visibilityOfElementLocated(this.error_msg)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public P01_Login_orangehrm print_error_msg() throws InterruptedException {
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.error_msg)).getText());
        return this;
    }

    public boolean vaild_login() throws InterruptedException {
        Thread.sleep(3000);
        try {
            return longWait(ExpectedConditions.visibilityOfElementLocated(this.profile)).isDisplayed();
        } catch (NoSuchElementException e) {

            System.out.println("Failed log in");
            return false;
        }
    }


}
