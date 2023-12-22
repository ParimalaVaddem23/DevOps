package com.w2a.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserManager {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static void browserSetup(String browserName) {

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            //steup chrome browser
            //Add options for --headed or --headless browser launch
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");

            //initialize driver for chrome
            driver = new ChromeDriver(chromeOptions);

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(30));

        }
        threadLocalDriver.set(driver);
    }
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }
}
