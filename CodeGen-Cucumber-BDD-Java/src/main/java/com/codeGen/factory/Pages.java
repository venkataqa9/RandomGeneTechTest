package com.codeGen.factory;

import com.codeGen.pageObjects.RandomGenPage;
import com.google.common.base.Predicate;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Pages {
    public WebDriver driver;
    public static Logger log;
    WebDriver wait;

    public Pages() {
        this.driver = DriverHelper.driver;
        PageFactory.initElements(driver, this);
        log = Logger.getLogger(Pages.class);

    }

    public static RandomGenPage randomGenPage() {
        return new RandomGenPage();
    }

    public WebElement waitForElement(WebElement element) {
        try {
            return new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            FluentWait<WebElement> fluentWait = new FluentWait<WebElement>(element);
            fluentWait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS);
            fluentWait.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class)
                    .ignoring(StaleElementReferenceException.class);
            fluentWait.until(new Predicate<WebElement>() {
                @Override
                public boolean apply(WebElement element) {
                    //log.info("Applying Fluent wait to check WebElement is Enabled");
                    return element.isEnabled();
                }
            });
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        return element;
    }

}
