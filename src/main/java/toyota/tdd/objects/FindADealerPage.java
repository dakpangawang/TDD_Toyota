package toyota.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import toyota.tdd.common.CommonActions;

public class FindADealerPage {
	
	CommonActions actions;
	
	public FindADealerPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy (xpath = "//h1[text()='by ZIP Code, City & State or Dealer Name']")
	WebElement findADealerPageTitle;
	
	@FindBy (xpath = "//button[@data-form-type='REQUEST_QUOTE']")
	WebElement requestAQuoteBtn;
	
	public void validateFindADealerPageTitle (String expectedTitle) {
		actions.validate(findADealerPageTitle, expectedTitle);
	}
	
	public void clickrequestAQuoteBtn () {
		actions.click(requestAQuoteBtn);
	}
 
}
