package docker.testcases;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.DockerHubContainersPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.TestListener.class)
public class ContainersTest extends BaseTest {
	@Test(description = "Dockerhub Containers tab validation exercise")
	@Description("Dockerhub Containers tab validation exercise")
	@Epic("EP001")
	@Feature("Feature1: Dockerhub")
	@Story("Story: containers tab")
	@Step("Validate Containers tab")
	@Severity(SeverityLevel.NORMAL)
	public void containers_Exercise() {
		DockerHubContainersPage dockerHubContainersPage = page.GetInstance(DockerHubContainersPage.class);
		driver.get(prop.getProperty("URL"));
		dockerHubContainersPage.currentTabValidation();
		dockerHubContainersPage.imagesCheckboxValidation();
		dockerHubContainersPage.categoriesValidation();
		dockerHubContainersPage.checkVerifiedPublisherCheckbox();
		dockerHubContainersPage.checkAdditionalFilters();
		dockerHubContainersPage.validatingFilter();
	}
}