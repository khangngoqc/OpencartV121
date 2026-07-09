package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.mm.ss"); Date dt = new
		 * Date(); String currentdatetimestamp = df.format(dt);
		 */
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		
		repName = "Test-Report-" + timeStamp + ".html" ;
		String reportPath = System.getProperty("user.dir") + "/reports/" + repName;
		sparkReporter = new ExtentSparkReporter(reportPath); //specify location of the report
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); //Title of the report
		sparkReporter.config().setReportName("opencart Functional Testing"); //name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");	
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
	
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Operating System", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName()); //create test entry
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		
		test.log(Status.PASS, result.getName() + "  got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		
		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		
		test.log(Status.SKIP, result.getName() + " got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();

		// open the report immediately
		String pathOfExtentReport = System.getProperty("user.dir") + "/reports/" + repName;
		File extentReport = new File(pathOfExtentReport);

		if (!extentReport.exists()) {
			System.err.println("Extent report not found at: " + extentReport.getAbsolutePath());
			return;
		}

		try {
			String os = System.getProperty("os.name").toLowerCase();
			if (os.contains("mac")) {
				new ProcessBuilder("open", extentReport.getAbsolutePath()).start();
			} else if (os.contains("win")) {
				new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", extentReport.getAbsolutePath()).start();
			} else {
				// Linux fallback
				new ProcessBuilder("xdg-open", extentReport.getAbsolutePath()).start();
			}
		} catch (Exception e) {
			System.err.println("Falling back to Desktop.browse() due to: " + e.getMessage());
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	
		
	}
	
	
}

