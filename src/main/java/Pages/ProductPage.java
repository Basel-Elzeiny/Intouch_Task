package Pages;

import Base.TestBase;
import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(id = "back-to-products")
    WebElement backToProductButton;
    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeFromCartButton;
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    public WebElement itemName;



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

    public HomePage clickOnBackToProductsButton () throws IOException {
        backToProductButton.click();
        return new HomePage();
    }

    public void clickOnRemoveButton()
    {
        removeFromCartButton.click();
    }

    public boolean cartBudgeIsExist()
    {
        try {
            cartBadge.getText();
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return false;
    }
}
