package toyota.tdd.common;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import toyota.tdd.reporting.Logs;
import toyota.tdd.utils.ReadProperties;
import static toyota.tdd.utils.IConstant.*;

public class CommonActions {

	ReadProperties envProperties = new ReadProperties();
	public WebDriverWait wait;

	public CommonActions(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(envProperties.getNumProperty(EXPLICIT_WAIT)));
	}

	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Logs.log(element + "--> has been clicked");
		} catch (NullPointerException | NoSuchElementException | TimeoutException e) {
			Logs.log(element + "---> Element Not Found");
			Assert.fail();
		}
	}

	public void validate(WebElement element, String expected) {
		String actual = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actual = element.getText();
			Logs.log("Validating --> Actual : ***" + actual + "***. Expected: ***" + expected + " ***");
		} catch (NullPointerException | NoSuchElementException | TimeoutException e) {
			Logs.log(element + "---> Element Not Found");
			Assert.fail();
		}
		Assert.assertEquals(actual, expected);
	}

	public void insert(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
			Logs.log(value + " <-------- This value has been passed into -->" + element);
		} catch (NullPointerException | NoSuchElementException | TimeoutException e) {
			Logs.log(element + "---> Element Not Found");
			Assert.fail();
		}
	}

}
