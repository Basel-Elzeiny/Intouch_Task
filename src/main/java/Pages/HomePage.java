package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class HomePage extends TestBase {
    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement homePageTittle;

    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    WebElement dataListSort;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPriceList;
    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemNameList;

    public boolean homePageTitle_IsDisplayed(){
        return homePageTittle.isDisplayed();
    }

    public void sortProductList_By_AZ(){

        dataListSort.click();
        Select select = new Select(dataListSort);
        select.selectByIndex(0);
    }

    public void sortProductList_By_ZA(){

        dataListSort.click();
        Select select = new Select(dataListSort);
        select.selectByValue("za");
    }

    public void sortProductList_By_LH(){
        dataListSort.click();
        Select select = new Select(dataListSort);
        select.selectByValue("lohi");
    }

    public void sortProductList_By_HL(){

        dataListSort.click();
        Select select = new Select(dataListSort);
        select.selectByIndex(3);
    }

    public Double findLowestPrice()
    {
        String getNumber;
        double min;
        double currentPrice;
        getNumber= itemPriceList.get(0).getText().substring(1);
        min = Double.parseDouble(getNumber);

     for (int i=1;i<itemPriceList.size();i++)
     {
         getNumber= itemPriceList.get(i).getText().substring(1);
         currentPrice=Double.parseDouble(getNumber);
         if(min>currentPrice){
             min=currentPrice;
         }
     }
     return min;
    }
    public ProductPage openProductPage() throws IOException {
        sortProductList_By_LH();
        itemNameList.get(0).click();
        return new ProductPage();
    }

}
