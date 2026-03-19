package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;   

    public static WebDriver initDriver() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);  
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;  
    }

    public static void quitDriver() {
        if (driver != null) {   
            driver.quit();
            driver = null;
        }
    }
}
