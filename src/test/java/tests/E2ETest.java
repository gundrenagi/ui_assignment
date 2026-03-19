package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.remarks.testng.VideoListener;

import base.BaseTest;
import base.DriverFactory;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.RetryAnalyzer;
import utils.WaitUtils;

@Listeners(VideoListener.class)
public class E2ETest extends BaseTest {

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void testCheckoutFlow() throws InterruptedException {
    	
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        String url = ConfigReader.get("url");

        WebDriver driver = DriverFactory.getDriver();
        driver.get(url);
        
        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        ProductsPage products = new ProductsPage(driver);
        products.addProductToCart();
        products.goToCart();

        CartPage cart = new CartPage(driver);
        cart.checkout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterDetails(
        		ConfigReader.get("firstname"),
        		ConfigReader.get("lastname"),
        		ConfigReader.get("zipcode")
        );

        OverviewPage overview = new OverviewPage(driver);
        overview.finishOrder();
        
        Thread.sleep(10);
        String message = overview.getConfirmation();
        System.out.println("Confirmation message: '" + message + "'");

        //Expected failure to test Retry
        Assert.assertTrue(
            overview.getConfirmation().contains("THANK YOU"),
            "Order not successful"
        );
    }
}
