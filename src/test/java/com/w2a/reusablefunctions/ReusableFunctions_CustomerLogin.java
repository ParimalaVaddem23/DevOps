package com.w2a.reusablefunctions;

import com.w2a.pages.CustomerLoginpage;
import com.w2a.pages.HomePage;
import com.w2a.testbase.BaseClass;
import com.w2a.utilities.CommonUtils;
import com.w2a.utilities.Screenshot;
import org.testng.Assert;

public class ReusableFunctions_CustomerLogin extends BaseClass {

    CustomerLoginpage cslp = new CustomerLoginpage();
    CommonUtils cm = new CommonUtils();
    HomePage hp = new HomePage();

    public void customerLogin(String customer) throws InterruptedException {
        hp.click_homeBtn();
        Thread.sleep(300);
        hp.click_customerLoginBtn();
        Thread.sleep(300);
        cslp.select_yourNameDropdown(customer);
        Thread.sleep(300);
        cslp.click_loginBtn();
        Thread.sleep(300);
    }

    public void depositAmount(String amt) throws InterruptedException {
        cslp.click_depositBtn();
        Thread.sleep(300);
        cslp.enter_amountToBeDeposited(amt);
        Thread.sleep(300);
        cslp.click_depositAmountSubmitBtn();
        Thread.sleep(300);
    }
    public void withdrawAmount(String amt) throws InterruptedException {
        cslp.click_withdrawalBtn();
        Thread.sleep(300);
        cslp.enter_amountToBeDeposited(amt);
        Thread.sleep(300);
        cslp.click_withdrawAmountSubmitBtn();
        Thread.sleep(300);
    }
    public void validateErrorMessage(){
        String errorMessage = cslp.get_transactionMessage();
        Assert.assertEquals(errorMessage, "Transaction Failed. You can not withdraw amount more than the balance.");

    }
}
