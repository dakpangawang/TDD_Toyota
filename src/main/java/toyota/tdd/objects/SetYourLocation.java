package toyota.tdd.objects;

import static toyota.tdd.common.CommonActions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetYourLocation {

	public SetYourLocation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[normalize-space(text())='Set your location']")
	WebElement setYourLocationPageTitle;

	@FindBy(xpath = "//input[@name='zipcode']")
	WebElement zipCodeInput;

	@FindBy(xpath = "//button[normalize-space(text())='Submit']")
	WebElement submitBtn;

	public void validateSetYourLocationPageTitle(String expectedTitle) {
		validate(setYourLocationPageTitle, expectedTitle);
	}

	public void enterZipCode() {
		insert(zipCodeInput, "11373");
	}
	
	public void clickSubmit () {
		click(submitBtn);
	}

}
