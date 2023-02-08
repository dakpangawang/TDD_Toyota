package toyota.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static toyota.tdd.common.CommonActions.*;

public class LandingPage {
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Explore All Vehicles']")
	WebElement landingPageTitle;

	@FindBy(xpath = "//img[@alt='Build & Price']")
	WebElement buildAndPriceBtn;

	@FindBy(xpath = "//button[normalize-space(text())='Submit']")
	WebElement submitBtn;
	
	@FindBy (xpath = "//img[@data-aa-link-text='Find A Dealer']")
	WebElement finADealer;

	public void validateLandingPageTitle(String expectedTitle) {
		validate(landingPageTitle, expectedTitle);
	}

	public void clickBuildAndPrice() {
		click(buildAndPriceBtn);
	}
	
	public void clickFindADealer () {
		click(finADealer);
	}

	

}
