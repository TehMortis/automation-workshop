package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NavBar extends BasePage {

    @FindBy(id = "foryou_tab")
    private WebElement tuTiendaTab;

    @FindBy(id = "genre_tab")
    private WebElement tuJuegoTab;

    @FindBy(id = "store_nav_search_term")
    private WebElement buscarEnTiendaInput;

    @FindBy(css = "#search_suggestion_contents > a > .match_name")
    private List<WebElement> juegosSugeridos;

    public NavBar(WebDriver elDriver){
        super(elDriver);
        PageFactory.initElements(elDriver,this);
    }

    public void abrirLaTienda(){
        this.openNavBarTab(tuTiendaTab);
    }

    public void openGamesTab(){
        this.openNavBarTab(tuJuegoTab);
    }

    public ArrayList<String> getSuggestedGames(){
        ArrayList<String> suggested_games_names = new ArrayList<String>();

        for (WebElement juegoSugerido: juegosSugeridos){
            suggested_games_names.add(juegoSugerido.getText());
        }
        return suggested_games_names;
    }

    public void writeGameIntoSearchInput(String gameName){
        this.writeInInput(buscarEnTiendaInput, gameName);
    }

    private void openNavBarTab(WebElement tab){
        this.hooverElement(tab);
        String isActive= tab.getAttribute("class");
        Assert.assertTrue(isActive.indexOf("focus") > 0, "no se abrió el menú");
    }
}
