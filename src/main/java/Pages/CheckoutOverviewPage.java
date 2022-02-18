package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutOverviewPage extends TestBase {
    public CheckoutOverviewPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(id = "finish")
    WebElement finishBtn;

    public String getPageTitle(){
        return pageTitle.getText();
    }
    public CheckoutCompletedPage clickFinishBtn() throws IOException {
        finishBtn.click();
        return new CheckoutCompletedPage();
    }
}
