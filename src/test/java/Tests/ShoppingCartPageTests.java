package Tests;

import Base.TestBase;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ShoppingCartPageTests extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    public ShoppingCartPageTests() throws IOException {
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
    }
    @Test
    public void VerifyProductName()
        {
            Assert.assertEquals(shoppingCartPage.getProductName(),"Sauce Labs Onesie");
        }

    @Test
    public void verifyCheckOutButton() throws IOException {
        checkOutPage = shoppingCartPage.clickOnCheckOutButton();
        Assert.assertEquals(checkOutPage.getCheckOutPageTitle(),"CHECKOUT: YOUR INFORMATION");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
