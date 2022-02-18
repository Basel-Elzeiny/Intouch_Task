package Tests;

import Base.TestBase;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutOverviewTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletedPage checkoutCompletedPage;

    public CheckoutOverviewTests() throws IOException {super();
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
        checkOutPage.fillPurchaseData();
        checkoutOverviewPage = checkOutPage.clickOnContinueButton();
    }

    @Test
    public void verifyUserPlacedOrderSuccessfully() throws IOException {
        checkoutCompletedPage = checkoutOverviewPage.clickFinishBtn();
        Assert.assertEquals(checkoutCompletedPage.getPageTitle(),"CHECKOUT: COMPLETE!");
    }
}
