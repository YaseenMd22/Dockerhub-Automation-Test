package docker.testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.DockerHubContainersPage;
import pages.GooglePage;

public class GoogleTest extends BaseTest{
	@Test(description = "Google page")
	@Description("Google page")
	@Epic("EP001")
	@Feature("Feature1: Google page")
	@Story("Story: Google home page")
	@Step("Google home page title validation")
	@Severity(SeverityLevel.NORMAL)
	public void containers_Exercise() {
		GooglePage gp = page.GetInstance(GooglePage.class);
		driver.get(prop.getProperty("URL2"));
		gp.google();
		
	}
}
