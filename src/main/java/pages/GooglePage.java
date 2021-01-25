package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import base.BasePage;

@Listeners(utilities.TestListener.class)
public class GooglePage extends BasePage {
	
	public GooglePage(WebDriver driver) {
		super(driver);
	}
	

	public void google() {

		assertEquals(driver.getTitle(), "Google", "Failed to validate");
		passLog("Validated Google home page title");
	}
	
	
	
}
