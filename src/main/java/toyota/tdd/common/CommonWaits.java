package toyota.tdd.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static toyota.tdd.utils.IConstant.*;

import toyota.tdd.utils.ReadProperties;

public class CommonWaits {
	
	static ReadProperties properties = new ReadProperties();
	static long explicitlyWait = properties.getNumProperty(EXPLICIT_WAIT);
	
	public static void explicitWaitByElementVisilbility(WebDriver driver, WebElement element) {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlyWait));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWaitByElementClickable(WebDriver driver, WebElement element) { 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlyWait));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
