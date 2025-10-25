package TCs;

import com.github.javafaker.Faker;
import common.MyScreenRecorder;
import common.MyScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;

import static Util.Utility.RandomDataGenerator.openBrowserNetworkTab;
import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class testbase {

    @BeforeSuite
            public void beforeSuite() throws Exception {
        MyScreenRecorder.startRecording("loggedin test");
    }

    //static WebDriver driver;
    // Actions actions;
    SoftAssert softAssert;
    Faker faker = new Faker();
    // This method will run once before all test methods in the class
    @BeforeTest

    @Parameters({"browsername","URL"})
   //@BeforeMethod
    public void setup_driver(@Optional String browsername  , String URL) throws Exception {
        if(browsername == null)
        {
            browsername = " ";
        }
        setDriver(getNewInstance(browsername));

        //MyScreenRecorder.startRecording("loggedin test");
        getDriver().get(URL);
        // implicitlyWait
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    // This method will run once after all test methods in the class
    @AfterTest
   // @AfterMethod
    public void tearDown_driver() throws Exception {
        if (getDriver() != null) {

            // Close all tabs and kill driver
            getDriver().quit();

        }

    }
    @AfterSuite

    public void afterSuite() throws Exception {
        MyScreenRecorder.stopRecording();
    }

}
