package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

abstract public class BaseTest {

    protected WebDriver elDriver;

    @BeforeSuite
    public void suitSetup() {
        this.elDriver = new DriverSetup("chrome", false).getElDriver();
        this.elDriver.get("http://store.steampowered.com/");
    }

    @AfterSuite
    public void suitTearDown(){
        this.elDriver.close();
        this.elDriver.quit();
    }

}
