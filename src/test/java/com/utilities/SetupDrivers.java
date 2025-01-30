package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
	
public class SetupDrivers {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
       // options.addArguments("--headless");
        driver.set(new ChromeDriver(options)); // Set the driver instance for the current thread
    }

    public static WebDriver getDriver() {
        return driver.get();	// Return the driver instance for the current thread
    }

    public static void tearDownDriver() {
        if (driver.get() != null) {
            driver.get().quit(); // Quit the browser
            driver.remove(); // Remove the driver from the ThreadLocal
        }
    }
}