package toyota.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

import static toyota.tdd.utils.IConstant.*;

import java.time.Duration;

import toyota.tdd.objects.LandingPage;
import toyota.tdd.utils.ReadProperties;

public class BaseClass {
	
	protected WebDriver driver;
	protected LandingPage landingPage;
	ReadProperties enVar;
	
	@BeforeSuite
	public void setUpSuite() {
		enVar = new ReadProperties();
	}
	
	@BeforeMethod   // pre-condition
	public void setUpDriver() {
		String browser = enVar.getProperty(BROWSER);
		String url = enVar.getProperty(URL);
		long pageLoadWait = enVar.getNumProperty(PAGELOAD_WAIT);
		long implicitlyWait = enVar.getNumProperty(IMPLICIT_Wait);
		
		initDriver(browser);
		initClasses(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		
		
	}
	
	private void initClasses (WebDriver driver) {
		landingPage = new LandingPage(driver);
	}
	
	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
