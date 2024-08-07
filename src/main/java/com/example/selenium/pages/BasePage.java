package com.example.selenium.pages;

import com.example.selenium.framework.MKAction;
import com.example.selenium.framework.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    WebDriver driver;
    MKAction action;

    BasePage(WebDriver driver){
        this.driver = driver;
        action = new MKAction(driver);
    }

    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(PropertiesReader.getIntProperty("waitTime")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForAllElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(PropertiesReader.getIntProperty("fluentTime")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementFluent(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(PropertiesReader.getIntProperty("fluentTime")));
        wait.pollingEvery(Duration.ofSeconds(PropertiesReader.getIntProperty("pollingTime")));
        wait.ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        WebElement element = waitForElement(locator);
        element.click();
    }

    public void sendKeys(By locator, String str) {
        WebElement element = waitForElement(locator);
        element.sendKeys(str);
    }

}
