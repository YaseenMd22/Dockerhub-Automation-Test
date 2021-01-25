package base;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

//import utilities.ExtentTestManager;

public class BasePage extends PageGenerator {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	// Invoked when Test step is passed
	public void passLog(String log) {
		logger("PASS", getTimeStamp(), log);
	}

	// Invoked when Test step is passed
	public void failLog(String log) {
		logger("FAIL", getTimeStamp(), log);
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
			logger("FAIL", getTimeStamp(), failLog);
			throw e;
		}
	}

	@Step("[{0}] [{1}] : {2}") 
	public void logger(String status, String timeStamp, String log) {
		System.out.println(status+" "+timeStamp+": "+log);
	}
	
	public static String getTimeStamp() {
		Format f = new SimpleDateFormat("HH.mm.ss");
		String timeStamp = f.format(new Date());
		return timeStamp;
	}
}
