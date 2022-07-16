package resources;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
	
			// we need to use two objects here
			
			//ExtentReports, ExtentSparkReporter
			//we need to give the path System.getProperty("user.dir")+"\\reports\\index.html"; it will take to that location where the report will be stored
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
			reporter= new ExtentSparkReporter(path);
			// to change the name
			reporter.config().setReportName("Web Automation");
			// to change the title
			reporter.config().setDocumentTitle("Test Result");
			
			extent=new ExtentReports() ;
			extent.attachReporter(reporter);
			// to give name
			extent.setSystemInfo("Tester", "Harsha");

			return extent;
		}
	}


