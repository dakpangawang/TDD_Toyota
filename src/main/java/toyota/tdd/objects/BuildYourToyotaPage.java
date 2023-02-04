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
	
	
	WebElement camryHybrid2023Car;
	
	public void validateBuildYourToyotaPageTitle (String expectTile) {
		validate(buildYourToyotaPageTitle, expectTile);
	}

}
