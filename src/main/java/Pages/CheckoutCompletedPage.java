package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutCompletedPage extends TestBase {

    public CheckoutCompletedPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "title")
    WebElement pageTitle;

    public String getPageTitle(){return pageTitle.getText();}
}
