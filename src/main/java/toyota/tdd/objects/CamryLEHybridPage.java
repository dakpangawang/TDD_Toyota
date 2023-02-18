package toyota.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static toyota.tdd.common.CommonActions.*;
import static toyota.tdd.common.CommonWaits.*;

public class CamryLEHybridPage {
	
	public CamryLEHybridPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h2[text()='2023 Camry LE Hybrid']")
    WebElement camryLEHybridPageTitle;
	
	@FindBy (xpath = "//button[@class='tcom-step-button next button primary']")
	WebElement nextStepBtn;
	
	@FindBy (className = "tcom-raq-cta button primary raq-modal-cta button-01")
	WebElement requestAQuoteBtn;
	
	public void validateCamryLEHybridPageTitle (String expectedTitle) {
		validate(camryLEHybridPageTitle, expectedTitle);
	}
	
	public void clickNextStepBtn(WebDriver driver) {
		explicitWaitByElementVisilbility(driver, nextStepBtn);
		click(nextStepBtn);
	}
	
	public void clickRequestAQuoteBtn(WebDriver driver) { 
		explicitWaitByElementVisilbility(driver, requestAQuoteBtn);
		click(requestAQuoteBtn);
	}
	

}
