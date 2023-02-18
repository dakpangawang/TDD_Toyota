package toyota.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static toyota.tdd.common.CommonActions.*;


public class BuildYourToyotaPage {
	
	public BuildYourToyotaPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".ttac-headline.align-center")
	WebElement buildYourToyotaPageTitle;
	
	@FindBy (xpath = "//div[@data-aa-link-text='build 2023 camry']//following-sibling::div[@data-aa-link-text='build 2022 camryhybrid']//following-sibling::div[@data-aa-link-text='build 2023 camryhybrid']")
	WebElement camryHybrid2023Car;
	
	
	public void validateBuildYourToyotaPageTitle (String expectTile) {
		validate(buildYourToyotaPageTitle, expectTile);
	}
	
	public void clickCamryHybrid2023 () {
		click(camryHybrid2023Car);
	}

}
