package FreshHarvest.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObjects() {
		// Below are Steps or ways to define Extent Report method to use this method to
		// generate reports for our test
		// ExtentSparkReporter - used to create HTML Report Page or File
		// ExtentReports - use the created created Page for test
		// and with help of Listners - Test scope are recorded in Report Page
		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Fresh Harvest Application Test Results");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Tharun");

		return extent;
	}
}