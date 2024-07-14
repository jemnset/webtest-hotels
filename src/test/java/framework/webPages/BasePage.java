package framework.webPages;

import stepdefinition.SharedSD;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    // This is the most common wait function used in selenium
    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    // Return a List of WebElements
    public static List<WebElement> webActions(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the elements therefore Timeout Exception has been thrown");

        List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });

        return elements;
    }

    public void clickOn(By locator) {

        try {
            webAction(locator).click();
        }
        catch(ElementClickInterceptedException e)
        {
            JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
            js.executeScript("arguments[0].click();", webAction(locator));
        }
    }

    public void getValue(By locator){
        webAction(locator).getText();
    }
    public void setValue(By locator, String value){
        webAction(locator).sendKeys(value);
    }

    public void clearValue(By locator) {
        webAction(locator).clear();
    }

    public boolean isEnabled(By locator){
        return webAction(locator).isEnabled();
    }

    public boolean isSelected(By locator){
        return webAction(locator).isSelected();
    }

    public String getTitle(){
        return SharedSD.getDriver().getTitle();
    }
}
