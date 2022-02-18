package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    public HomePageTests() throws IOException {super();
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethods(String browser) throws IOException {
        initializeDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage= new LoginPage();
        homePage = loginPage.performLogin();
    }

    @Test
    public void checkSortingFunctionality(){
        homePage.sortProductList_By_LH();
       Assert.assertEquals("$"+homePage.findLowestPrice(),homePage.itemPriceList.get(0).getText());
    }

   @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
