package docker.testcases;

import base.BaseTest;
import pages.DockerHubContainersPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.TestListener.class)
public class Containers extends BaseTest {
	@Test(description = "Dockerhub Containers tab validation exercise")
	public void containers_Exercise() {
		DockerHubContainersPage dockerHubContainersPage = page.GetInstance(DockerHubContainersPage.class);
		dockerHubContainersPage.currentTabValidation();
		dockerHubContainersPage.imagesCheckboxValidation();
		dockerHubContainersPage.categoriesValidation();
		dockerHubContainersPage.checkVerifiedPublisherCheckbox();
		dockerHubContainersPage.checkAdditionalFilters();
		dockerHubContainersPage.validatingFilter();

	}
}