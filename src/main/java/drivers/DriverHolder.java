
package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    //Webdriver defined as ThreadLocal
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //synchronized just give WebDriver extral loced
    //getter method to return thread local
    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    //setter set driver
    public static void setDriver(WebDriver driver) {
        DriverHolder.driver.set(driver);
    }

}
