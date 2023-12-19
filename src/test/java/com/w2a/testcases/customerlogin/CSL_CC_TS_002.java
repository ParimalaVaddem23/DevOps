package com.w2a.testcases.customerlogin;

import com.w2a.reusablefunctions.ReusableFunctions_CustomerLogin;
import com.w2a.testbase.BaseClass;
import org.testng.annotations.Test;

public class CSL_CC_TS_002 extends BaseClass {
    ReusableFunctions_CustomerLogin rfcslp = new ReusableFunctions_CustomerLogin();

    @Test
    public void login_As_A_Customer_WithdrawAmount() throws InterruptedException {

        rfcslp.customerLogin("Harry Potter");
        rfcslp.withdrawAmount("5");
    }
}
