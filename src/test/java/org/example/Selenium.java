package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static void main(String[] args) {
          System.out.println("Launching google chrome..");
          WebDriver driver = new ChromeDriver();
          threadLocalDriver.set(driver);
          getDriver().get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
          getDriver().manage().window().fullscreen();
      }
    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }
}
