package Util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class Utility {


    public static int generateRandomInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }

    public class RandomDataGenerator {
        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final Random random = new Random();

        public static String generateRandomString(int minLength, int maxLength) {
            int length = random.nextInt(maxLength - minLength + 1) + minLength;
            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }

            return sb.toString();
        }

        public class CredentialsHolder {
            public static String email;
            public static String password;
        }

        public static int generateRandom(int min, int max) {
            Random random = new Random();
            return random.nextInt(max) + min;  // nextInt(5) gives 0-4, +1 makes it 1-5
        }

        public static void openBrowserNetworkTab() throws AWTException {
            // Create Robot instance
            Robot robot = new Robot();
            // Add a delay for setup (optional)
            robot.delay(2000); // Wait for the browser window to be active
            // Step 1: Press Ctrl+Shift+I to open Developer Tools
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_I);
            // Add a delay for Developer Tools to open
            robot.delay(1000);
            // release press buttons
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_I);
            // Step 2: Navigate to the Network tab
            // Use Right Arrow key multiple times to move to the Network tab
            for (int i = 0; i < 3; i++) {
                // Press and hold Ctrl
                robot.keyPress(KeyEvent.VK_CONTROL);
                // Press and release
                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                // Release Ctrl
                robot.keyRelease(KeyEvent.VK_CONTROL);
                // Add a small delay between presses
                robot.delay(200);
            }
        }

    }



}
