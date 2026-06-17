package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mailosaur.MailosaurClient;

public class BaseClass {

	public static final ThreadLocal<WebDriver> driver =  new ThreadLocal<>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public Logger logger; // ;Log4j
	public Properties p;
	public Actions act;
	public WebDriverWait wait;
	public MailosaurClient mailosaur;

	@BeforeClass(groups = { "sanity", "regression", "master", "logout", "login", "search", "register", "forgot password" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		// logger setup
		logger = LogManager.getLogger(this.getClass());

		// remote environment Selenium grid setup
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching os");
				return;

			}

			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicroSoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;

			default:
				System.out.println("No matching browser");
				return;
			}

			driver.set(ThreadGuard.protect(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities)));

		}

		// local environment setup
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			// browser setup
			switch (br.toLowerCase()) {
			case "chrome":
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
			case "edge":
				driver.set(ThreadGuard.protect(new EdgeDriver()));
				break;
			case "firefox":
				driver.set(ThreadGuard.protect(new FirefoxDriver()));
				break;

			default:
				System.out.println("Invalid browser name");
				return;
			}
		}

		// delete cookies & implicitWait methods
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// launch the website
		getDriver().get(p.getProperty("appURL")); // reading URL from properties file

		// Action class object
		act = new Actions(getDriver());

		// Explicit wait object
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		
		//Mailosaur setup
		mailosaur = new MailosaurClient(p.getProperty("mailosaurAPI"));
		

	}

	@AfterClass(groups = { "sanity", "regression", "master", "logout", "login", "search", "register" , "forgot password"})
	public void tearDown() {
		getDriver().quit();
		driver.remove();
	}

	public String randomString() {
		String genString = RandomStringUtils.randomAlphabetic(5);
		return genString;
	}

	public String randomNumber() {
		String genNumber = RandomStringUtils.randomNumeric(10);
		return genNumber;
	}

	public String randomAlphaNumberString() {
		String genString = RandomStringUtils.randomAlphabetic(3);
		String genNumber = RandomStringUtils.randomNumeric(3);

		return genString + genNumber;
	}

	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenShot = (TakesScreenshot) getDriver();
		File srcFile = takesScreenShot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		srcFile.renameTo(targetFile);

		return targetFilePath;

	}

	public boolean brokenLinksCheck() {
		
		WebDriver currentDriver = getDriver();
		
		// capture all the links from the webpage
		List<WebElement> links = currentDriver.findElements(By.tagName("a"));
		logger.info("Total number of links on " + currentDriver.getTitle() +" page: " + links.size());

		int noOfBrokenLink = 0;

		
		for (WebElement l : links) {

			String hrefAttrValue = l.getAttribute("href");

			if (hrefAttrValue == null || hrefAttrValue.isEmpty()) {
				logger.info(l.getText() + "href attribute value is empty => Impossible to check");
				continue;
			}

			// hit the URL to the server
			try {

				URL linkURL = new URL(hrefAttrValue); // converted href value from string to URL format
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); // open connection to the
																						// server
				conn.connect(); // connect to server and send request to the server

				if (conn.getResponseCode() >= 400) {
					logger.info(l.getText() + "		" + conn.getResponseCode() + "		" + hrefAttrValue
							+ "	(Broken link)");
					noOfBrokenLink++;
				}

			} catch (Exception e) {
				logger.info(e.getMessage());
			}

		}

		if (noOfBrokenLink > 0) {

			logger.info("Number of broken links: " + noOfBrokenLink);
			return false;
		} else {
			return true;
		}

	}

}
