package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P02_sideMenu extends PageBase {


    private WebDriver driver;
    private By viewAdminModule = By.xpath("//span[text()=\"Admin\"]");
    private By userName = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By pim = By.xpath("//span[text()=\"PIM\"]");
    private By pim_header = By.xpath("//h6[normalize-space()='PIM']");
    private By leave = By.xpath("//span[text()=\"Leave\"]");
    private By leave_header = By.xpath("//h6[normalize-space()='Leave']");
    private By time = By.xpath("//span[text()=\"Time\"]");
    private By time_header = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']");
    private By recruitment = By.xpath("//span[text()=\"Recruitment\"]");
    private By Recruitment_header = By.xpath("//h6[normalize-space()='Recruitment']");
    private By myInfo = By.xpath("//span[text()=\"My Info\"]");
    private By prformance_header = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");

    private By prformance = By.xpath("//span[text()=\"Performance\"]");

    private By dashboard = By.xpath("//span[text()=\"Dashboard\"]");

    private By directory = By.xpath("//span[text()=\"Directory\"]");

    private By maintenance = By.xpath("//span[text()=\"Maintenance\"]");
    private By maintenance_header = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");

    private By claim = By.xpath("//span[text()=\"Claim\"]");
    private By buzz = By.xpath("//span[normalize-space()='Buzz']");
    private By headerTitle = By.xpath("//div[@class='oxd-topbar-header-title']");
    private By password = By.xpath("//input[@type='password']");
    private By confirmButton = By.xpath("//button[@type='submit']");

    //private final By dashboard  = By.xpath("//h6[normalize-space()='Dashboard']");


    //Define constractor
    public P02_sideMenu(WebDriver driver) {

        super(driver);
    }


    public String getName() {
            return longWait(ExpectedConditions.visibilityOfElementLocated(this.userName)).getText();
    }

    public String logged_in_dashboard() {
        try {
            return longWait(ExpectedConditions.visibilityOfElementLocated(this.dashboard)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public P02_sideMenu viewAdminModule() {
        longWait(ExpectedConditions.elementToBeClickable(this.viewAdminModule)).click();
        return this;
    }


    public P02_sideMenu pim() {

        longWait(ExpectedConditions.elementToBeClickable(this.pim)).click();
        System.out.println(longWait(ExpectedConditions.visibilityOfElementLocated(this.pim_header)).getText());


        return this;
    }

    public P02_sideMenu leave() {

        longWait(ExpectedConditions.elementToBeClickable(this.leave)).click();
        System.out.println(longWait(ExpectedConditions.visibilityOfElementLocated(this.leave_header)).getText());


        return this;
    }

    public P02_sideMenu time() {

        longWait(ExpectedConditions.elementToBeClickable(this.time)).click();
        System.out.println(longWait(ExpectedConditions.visibilityOfElementLocated(this.time_header)).getText());


        return this;
    }

    public P02_sideMenu recruitment() {
        shortWait(ExpectedConditions.elementToBeClickable(this.recruitment)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.Recruitment_header)).getText());
        return this;
    }

    public P02_sideMenu myInfo() {

        shortWait(ExpectedConditions.elementToBeClickable(this.myInfo)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.myInfo)).getText());

        return this;
    }


    public P02_sideMenu prformance() {

        shortWait(ExpectedConditions.elementToBeClickable(this.prformance)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.prformance_header)).getText());


        return this;
    }

    public P02_sideMenu dashboard() {

        shortWait(ExpectedConditions.elementToBeClickable(this.dashboard)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.dashboard)).getText());


        return this;
    }

    public P02_sideMenu directory() {

        shortWait(ExpectedConditions.elementToBeClickable(this.directory)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.directory)).getText());

        return this;
    }

    public P02_sideMenu maintenance() {

        shortWait(ExpectedConditions.elementToBeClickable(this.maintenance)).click();

        return this;
    }

    public P02_sideMenu clickConfirmButton() {
        shortWait(ExpectedConditions.elementToBeClickable(this.confirmButton)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.maintenance_header)).getText());
        return this;
    }

    public P02_sideMenu fillPassword(String password) {
        shortWait(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(password);
        return this;
    }


    public P02_sideMenu claim() {

        shortWait(ExpectedConditions.elementToBeClickable(this.claim)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.claim)).getText());


        return this;
    }

    public P02_sideMenu buzz() {

        shortWait(ExpectedConditions.visibilityOfElementLocated(this.buzz)).click();
        System.out.println(shortWait(ExpectedConditions.visibilityOfElementLocated(this.buzz)).getText());


        return this;
    }


}







