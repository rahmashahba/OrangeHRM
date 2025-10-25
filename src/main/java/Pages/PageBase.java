package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PageBase {

    WebDriver driver;
    WebDriverWait wait;

    public PageBase(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/" + screenshotName + System.currentTimeMillis() + ".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quitBrowser(WebDriver driver) {
        // clear browser localStorage , sessionStorage and delete All Cookies
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
        driver.manage().deleteAllCookies();
        driver.quit();
        // kill browser process on background
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
                //  Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            } else if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
                Runtime.getRuntime().exec("pkill -f chromedriver");
                Runtime.getRuntime().exec("pkill -f chrome");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // explicit wait
    public static void explicitWait(WebDriver driver, By element) {
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //fluentWaitHandling
    public static void fluentWaitHandling(WebDriver driver, By element) {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    //waitForPageLoad not used anymore
    public static void waitForPageLoad(WebDriver driver) {
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                System.out.println("Ready State: " + readyState);
                return (Boolean) readyState.equals("complete");
            }
        });
    }

    public boolean typeToElement(By locator, String text) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                int finalAttempts = attempts;
                return wait.until(driver -> {
                    try {
                        WebElement element = driver.findElement(locator);
                        if (element.isDisplayed() && element.isEnabled()) {
                            element.clear();
                            element.sendKeys(text);
                            return true;
                        } else {
                            return false;
                        }
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                });
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        return false;
    }

    public boolean clickOnElement(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                int finalAttempts = attempts;
                return wait.until(driver -> {
                    try {
                        WebElement element = driver.findElement(locator);
                        if (element.isDisplayed() && element.isEnabled()) {
                            element.click();
                            return true;
                        }
                        return false;
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                });
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        return false;
    }

    //short and long wait
    public <T> T shortWait( ExpectedCondition<T> condition) {
        int attempts = 0;
        final int MAX_RETRIES = 5;
        final Duration TIMEOUT = Duration.ofSeconds(10);
        while (attempts < MAX_RETRIES) {
            try {
                WebDriverWait wait = new WebDriverWait(this.driver, TIMEOUT);
                return wait.until(condition);
            } catch (StaleElementReferenceException e) {
                System.out.println("Attempt " + (attempts + 1) + ": StaleElementReferenceException - " + e.getMessage());
            } catch (TimeoutException e) {
                System.out.println("Attempt " + (attempts + 1) + ": TimeoutException - " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Attempt " + (attempts + 1) + ": NoSuchElementException - " + e.getMessage());
            } catch (ElementClickInterceptedException e) {
                System.out.println("Attempt " + (attempts + 1) + ": ElementClickInterceptedException - " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.out.println("Attempt " + (attempts + 1) + ": ElementNotInteractableException - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Attempt " + (attempts + 1) + ": Unexpected exception - " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
            attempts++;
        }
        throw new RuntimeException("Condition failed after " + MAX_RETRIES + " attempts.");
    }

    public <T> T longWait(ExpectedCondition<T> condition) {
        int attempts = 0;
        final int MAX_RETRIES = 5;
        final Duration TIMEOUT = Duration.ofSeconds(25);
        while (attempts < MAX_RETRIES) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
                return wait.until(condition);
            } catch (StaleElementReferenceException e) {
                System.out.println("Attempt " + (attempts + 1) + ": StaleElementReferenceException - " + e.getMessage());
            } catch (TimeoutException e) {
                System.out.println("Attempt " + (attempts + 1) + ": TimeoutException - " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Attempt " + (attempts + 1) + ": NoSuchElementException - " + e.getMessage());
            } catch (ElementClickInterceptedException e) {
                System.out.println("Attempt " + (attempts + 1) + ": ElementClickInterceptedException - " + e.getMessage());
            } catch (ElementNotInteractableException e) {
                System.out.println("Attempt " + (attempts + 1) + ": ElementNotInteractableException - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Attempt " + (attempts + 1) + ": Unexpected exception - " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
            attempts++;
        }
        throw new RuntimeException("Condition failed after " + MAX_RETRIES + " attempts.");
    }
    public String selectRandomOption( WebElement dropdown, By optionsLocator) {
        // Click dropdown to expand options
        dropdown.click();

        // Wait for options to appear
        List<WebElement> options = driver.findElements(optionsLocator);

        if (options == null || options.isEmpty()) {
            System.out.println("⚠️ No dropdown options found.");
            return null;
        }

        // Pick a random option (excluding any placeholder like "Select...")
        int randomIndex = new Random().nextInt(options.size());
        WebElement selectedOption = options.get(randomIndex);

        // Get option text before clicking (for logging)
        String selectedText = selectedOption.getText();

        selectedOption.click(); // Select the option
        System.out.println("✅ Selected random option: " + selectedText);

        return selectedText;
    }





}
