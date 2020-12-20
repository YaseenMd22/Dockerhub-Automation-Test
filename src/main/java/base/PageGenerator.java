package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

	public WebDriver driver;

	// Constructor
	public PageGenerator(WebDriver driver) {
		this.driver = driver;
	}

	// Java Generics to create and return a new page
	public <TPage extends BasePage> TPage GetInstance(Class<TPage> pageClass) {
		try {
			// Initialize the Page with its elements and return it
			return PageFactory.initElements(driver, pageClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
