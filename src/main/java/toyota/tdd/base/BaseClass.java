package toyota.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import static toyota.tdd.utils.IConstant.*;
import java.lang.reflect.Method;
import java.time.Duration;
import toyota.tdd.objects.BuildYourToyotaPage;
import toyota.tdd.objects.CamryLEHybridPage;
import toyota.tdd.objects.FindADealerPage;
import toyota.tdd.objects.LandingPage;
import toyota.tdd.objects.SetYourLocation;
import toyota.tdd.utils.ReadProperties;
import toyota.tdd.utils.Constant;

public class BaseClass extends ExtentListener{

	protected WebDriver driver;
	protected LandingPage landingPage;
	protected SetYourLocation setYourLocation;
	protected BuildYourToyotaPage buildYourToyotaPage;
	protected FindADealerPage findADealerPage;
	protected CamryLEHybridPage camryLEHybridPage;
  	ReadProperties enVar = new ReadProperties();

	//@Parameters("browser")
	@BeforeMethod 
	public void setUpDriver() {
		String browser = enVar.getProperty(BROWSER);
		initDriver(browser);
		String url = enVar.getProperty(URL);
		driver.get(url);
		driver.manage().window().maximize();
		long pageLoadWait = enVar.getNumProperty(PAGELOAD_WAIT);
		long implicitlyWait = enVar.getNumProperty(IMPLICIT_WAIT);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClasses();
	}

	private void initClasses() {
		landingPage = new LandingPage(driver);
		setYourLocation = new SetYourLocation(driver);
		buildYourToyotaPage = new BuildYourToyotaPage(driver);
		findADealerPage = new FindADealerPage(driver);
		camryLEHybridPage = new CamryLEHybridPage(driver);
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
	
	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
			test.addScreenCaptureFromPath(captureScreenShot(driver, method.getName()));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
	}
	
	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}

}

















