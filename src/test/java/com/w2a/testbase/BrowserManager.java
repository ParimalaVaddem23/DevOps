package com.w2a.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserManager {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static void browserSetup(String browserName) {

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            //steup chrome browser
            //Add options for --headed or --headless browser launch
            //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("/usr/bin/chromedriver");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-setuid-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");

            //WebDriverManager.chromedriver().setup();
            //initialize driver for chrome
            System.out.println("initialize driver for chrome");
            driver = new ChromeDriver(chromeOptions);
            //maximize window
            System.out.println("maximize window");
            driver.manage().window().maximize();
            System.out.println("implicit wait");
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
