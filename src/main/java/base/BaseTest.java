package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	public static Properties prop;
	public PageGenerator page;
	public static String workingDir = System.getProperty("user.dir");
	public String propFilePath = workingDir + "\\config.properties";

	// Constructor to initialize the properties file
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream(propFilePath);
			prop.load(fp);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// Delete all cookies
		driver.manage().deleteAllCookies();

		// Page load timeout for 30 seconds
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Implicit wait timeout for 20 seconds
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Instantiate the Page class
		page = new PageGenerator(driver);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}
