package toyota.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import toyota.tdd.common.CommonActions;

public class CamryLEHybridPage {
	
	CommonActions actions;
	
	public CamryLEHybridPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy (xpath = "//h2[text()='2023 Camry LE Hybrid']")
    WebElement camryLEHybridPageTitle;
	
	@FindBy (xpath = "//button[@class='tcom-step-button next button primary']")
	WebElement nextStepBtn;
	
	@FindBy (css = ".tcom-raq-cta.button.primary.raq-modal-cta.button-01")
	WebElement requestAQuoteBtn;
	
	public void validateCamryLEHybridPageTitle (String expectedTitle) {
		actions.validate(camryLEHybridPageTitle, expectedTitle);
	}
	
	public void clickNextStepBtn() {
		actions.click(nextStepBtn);
	}
	
	public void clickRequestAQuoteBtn() { 
		actions.click(requestAQuoteBtn);
	}
	

}
