package toyota.tdd.test.auto;
import org.testng.Assert;
import org.testng.annotations.Test;

import toyota.tdd.base.BaseClass;
import toyota.tdd.reporting.Logs;


public class BuildPriceTest extends BaseClass {

	@Test(enabled = true)
	public void buldAndPriceTest() {
		landingPage.validateLandingPageTitle("Explore All Vehicles");
		landingPage.clickBuildAndPrice();
		setYourLocation.validateSetYourLocationPageTitle("SET YOUR LOCATION");
		setYourLocation.enterZipCode(driver);
		setYourLocation.clickSubmit();
		buildYourToyotaPage.validateBuildYourToyotaPageTitle("Build Your Toyota");
        buildYourToyotaPage.clickCamryHybrid2023();
	    camryLEHybridPage.validateCamryLEHybridPageTitle("2023 Camry LE Hybrid");
	    camryLEHybridPage.clickNextStepBtn(driver);
	    camryLEHybridPage.clickNextStepBtn(driver);
	    camryLEHybridPage.clickNextStepBtn(driver);
	    camryLEHybridPage.clickNextStepBtn(driver);
	    camryLEHybridPage.clickNextStepBtn(driver);
	    camryLEHybridPage.clickRequestAQuoteBtn(driver);
	}

	@Test(enabled = false)
	public void test01() {
		Logs.log("Test01");
	}

	@Test(enabled = false)
	public void test02() {
		Logs.log("Test02");
		Assert.fail();
	}

	@Test(enabled = false, retryAnalyzer = toyota.tdd.retry.RetryFailedTests.class)
	public void testRetry() {
		Logs.log("Retry Test");
		Assert.fail();
	}

}
