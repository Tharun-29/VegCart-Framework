package FreshHarvest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import FreshHarvest.framework.pageobjects.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public ProductPage pg;

	public WebDriver initializeDriver() throws IOException {

		// Properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\THVS0621\\eclipse-workspace\\FreshHarvestFrameworkDesign\\src\\main\\java\\FreshHarvest\\resources\\GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions opt1 = new FirefoxOptions();
			opt1.setAcceptInsecureCerts(true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(opt1);
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public ProductPage launchApplication() throws IOException {
		driver = initializeDriver();
		//Driver reference is passed as argument below to Product Page and other classes from Page Object Folder to have driver ref
		pg = new ProductPage(driver);
		pg.goToProductPage();
		return pg;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

//	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
//
//		// Read JSON File to a Java Map
//
//		// Reading the Json to String first
//
//		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
//
//		// Converting String to HashMap using Jackson Databind
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
//				new TypeReference<List<HashMap<String, String>>>() {
//				});
//
//		return data;
//	}

	// Screenshot Method
	public String getScreenShot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png";
	}

}
