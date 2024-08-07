package com.example.tests;

import com.example.selenium.framework.WebDriverHelper;
import com.example.selenium.framework.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;
    String browser;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        //driver = WebDriverSingleton.getDriver();
        WebDriverHelper.setDriver(browser);
        driver = WebDriverHelper.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        //WebDriverSingleton.closeDriver();
        WebDriverHelper.quitDriver();
    }

}
