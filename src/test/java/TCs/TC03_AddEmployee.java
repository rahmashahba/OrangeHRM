package TCs;

import Pages.P02_sideMenu;
import Pages.P03_AddEmployee;
import Pages.P04_AddAdmin;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

//import static drivers.DriverHolder.getDriver;

public class TC03_AddEmployee extends testbase {


    String first_name = faker.name().firstName();
    String middle_name = faker.name().nameWithMiddle();
    String last_name = faker.name().lastName();
    String empId = faker.name().prefix();
    String username1 = faker.regexify("[a-zA-Z0-9]{5,10}");
    String password1 =faker.internet().password();
    // Negative test case - verify logout when already logged out
    @Test(priority = 1, description = "Log in with Invailed username")
    public void verifyUserCanAddEmployeeSuccessfully() throws InterruptedException {

        new P02_sideMenu(getDriver()).pim();
        new P03_AddEmployee(getDriver()).clickingAddingEmp();
        new P03_AddEmployee(getDriver()).fillEmpFirstName(first_name).fillEmpMiddName(middle_name).fillEmpLastName(last_name).fillEmployeeId(empId).clickingSaveButton();
        new P03_AddEmployee(getDriver()).empAddedToast();
        int recordsFoundShow = new P03_AddEmployee(getDriver()).recordsFoundShow();

        new P02_sideMenu(getDriver()).pim();
        new P03_AddEmployee(getDriver()).recordsFoundShow();
        new P03_AddEmployee(getDriver()).searchEmployeeName(first_name);
        Thread.sleep(4000);
        new P03_AddEmployee(getDriver()).searchButton();
        new P03_AddEmployee(getDriver()).recordsFoundShow();

        new P02_sideMenu(getDriver()).viewAdminModule();
        new P04_AddAdmin(getDriver()).clickingAddingAdmin();
        new P04_AddAdmin(getDriver()).FillEmpName(first_name);
        new P04_AddAdmin(getDriver()).FillUsername(username1);

        new P04_AddAdmin(getDriver()).clickingUserRole();
        new P04_AddAdmin(getDriver()).clickingUserStatus();
        new P04_AddAdmin(getDriver()).FillPassword(password1);
        new P04_AddAdmin(getDriver()).FillConfirmPassword(password1);

        System.out.println("Username: " + username1);
        System.out.println("password: " + password1);

        new P04_AddAdmin(getDriver()).clickingSave();
        new P04_AddAdmin(getDriver()).empAddedToastsucess();



    }




}
