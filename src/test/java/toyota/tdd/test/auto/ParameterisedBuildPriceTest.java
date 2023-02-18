package toyota.tdd.test.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import toyota.tdd.base.BaseClass;
import toyota.tdd.utils.AutoData;

public class ParameterisedBuildPriceTest extends BaseClass{
	
	@Parameters ({"landingPageTitle","setYourLocationPageTitle","buildYourToyotaTitle"})
	@Test (enabled = false, groups = "Auto")
	public void buldAndPriceTest(String landingPageTitle, String setYourLocationPageTitle, String buildYourToyotaTitle) {
		landingPage.validateLandingPageTitle(landingPageTitle);
		landingPage.clickBuildAndPrice();
		setYourLocation.validateSetYourLocationPageTitle(setYourLocationPageTitle);
		setYourLocation.enterZipCode(driver);
		setYourLocation.clickSubmit();
		buildYourToyotaPage.validateBuildYourToyotaPageTitle(buildYourToyotaTitle);
	}
	
	@Parameters ({"landingPageTitle","setYourLocationPageTitle","buildYourToyotaTitle"})
	@Test (enabled = true, groups = "Auto")
	public void buldAndPriceTest_AutoData(String landingPageTitle, String setYourLocationPageTitle, String buildYourToyotaTitle) {
		AutoData autoData = new AutoData(landingPageTitle, setYourLocationPageTitle, buildYourToyotaTitle);
		landingPage.validateLandingPageTitle(autoData.getLandingPageTitle());
		landingPage.clickBuildAndPrice();
		setYourLocation.validateSetYourLocationPageTitle(autoData.getSetYourLocationPageTitle());
		setYourLocation.enterZipCode(driver);
		setYourLocation.clickSubmit();
		buildYourToyotaPage.validateBuildYourToyotaPageTitle(autoData.getBuildYourToyotaTitle());
	}

}
