package toyota.tdd.test.auto;

import org.testng.Assert;
import org.testng.annotations.Test;

import toyota.tdd.base.BaseClass;
import toyota.tdd.reporting.Logs;

public class BuildPriceTest extends BaseClass{
	
	@Test (enabled = false)
	public void buldAndPriceTest() {
		landingPage.validateLandingPageTitle("Explore All Vehicles");
		landingPage.clickBuildAndPrice();
		setYourLocation.validateSetYourLocationPageTitle("SET YOUR LOCATION");
		setYourLocation.enterZipCode();
		setYourLocation.clickSubmit();
		buildYourToyotaPage.validateBuildYourToyotaPageTitle("Build Your Toyota");
	}
	
	@Test (enabled = true)
	public void test01() {
		Logs.log("Test01");
		Assert.fail();
	}
	@Test (enabled = true)
	public void test02() {
		Logs.log("Test02");
		Assert.fail();
	}
	
	
	@Test (enabled = false, retryAnalyzer = toyota.tdd.retry.RetryFailedTests.class)
	public void testRetry () {
		Logs.log("Retry Test");
		Assert.fail();
	}

}
