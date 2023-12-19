package com.w2a.reusablefunctions;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.pages.BankManagerLoginPage;
import com.w2a.pages.HomePage;
import com.w2a.testbase.BaseClass;
import com.w2a.utilities.CommonUtils;
import com.w2a.utilities.Screenshot;

public class ReusableFunctions_BankMangerLogin extends BaseClass {
    BankManagerLoginPage bmlp = new BankManagerLoginPage();
    CommonUtils cm = new CommonUtils();
    Screenshot sc = new Screenshot();
    HomePage hp = new HomePage();

    private String fName;
    private String lName;
    private String accountNumber;
    public String getfName()
    {
        return this.fName;
    }
    public void setfName(String fName)
    {
        this.fName = fName;
    }
    public String getlName()
    {
        return this.lName;
    }
    public void setlName(String lName)
    {
        this.lName = lName;
    }
    public String getAccountNumber()
    {
        return this.accountNumber;
    }
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    public void addCustomer() throws InterruptedException {
        String firstName = "subbu";
        String lastName = "Varma";
        String pinCode = "500022";
        Thread.sleep(80);
        hp.click_bankManagerLoginBtn();
        Thread.sleep(300);
        bmlp.click_addCustomerBtn();
        Thread.sleep(800);
        setfName(firstName);
        bmlp.enter_firstName(getfName());
        Thread.sleep(80);
        setlName(lastName);
        bmlp.enter_lastName(getlName());
        Thread.sleep(80);
        bmlp.enter_PostCode(pinCode);
        //test.log(LogStatus.INFO,sc.takeScreenshot(getDriver()));
        bmlp.click_submitAddCustomerBtn();
        Thread.sleep(150);
        String successMassage = cm.accept_Alert();
        test.log(LogStatus.INFO,successMassage);
        Thread.sleep(150);
    }


   public void openAnAccount() throws InterruptedException {
      bmlp.click_openAccountBtn();
       Thread.sleep(150);
      bmlp.select_Customer("subbu Varma");
       Thread.sleep(150);
      bmlp.select_Currency("Pound");
      bmlp.click_processBtn();
      String successMassage = cm.accept_Alert();
      test.log(LogStatus.INFO,successMassage);
       String[] accountNum = successMassage.split(":", 2);
       setAccountNumber(accountNum[1]+" ");
   }

    public void showCustomers() throws InterruptedException {
       bmlp.click_showCustomersBtn();
       Thread.sleep(300);
       bmlp.search_Customer(getfName());
       Thread.sleep(300);
      // bmlp.delete_Customer(getAccountNumber());

    }

}
