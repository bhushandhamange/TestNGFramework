package com.example.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.selenium.pages.HomePage;

public class Test1 extends BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Test(dataProvider = "searchDataProvider", dataProviderClass = com.example.utils.TestData.class)
    public void testCase1(String username, String password){
        logger.info("Running Test1 with username : "+ username + " password : "+ password);
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.loginToApplication(username, password);
        Assert.assertTrue(homePage.verifyLogin());
    }


}
