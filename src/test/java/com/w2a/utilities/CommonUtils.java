package com.w2a.utilities;

import com.w2a.testbase.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.w2a.testbase.BrowserManager.getDriver;


public class CommonUtils extends BaseClass {
    WebDriverWait wait;

    public void click_WebElement(By webElement) {
        WebElement element = getDriver().findElement(webElement);
//        wait = new WebDriverWait(getDriver(), 50);
//        wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        element.click();
    }

    public void send_Text_WebElement(By webElement, String text) {
        WebElement element = getDriver().findElement(webElement);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        element.sendKeys(text);
    }
    public String getText_WebElement(By webElement) {
        //wait(10).until(ExpectedConditions.presenceOfElementLocated(webElement));
        WebElement webelement = getDriver().findElement(webElement);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webelement);
        return webelement.getText();
    }
    public void click_WebElement_JavaScript(By webElement) {
        //wait(10).until(ExpectedConditions.presenceOfElementLocated(webElement));
        WebElement webelement = getDriver().findElement(webElement);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", webelement);
    }
    public void select_WebElement_ByVisibleText(By webElement, String text) {
        Select select =new Select(getDriver().findElement(webElement));
        select.selectByVisibleText(text);
    }
    public void select_WebElement_ByIndex(By webElement, int index) {
        Select select =new Select(getDriver().findElement(webElement));
        select.selectByIndex(index);
    }
    public void select_WebElement_ByValue(By webElement, String value) {
        Select select =new Select(getDriver().findElement(webElement));
        select.selectByValue(value);
    }
    public List<WebElement> get_AllOptions(By webElement) {
        Select select =new Select(getDriver().findElement(webElement));
        List <WebElement> options = select.getOptions();
        return options;
    }

    public static boolean isElementPresent(By webElement)
    {
        boolean result = false;
        try
        {
            if(getDriver().findElement(webElement).isDisplayed())
                result = true;
            else
                result = false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public WebElement findElementUsingText(String searchText)
    {
        return getDriver().findElement(By.xpath("//*[contains(text(),'"+searchText+"')]"));
    }
    public WebElement findElement_WebTable(String transactionType, String amount)
    {
        return getDriver().findElement(By.xpath("//table//tr/td[text()='"+transactionType+"']/preceding-sibling::td[1][text()='"+amount+"']"));
    }
    public int get_WebTable_RowCount(By webElement){
        List<WebElement> rows = getDriver().findElements(webElement);
        return rows.size();
    }
    public String accept_Alert() {
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
