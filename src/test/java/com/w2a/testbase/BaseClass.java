package com.w2a.testbase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ConfigReader;
import com.w2a.utilities.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static com.w2a.testbase.BrowserManager.getDriver;
import static com.w2a.testbase.BrowserManager.threadLocalDriver;
public class BaseClass implements ITestListener {
    private static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports report;
    Screenshot sc = new Screenshot();
    //public static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentReports> extent_reports = new ThreadLocal<ExtentReports>();
    private static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();

    @BeforeMethod
    public void Setup(){
        System.out.println("Before Method Execution");
        ConfigReader.readProperties();
        String browser = ConfigReader.getProperty("browser");
        BrowserManager.browserSetup(browser);
        WebDriver driver = getDriver();
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
        driver.get(ConfigReader.getProperty("baseurl"));
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method Execution");
        getDriver().quit();
       // System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }

    @Override
    public void onStart(ITestContext context) {
        // not implemented
        report = new ExtentReports(System.getProperty("user.dir")+"/ExtentReportResults.html");
        extent_reports.set(report);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Method started"+ iTestResult.getName());
        System.out.println("onTestStart Execution");
        test = report.startTest(iTestResult.getMethod().getMethodName());
        extent_test.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Method passed"+ iTestResult.getName());
        System.out.println("onTestSuccess Execution");
        String logText = " <b> Test Method "+ iTestResult.getMethod().getMethodName() + "Successful <b>";
        extent_test.get().log(LogStatus.PASS,"Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Method failed"+ iTestResult.getName());
        System.out.println("onTestFailure Execution");

        extent_test.get().log(LogStatus.FAIL, "Test Failed   " + iTestResult.getThrowable().getMessage());

        // extent_test.get().log(LogStatus.INFO,extent_test.get().addScreenCapture(sc.takeScreenshot(getDriver())));
        //addScreenshot(getDriver());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped Execution");
        // String logText = " <b> Test Method "+ iTestResult.getMethod().getMethodName() + "Skipped <b>";
        extent_test.get().log(LogStatus.SKIP,"Skipped");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish Execution");
        if(extent_reports.get() != null) {
            extent_reports.get().endTest(extent_test.get());
            extent_reports.get().flush();
            //report.flush();
           // report.close();
           // report.endTest(test);
        }
    }

//    public void addScreenshot(WebDriver driver) {
//        test.log(LogStatus.INFO,extent_test.get().addScreenCapture(sc.takeScreenshot(driver)));
//    }
}
