package DemoSwagLab;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReport;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentReports extent = ExtentReport.getExtentReport();
	ExtentTest test;
	//by using paralled Thread local
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		//to print method name
		System.out.println(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passes");
	System.out.println(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// to send to screenshot to access which test is going to fail
		extentTest.get().log(Status.FAIL, result.getThrowable());
		WebDriver driver = null;
	//screenshot
	String testCaseName=result.getName();
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e1) {
	}
	try {
		extentTest.get().addScreenCaptureFromPath(	getScreenShotPaths(testCaseName,driver),result.getMethod().getMethodName());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	;
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}
	
	
	
	
	
	
	

}
