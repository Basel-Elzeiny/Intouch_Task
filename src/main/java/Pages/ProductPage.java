package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ProductPage extends TestBase {
    public ProductPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public String getCartItemsCount(){
        return cartBadge.getText();
    }

    public ShoppingCartPage clickOnShoppingCart() throws IOException {
        shoppingCart.click();
        return new ShoppingCartPage();
    }
}
