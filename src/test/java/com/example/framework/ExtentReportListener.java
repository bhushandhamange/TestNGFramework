package com.example.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.example.selenium.framework.WebDriverSingleton;
import com.example.selenium.framework.WebDriverHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    String params;

    @Override
    public void onStart(ITestContext context) {
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        Object[] parameters = result.getParameters();
        if (parameters.length > 0) {
            params = Arrays.toString(parameters);
            extentTest.get().info("Test parameters : " + params);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String screenshotPath = WebDriverHelper.takeScreenshot(result.getMethod().getMethodName());
        try {
            extentTest.get().addScreenCaptureFromPath("../" + screenshotPath, "Screenshot on Pass");
        } catch (Exception e) {
            e.printStackTrace();
        }
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail("Test failed : " + result.getThrowable());
        //test.fail(result.getThrowable());

        String screenshotPath = WebDriverHelper.takeScreenshot(result.getMethod().getMethodName());
        try {
            extentTest.get().addScreenCaptureFromPath("../" + screenshotPath, "Screenshot on Failure");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}