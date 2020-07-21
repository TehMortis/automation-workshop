package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy (xpath = "//li[.='Popular']")
    private WebElement popularProductsButton;

    @FindBy (xpath = "//li[.='Best Sellers']")
    private WebElement bestSellersProductsButton;

    public HomePage(WebDriver elDriver){
        super(elDriver);
        PageFactory.initElements(elDriver,this);
    }

    public void clickPopularProductsButton(){
        this.click(popularProductsButton);
        String isActive= popularProductsButton.getAttribute("class");
        Assert.assertEquals(isActive,"active");
    }

    public void clickBestSellerProductsButton(){
        this.click(bestSellersProductsButton);
        String isActive= bestSellersProductsButton.getAttribute("class");
        Assert.assertEquals(isActive,"active");
    }
}
