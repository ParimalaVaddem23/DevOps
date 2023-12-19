package com.w2a.pages;

import com.w2a.testbase.BaseClass;
import com.w2a.utilities.CommonUtils;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends BaseClass {
    CommonUtils cm = new CommonUtils();
    public By addCustomerBtn = By.xpath("//button[@ng-class='btnClass1']");
    public By openAccountBtn = By.xpath("//button[@ng-click='openAccount()']");
    public By showCustomersBtn = By.xpath("//button[@ng-click='showCust()']");

    // Add Customer
    public By firstName = By.xpath("//input[@ng-model='fName']");
    public By lastName = By.xpath("//input[@ng-model='lName']");
    public By postCode = By.xpath("//input[@ng-model='postCd']");
    public By submitAddCustomerBtn = By.xpath("//button[text()='Add Customer']");

    // Open Account
    public By customerDropdown = By.id("userSelect");
    public By currencyDropdown = By.id("currency");
    public By processBtn = By.xpath("//button[text()='Process']");

    // show customers
    public By searchCustomer = By.xpath("//input[@ng-model='searchCustomer']");
    public void click_addCustomerBtn() {
        cm.click_WebElement_JavaScript(addCustomerBtn);
    }
    public void click_openAccountBtn() {
        cm.click_WebElement_JavaScript(openAccountBtn);
    }
    public void click_showCustomersBtn() {
        cm.click_WebElement_JavaScript(showCustomersBtn);
    }

    public void enter_firstName(String fName) {
        cm.send_Text_WebElement(firstName, fName);
    }
    public void enter_lastName(String lName) {
        cm.send_Text_WebElement(lastName, lName);
    }
    public void enter_PostCode(String postalCode) {
        cm.send_Text_WebElement(postCode, postalCode);
    }
    public void click_submitAddCustomerBtn() {
        cm.click_WebElement(submitAddCustomerBtn);
    }
    public void select_Customer(String customer) {
        cm.select_WebElement_ByVisibleText(customerDropdown, customer);
    }
    public void select_Currency(String currency) {
        cm.select_WebElement_ByVisibleText(currencyDropdown, currency);
    }
    public void click_processBtn() {
        cm.click_WebElement(processBtn);
    }
    public void search_Customer(String customer) {
        cm.send_Text_WebElement(searchCustomer, customer);
    }
    public void delete_Customer(String accountNumber) {
        cm.click_WebElement_JavaScript(By.xpath("//table//tr/td/span[text()='"+accountNumber+"']/following::td[1]/button"));
    }
}
