package stepdefinition;

import util.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SharedSD {

    private static WebDriver driver = null;

    @Before
    public static void before(){
        ConfigReader configReader = new ConfigReader();
        System.setProperty("webdriver.chrome.driver",
                configReader.getChromeDriverPath());
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(configReader.getUrl());
    }

    @After
    public static void after(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {return driver;}
}
