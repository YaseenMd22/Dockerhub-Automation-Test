package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class TestListener extends BaseTest implements ITestListener {
	
	
	
	// Invoked each time before a test
	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println(iTestResult.getName() + " test case started");
	}

	// Invoked on the success of any Test
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("The name of the testcase passed is :" + iTestResult.getName());
	}

	// Invoked on the failure of any Test
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("The name of the testcase failed is :" + iTestResult.getName());
		Object currentClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTest) currentClass).getDriver();
		System.out.println("Allure Screenshot captured for testcase: "+iTestResult.getMethod().getMethodName());
		failureScreenshot(driver);
	}
	
	@Attachment
	public byte[] failureScreenshot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);	
	}

	// Invoked on skipped of any Test
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("The name of the testcase Skipped is :" + iTestResult.getName());
	}

	// below method executes each time Test fails but is within success percentage
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	}

	// Invoked before starting all tests
	@Override
	public void onStart(ITestContext iTestContext) {
		iTestContext.setAttribute("WebDriver", this.driver);
	}

	// Invoked after ending all tests
	@Override
	public void onFinish(ITestContext iTestContext) {
//		ExtentManager.getReporter().flush();
	}

}
