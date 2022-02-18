package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShoppingCartPage extends TestBase {
    public ShoppingCartPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "title")
    WebElement yourCartTitle;

    @FindBy(id = "checkout")
    WebElement checkOutButton;


    public String getPageTitle(){
        return yourCartTitle.getText();
    }
    public CheckOutPage clickOnCheckOutButton() throws IOException {
        checkOutButton.click();
        return new CheckOutPage();
    }
}
