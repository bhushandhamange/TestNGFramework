package com.example.tests;

import com.example.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 extends BaseTest {

    @Test
    public void testCase21(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication("standard_user","secret_sauce");
        Assert.assertTrue(homePage.verifyLogin());
    }

    @Test
    public void testCase22(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication("problem_user","secret_sauce");
        Assert.assertTrue(homePage.verifyLogin());
    }

    @Test
    public void testCase23(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication("visual_user", "secret_sauce");
        Assert.assertTrue(homePage.verifyLogin());
    }

}
