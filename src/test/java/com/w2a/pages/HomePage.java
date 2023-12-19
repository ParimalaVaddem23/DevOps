package com.w2a.pages;

import com.w2a.testbase.BaseClass;
import com.w2a.utilities.CommonUtils;
import org.openqa.selenium.By;

public class HomePage extends BaseClass {
    CommonUtils cm = new CommonUtils();
    private By homeBtn = By.xpath("//button[text()='Home']");
    private By homePageHeading = By.xpath("//*[text()='XYZ Bank']");
    private By customerLoginButton = By.xpath("//button[text()='Customer Login']");
    private By bankManagerLoginButton = By.xpath("//button[text()='Bank Manager Login']");


    public void click_homeBtn() {
        cm.click_WebElement(homeBtn);
    }
    public void get_homePageHeading() {
        cm.getText_WebElement(homePageHeading);
    }
    public void click_customerLoginBtn() {
        cm.click_WebElement(customerLoginButton);
    }
    public void click_bankManagerLoginBtn() {
        cm.click_WebElement(bankManagerLoginButton);
    }

}
