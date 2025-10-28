package TCs;


import Pages.P01_Login_orangehrm;
import Pages.P02_sideMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.PageBase.captureScreenshot;

import static drivers.DriverHolder.getDriver;

public class TC02_dashboard extends testbase {


    TC02_dashboard loginPage;
    String password = "admin123";
    private P02_sideMenu sideMenu;

    @Test(priority = 1, description = "Log in with vailed credentials successfully!")
    public void viewAdminModule() throws InterruptedException {
        new P02_sideMenu(getDriver()).viewAdminModule();
        boolean isLoginValid_1 = new P01_Login_orangehrm(getDriver()).vaild_login();
        boolean isLoginValid_2 = new P01_Login_orangehrm(getDriver()).vaild_login();

        captureScreenshot(getDriver(), "logged in screenshoot");
        Assert.assertTrue(isLoginValid_1, "Login with valid credentials!");
        Assert.assertTrue(isLoginValid_2, "Login with valid credentials!");

        sideMenu = new P02_sideMenu(getDriver());
        String headerText = sideMenu.getName();
        String dashboard = sideMenu.logged_in_dashboard();
        System.out.println("Header text: " + headerText);
        System.out.println("dashboard: " + dashboard);
    }

    @Test(priority = 1, description = "Logged in user assert on side menu successfully!")
    public void assertLoggedInUserSideMenu() throws InterruptedException {


        new P02_sideMenu(getDriver()).pim().leave().time().recruitment().myInfo().prformance().dashboard().directory().maintenance();
        new P02_sideMenu(getDriver()).fillPassword(password).clickConfirmButton();
        new P02_sideMenu(getDriver()).claim().buzz();


    }
}
