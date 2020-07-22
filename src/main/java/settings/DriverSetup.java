package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverSetup {

    private WebDriver elDriver;

    public DriverSetup(String nombre_browser, boolean headless){
        if (nombre_browser.equalsIgnoreCase("chrome")){
            ChromeOptions opciones = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(headless){
                opciones.addArguments("--headless");
            }
            elDriver = new ChromeDriver(opciones);
        }
        elDriver.manage().window().maximize();
        elDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getElDriver() {

        return this.elDriver;
    }
}
