package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPageTests extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    public ProductPageTests() throws IOException {super();
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) throws IOException {
        initializeDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
        productPage = homePage.openProductPage();
    }

    @Test
    public void checkAddToCartFunctionality(){
        productPage.clickAddToCart();
        Assert.assertEquals(productPage.getCartItemsCount(),"1");
    }

    @Test
    public void verifyShoppingCartButton() throws IOException {
        productPage.clickAddToCart();
        shoppingCartPage = productPage.clickOnShoppingCart();
        Assert.assertEquals(shoppingCartPage.getPageTitle(),"YOUR CART");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
