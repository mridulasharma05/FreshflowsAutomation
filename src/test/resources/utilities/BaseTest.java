package utilities;

import commonUtils.JsonDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

// cross platform
import java.util.concurrent.TimeUnit;

@Listeners({Helper.class})
public class BaseTest {

	public WebDriver driver;

	public JsonDataReader dataReader;


	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://kiwi.qa.freshflows.io/login")
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		setZaleniumResult(result);
		driver.quit();
	}

}
