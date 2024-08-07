package com.example.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MKAction {

    WebDriver driver;
    Actions actions;
    public MKAction(WebDriver driver){
        this.driver = driver;
        actions = new Actions(this.driver);
    }

    public void pressEnterUsingActions(By locator){
        actions.moveToElement(driver.findElement(locator)).sendKeys(Keys.RETURN).build().perform();
    }
}
