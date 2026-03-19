package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        return new ChromeDriver(options);  
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }

}
