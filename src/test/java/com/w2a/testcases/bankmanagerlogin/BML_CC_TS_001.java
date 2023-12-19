package com.w2a.testcases.bankmanagerlogin;

import com.w2a.reusablefunctions.ReusableFunctions_BankMangerLogin;
import com.w2a.reusablefunctions.ReusableFunctions_CustomerLogin;
import com.w2a.testbase.BaseClass;
import org.testng.annotations.Test;

public class BML_CC_TS_001 extends BaseClass {
    ReusableFunctions_BankMangerLogin rfbmlp = new ReusableFunctions_BankMangerLogin();
    ReusableFunctions_CustomerLogin rfcslp = new ReusableFunctions_CustomerLogin();

    @Test
    public void login_As_BankManager_And_Add_A_Customer() throws InterruptedException {
        rfbmlp.addCustomer();
        rfbmlp.openAnAccount();
        rfbmlp.showCustomers();
        rfcslp.customerLogin(rfbmlp.getfName()+" "+rfbmlp.getlName());
    }
}
