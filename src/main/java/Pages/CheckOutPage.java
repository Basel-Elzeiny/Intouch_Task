package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckOutPage extends TestBase {
    public CheckOutPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "title")
    WebElement checkOutPageTitle;
    @FindBy(id = "first-name")
    WebElement firstNameTextBox;
    @FindBy(id = "last-name")
    WebElement lastNameTextBox;
    @FindBy(id = "postal-code")
    WebElement postalCodeTextBox;
    @FindBy(id = "continue")
    WebElement continueButton;

    public String getCheckOutPageTitle(){
        return checkOutPageTitle.getText();
    }

    public void fillPurchaseData(){
        firstNameTextBox.sendKeys(prop.getProperty("firstname"));
        lastNameTextBox.sendKeys(prop.getProperty("lastname"));
        postalCodeTextBox.sendKeys(prop.getProperty("postalcode"));

    }
    public CheckoutOverviewPage clickOnContinueButton() throws IOException {
        continueButton.click();
        return new CheckoutOverviewPage();
    }
}
