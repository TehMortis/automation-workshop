package tests;

import components.NavBar;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.BaseTest;

import java.util.ArrayList;

public class HomePageTests extends BaseTest{

    private NavBar navBar;

    @BeforeTest
    public void setUp(){
        navBar= new NavBar(this.elDriver);
    }

    @Test
    public void openAllNavBarTabs(){
        navBar.abrirLaTienda();
        navBar.openGamesTab();
    }

    @Test
    public void testSuggestedGames(){
        String gameName="Portal";
        navBar.writeGameIntoSearchInput(gameName);
        ArrayList<String> juegos=navBar.getSuggestedGames();
        Assert.assertTrue(juegos.size()==5);

        for(String juego:juegos){
            Assert.assertTrue(juego.indexOf("Portal")>=0);
        }
    }


}

