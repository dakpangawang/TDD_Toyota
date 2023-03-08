package toyota.tdd.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import toyota.tdd.common.CommonActions;

public class LandingPage {
	
	CommonActions actions;
	JavascriptExecutor js;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//h2[text()='Explore All Vehicles']")
	WebElement landingPageTitle;

	@FindBy(xpath = "//img[@alt='Build & Price']")
	WebElement buildAndPriceBtn;

	@FindBy(xpath = "//button[normalize-space(text())='Submit']")
	WebElement submitBtn;
	
	public void validateLandingPageTitle(String expectedTitle) {
		actions.validate(landingPageTitle, expectedTitle);
	}

	public void clickBuildAndPrice() {
		js.executeScript("arguments[0].click();", buildAndPriceBtn);
//		actions.click(buildAndPriceBtn);
	}

	

}
