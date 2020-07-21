package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage {

    private static final int TIMEOUT = 5;

    protected WebDriver elDriverNomasAqui;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver){
        this.elDriverNomasAqui = driver;
         wait = new WebDriverWait(this.elDriverNomasAqui, TIMEOUT);
         actions = new Actions(this.elDriverNomasAqui);
    }

    public void waitForElementToAppear (WebElement elElemento){
        wait.until(ExpectedConditions.visibilityOf(elElemento));
    }

    public void waitForElementToBeClickable(WebElement elElemento){
        wait.until(ExpectedConditions.elementToBeClickable(elElemento));
    }

    public void click(WebElement elElemento){
        this.waitForElementToAppear(elElemento);
        this.waitForElementToBeClickable(elElemento);
        elElemento.click();
    }

    public void writeInInput(WebElement elElemento, String mensaje){
        this.waitForElementToAppear(elElemento);
        elElemento.sendKeys(mensaje);
    }

    public void hooverElement(WebElement elElemento){
        this.waitForElementToAppear(elElemento);
        actions.moveToElement(elElemento).perform();
    }

    public boolean isTextPresentOnElement(WebElement elElemento, String texto){
        this.waitForElementToAppear(elElemento);
        return wait.until(ExpectedConditions.textToBePresentInElement(elElemento,texto));
    }

    public void waitForElementsToAppear(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public boolean elementAttributeIs(WebElement elElemento, String elAtributo, String elValor){
        this.waitForElementToAppear(elElemento);
        return wait.until(ExpectedConditions.attributeContains(elElemento,elAtributo,elValor));
    }

    //HomeWork
    /*
    * Create a function that accepts like a parameter retry value and a WebElement
    * This function will retry to click the WebElement the integer assigned to value.
    *
    * Example -> retryClick(fancyButtonElement, 3)
    *
    * */

}

