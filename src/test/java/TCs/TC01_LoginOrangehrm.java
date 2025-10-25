package TCs;


import Pages.P01_Login_orangehrm;
import org.testng.Assert;
import org.testng.annotations.Test;
import static drivers.DriverHolder.getDriver;


public class TC01_LoginOrangehrm extends testbase {


    String username = "Admin";
    String password = "admin123";

    @Test(priority = 1, description = "Log in with vailed credentials successfully!")
    public void LoginWithvViledCredentials_P() throws InterruptedException {
        new P01_Login_orangehrm(getDriver()).fillUsername(username).fillPassword(password).clickLoginButton();
        boolean isLoginValid = new P01_Login_orangehrm(getDriver()).vaild_login();
        Assert.assertTrue(isLoginValid, "Login with valid credentials!");


        //  Assert.assertTrue(new P01_Login_orangehrm(getDriver()).vaild_login("Log in with vailed credentials successfully!"));

    }

    // Negative test case - verify logout when already logged out
    @Test(priority = 2, description = "Log in with Invailed username")
    public void LoginWithInvailedUserName_N() throws InterruptedException {

        username = "TEST";
        P01_Login_orangehrm loginPage = new P01_Login_orangehrm(getDriver()).fillUsername("TEST").fillPassword("TEST").clickLoginButton();
        new P01_Login_orangehrm(getDriver()).print_error_msg();
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError,
                "Invalid credentials",
                "Invalid credentials");
    }

    @Test(priority = 3, description = "Log in with Invailed password")
    public void LoginWithInvailedPassword_N() throws InterruptedException {
        //Thread.sleep(1000);
        password = "TEST";
        P01_Login_orangehrm loginPage = new P01_Login_orangehrm(getDriver()).fillUsername(username).fillPassword(password).clickLoginButton();
        //Thread.sleep(4000);

        new P01_Login_orangehrm(getDriver()).print_error_msg();
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError,
                "Invalid credentials",
                "Invalid credentials");
    }

    @Test(priority = 4, description = "Log in with Invailed credentials")
    public void LoginWithInvailedcredentials_N() throws InterruptedException {
        //Thread.sleep(1000);
        password = "TEST";
        username = "TEST";
        P01_Login_orangehrm loginPage = new P01_Login_orangehrm(getDriver()).fillUsername(username).fillPassword(password).clickLoginButton();
        //Thread.sleep(4000);

        new P01_Login_orangehrm(getDriver()).print_error_msg();
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError,
                "Invalid credentials",
                "Invalid credentials");

    }
}
