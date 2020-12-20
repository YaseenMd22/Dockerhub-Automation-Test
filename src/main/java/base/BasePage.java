package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import utilities.ExtentTestManager;

public class BasePage extends PageGenerator {

	public BasePage(WebDriver driver) {
		super(driver);
	}


	// Invoked when Test step is passed
	public void passLog(String log) {
		ExtentTestManager.getTest().log(LogStatus.PASS, log);
	}

	// Invoked when Test step is passed
	public boolean failLog(String log) {
		ExtentTestManager.getTest().log(LogStatus.FAIL, log);
		throw new RuntimeException();
	}

	// Invoked to click on web element and log the message
	public void click(WebElement elementAttr, String log) {
		try {
			elementAttr.click();
			passLog("Successfully clicked on " + log);
		} catch (Exception e) {
			failLog("Unable to click " + log);
		}
	}

	// Invoked to check if actual element is equal to expected element
	public <T> void assertEquals(T actual, T expected, String failLog) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, failLog);
			e.printStackTrace();
			throw e;
		}
	}

}
