package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	
	ExtentTest test;                                       //made it  global level,so we can use it in other methods
	ExtentReports extent=ExtentReporter.getReportObject(); //used class name to call method after making this static in ExtentReport.java
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) 
	{
		
		 test= extent.createTest(result.getMethod().getMethodName());//to get method name dynamically through testng listeners
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		test.log(Status.PASS, "Test is passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		//test.fail(result.getThrowable());       //to get the log of failed reports
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			   driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			/*}catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();*/
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			//getScreenShotPath(testMethodName,driver);  //add return destinationFile in getScreenShotPath method,so that it takes screen shot,and return the path and we gave this path in the above line in the field of imagepath
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
