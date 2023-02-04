package toyota.tdd.test.auto;

import org.testng.annotations.Test;

import toyota.tdd.base.BaseClass;

public class BuildPriceTest extends BaseClass{
	
	@Test
	public void buldAndPriceTest() {
		landingPage.validateLandingPageTitle("Explore All Vehicles");
		landingPage.clickBuildAndPrice();
		setYourLocation.validateSetYourLocationPageTitle("SET YOUR LOCATION");
		setYourLocation.enterZipCode();
		setYourLocation.clickSubmit();
		buildYourToyotaPage.validateBuildYourToyotaPageTitle("Build Your Toyota");
	}

}
