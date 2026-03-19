package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class OverviewPage {

    WebDriver driver;

    By finishBtn = By.id("finish");
    By confirmationMsg = By.className("complete-header");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getConfirmation() {
        //return driver.findElement(confirmationMsg).getText();
    	return WaitUtils.waitForElement(confirmationMsg).getText();
    }
}
