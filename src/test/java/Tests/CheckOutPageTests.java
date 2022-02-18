package Tests;

import Base.TestBase;
import Pages.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckOutPageTests extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    public CheckOutPageTests() throws IOException {
        super();
    }
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) throws IOException {
        initializeDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
        productPage = homePage.openProductPage();
        productPage.clickAddToCart();
        shoppingCartPage = productPage.clickOnShoppingCart();
        checkOutPage = shoppingCartPage.clickOnCheckOutButton();
    }

    @Test
    public void verifyContinueButton() throws IOException {
        checkOutPage.fillPurchaseData();
        checkoutOverviewPage = checkOutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutOverviewPage.getPageTitle(),"CHECKOUT: OVERVIEW");
    }

}
