package com.example.tests;

import com.example.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4 extends BaseTest {

    @Test
    public void testCase41(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication("standard_user","secret_sauce");
        Assert.assertTrue(homePage.verifyLogin());
    }

    @Test
    public void testCase42(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication("problem_user","secret_sauce");
        Assert.assertTrue(homePage.verifyLogin());
    }

    @Test
    public void testCase43(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication("visual_user", "secret_sauce");
        Assert.assertTrue(homePage.verifyLogin());
    }

}
