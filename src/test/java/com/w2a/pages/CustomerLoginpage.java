package com.w2a.pages;

import com.w2a.testbase.BaseClass;
import com.w2a.utilities.CommonUtils;
import org.openqa.selenium.By;

public class CustomerLoginpage extends BaseClass {

    CommonUtils cm = new CommonUtils();
    public By yourNameDropdown = By.id("userSelect");
    public By loginBtn = By.xpath("//button[text()='Login']");
    public By logoutBtn = By.xpath("//button[text()='Logout']");

    //Account Page
    public By accountBalanceAndCurrencyDetails = By.xpath("//div[@ng-hide='noAccount'][1]");
    public By transactionsBtn = By.xpath("//button[@ng-class='btnClass1']");
    public By depositBtn = By.xpath("//button[@ng-class='btnClass2']");
    public By withdrawalBtn = By.xpath("//button[@ng-class='btnClass3']");
    public By amountToBeDeposited = By.xpath("//input[@placeholder='amount']");
    public By depositAmountSubmitBtn = By.xpath("//button[text()='Deposit']");
    public By withdrawAmountSubmitBtn = By.xpath("//button[text()='Withdraw']");

    public By transactionMessage = By.xpath("//span[@class='error ng-binding']");
    public By backBtn = By.xpath("//button[text()='Back']");
    public By resetBtn = By.xpath("//button[text()='Reset']");
    public By webTable = By.xpath("//table//tr");

    public void select_yourNameDropdown(String text) {
        cm.select_WebElement_ByVisibleText(yourNameDropdown, text);
    }
    public void click_loginBtn() {
        cm.click_WebElement_JavaScript(loginBtn);
    }
    public void click_logoutBtn() {
        cm.click_WebElement_JavaScript(logoutBtn);
    }

   //Account Actions
   public void get_accountBalanceAndCurrencyDetails() {
       cm.getText_WebElement(accountBalanceAndCurrencyDetails);
   }

    public void click_transactionsBtn() {
        cm.click_WebElement(transactionsBtn);
    }
    public void click_depositBtn() {
        cm.click_WebElement(depositBtn);
    }
    public void click_withdrawalBtn() {
        cm.click_WebElement_JavaScript(withdrawalBtn);
    }
    public void enter_amountToBeDeposited(String amount) {
        cm.send_Text_WebElement(amountToBeDeposited, amount);
    }
    public void click_depositAmountSubmitBtn() {
        cm.click_WebElement(depositAmountSubmitBtn);
    }
    public void click_withdrawAmountSubmitBtn() {
        cm.click_WebElement_JavaScript(withdrawAmountSubmitBtn);
    }
    public String get_transactionMessage() {
        return cm.getText_WebElement(transactionMessage);
    }
    public void click_backBtn() {
        cm.click_WebElement_JavaScript(backBtn);
    }
    public void click_resetBtn() {
        cm.click_WebElement_JavaScript(resetBtn);
    }



}
