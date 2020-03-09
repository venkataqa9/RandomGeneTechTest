package com.codeGen.pageObjects;

import com.codeGen.utils.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Properties;


public class RandomGenPage extends Helpers {

    Properties prop;

    @FindBy(id = "option-count-147fe348")
    private WebElement datesTxtField;

    @FindBy(css = ".btn1")
    private WebElement generateBtn;

    @FindBy(css = ".data.randomjson")
    private WebElement dates;

    public void navigateToGenerateRandomDatePage() {
        prop = loadPropertiesFiles("env");
        String codeGenUrl = prop.getProperty("randomGenUrl");
        driver.navigate().to(codeGenUrl);
    }

    public void enterNumberOfDates(int count) {
        waitForElement(datesTxtField).clear();
        waitForElement(datesTxtField).sendKeys(String.valueOf(count));
    }

    public void selectGenerateRandomDates() {
        waitForElement(generateBtn).click();
    }

    public boolean randomDatesAreNotDisplayed() {
        return ! (waitForElement(dates).getText().isEmpty());
    }
}
