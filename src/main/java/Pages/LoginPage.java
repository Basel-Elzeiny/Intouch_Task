package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {

    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
     WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement wrongUserNameMessage;


    public HomePage performLogin() throws IOException {
        userName.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("password"));
        loginButton.click();
        return new HomePage();
    }
    public String wrongLogin ()
    {
        userName.sendKeys(prop.getProperty("username2"));
        password.sendKeys(prop.getProperty("password"));
        loginButton.click();
        return wrongUserNameMessage.getText();
    }

    public String loginWithoutPassword()
    {
        userName.sendKeys(prop.getProperty("username2"));
        loginButton.click();
        return wrongUserNameMessage.getText();
    }
}
