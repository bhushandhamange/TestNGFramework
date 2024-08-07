package com.example.selenium.framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class WebDriverHelper {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported");
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static String takeScreenshot(String testName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String randomString = UUID.randomUUID().toString();
        String dest = "test-output/screenshots/" + testName + "_" + randomString + ".png";

        try{
            Files.createDirectories(Paths.get("test-output/screenshots/"));
            Files.copy(source.toPath(), Paths.get(dest));
        } catch (IOException e){
            e.printStackTrace();
        }
        return dest;
    }
}
