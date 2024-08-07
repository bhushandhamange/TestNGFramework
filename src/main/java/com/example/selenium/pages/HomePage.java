package com.example.selenium.pages;

import com.example.selenium.framework.MKAction;
import com.example.selenium.framework.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends  BasePage{

    By usernameTexBox = By.id("user-name");
    By passwordTexBox = By.id("password");
    By loginButton = By.id("login-button");
    By appLogo = By.xpath("//div[@class='app_logo']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void openHomePage(){
        driver.get(PropertiesReader.getProperty("URL"));
    }

    public void loginToApplication(String username, String password){
        sendKeys(usernameTexBox, username);
        sendKeys(passwordTexBox, password);
        click(loginButton);
    }

    public boolean verifyLogin() {
        WebElement element = waitForElement(appLogo);
        return element.getText().contains("Swag Labs");
    }
}