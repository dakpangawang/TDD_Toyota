package toyota.tdd.test.findADealer;

import org.testng.annotations.Test;

import toyota.tdd.base.BaseClass;

public class FindADealerTest extends BaseClass{
	
	@Test
	public void createFindADealerTest () {
		landingPage.validateLandingPageTitle("Explore All Vehicles");
		setYourLocation.validateSetYourLocationPageTitle("SET YOUR LOCATION");
		setYourLocation.enterZipCode();
		setYourLocation.clickSubmit();
		findADealerPage.validateFindADealerPageTitle("Find a Dealer by ZIP Code, City & State or Dealer Name");
	    findADealerPage.clickrequestAQuoteBtn();
	}

}
