package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtil {	
	
	public static ExtentReports reports;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public static ExtentReports getReportConfig() {
		if(reports==null) {
			reports = new ExtentReports();
			String reportPath = System.getProperty("user.dir") + "/reports/extent-report.html";
			spark = new ExtentSparkReporter(reportPath);
			spark.config().setReportName("This is a Report Name");
			spark.config().setDocumentTitle("Document Title");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setEncoding("utc-8");		
			reports.attachReporter(spark);	
		}			
		return reports;
	}
	
	public static ExtentTest setTestname(String strTestName) {
		test = reports.createTest(strTestName);		
		test.info("Test Name Set: "+ strTestName);
		return test;
	}
	
	public static void flushReport() {
		reports.flush();
	}

}
