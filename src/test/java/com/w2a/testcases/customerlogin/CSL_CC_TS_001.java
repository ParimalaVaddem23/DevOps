package com.w2a.testcases.customerlogin;

import com.w2a.reusablefunctions.ReusableFunctions_BankMangerLogin;
import com.w2a.reusablefunctions.ReusableFunctions_CustomerLogin;
import com.w2a.testbase.BaseClass;
import org.testng.annotations.Test;

public class CSL_CC_TS_001 extends BaseClass {
    //ReusableFunctions_BankMangerLogin rfbmlp = new ReusableFunctions_BankMangerLogin();
    ReusableFunctions_CustomerLogin rfcslp = new ReusableFunctions_CustomerLogin();

    @Test
    public void login_As_A_Customer_DepositAmount() throws InterruptedException {

        rfcslp.customerLogin("Harry Potter");
        rfcslp.depositAmount("10");
        rfcslp.withdrawAmount("5");
    }
}
