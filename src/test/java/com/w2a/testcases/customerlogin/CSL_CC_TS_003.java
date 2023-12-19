package com.w2a.testcases.customerlogin;

import com.w2a.reusablefunctions.ReusableFunctions_CustomerLogin;
import com.w2a.testbase.BaseClass;
import org.testng.annotations.Test;

public class CSL_CC_TS_003 extends BaseClass {
    ReusableFunctions_CustomerLogin rfcslp = new ReusableFunctions_CustomerLogin();

    @Test
    public void login_As_A_Customer_WithdrawAmount_And_Validate_Error_Message() throws InterruptedException {
        rfcslp.customerLogin("Harry Potter");
        rfcslp.withdrawAmount("10000000000000000");
        rfcslp.validateErrorMessage();
    }
}
