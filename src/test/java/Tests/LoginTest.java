package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginTest() throws IOException {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    public void runBrowser(String browser) throws IOException {
        initializeDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage= new LoginPage();
    }

    @Test
    public void loginValidation () throws IOException {
        homePage = loginPage.performLogin();
        Assert.assertTrue(homePage.homePageTitle_IsDisplayed());
    }

    @Test
    public void loginWrongName ()
    {
       String expectedMessage ="Epic sadface: Username and password do not match any user in this service";
       Assert.assertEquals(loginPage.wrongLogin(),expectedMessage);

    }
    @Test
    public void loginWithNoPassword()
    {
       String expectedMessage ="Epic sadface: Password is required";
       Assert.assertEquals(loginPage.loginWithoutPassword(),expectedMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
