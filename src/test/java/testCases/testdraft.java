package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class testdraft {

	static WebDriver driver;
	public static MailosaurClient mailosaur;

	
	public static void main(String[] args) throws InterruptedException, IOException, MailosaurException {
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Mailosaur setup
		mailosaur = new MailosaurClient("eAAT0o0VRMH1oehzUMWGKYxmCMFbtSKk");
		
		//String uniqueUser = "testuser_" + System.currentTimeMillis();
		String testEmail = "anything3@khnqlfjj.mailosaur.net";
		String serverID = "khnqlfjj";
		
		
		driver.get("https://supplier.valovietnam.com/vi/reset-password");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(testEmail);
		driver.findElement(By.xpath("//button[contains(text(),'Xác thực email của bạn')]")).click();
		
		Thread.sleep(5000);
		
		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverID);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo(testEmail);
		
		Message email = mailosaur.messages().get(params, criteria);
		Assert.assertNotNull(email, "Reset password email was not received.");
		Assert.assertEquals(email.subject(), "Your Password Reset Code");
		
		System.out.println(email.subject());
		
		String otpCode = email.text().codes().get(0).value();
		
		System.out.println("Extracted OTP Code: " + otpCode);
		
		
		for (int i =0; i<=3; i++) {
			int input = i + 1;
			driver.findElement(By.xpath("//input["+ input +"]")).sendKeys(String.valueOf(otpCode.charAt(i)));
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Xác thực mã số')]")).click();
		
		String newPassword = "123123Qt@";
		
		driver.findElement(By.xpath("//input[@placeholder='Mật khẩu của bạn']")).sendKeys(newPassword);
		driver.findElement(By.xpath("//input[@placeholder='Nhập lại mật khẩu']")).sendKeys(newPassword);
		driver.findElement(By.xpath("//button[contains(text(),'Đổi mật khẩu')]")).click();
		
		driver.quit();
		
		
	}

	void handle_cookie_session_timeout() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(2000);
		
		Cookie sessionCookie = driver.manage().getCookieNamed("orangehrm");
		
		
		
		if(sessionCookie != null) {
			
			long thirtyOneDaysInMillis = 365L * 24 * 60 * 60 * 1000;
			Date pastDate = new Date(System.currentTimeMillis() - thirtyOneDaysInMillis);
			Cookie expiredCookie  = new Cookie("Test", sessionCookie.getValue(), sessionCookie.getDomain(), sessionCookie.getPath(), pastDate, sessionCookie.isSecure(), sessionCookie.isHttpOnly());			
			
			driver.manage().deleteCookie(sessionCookie);
			driver.manage().addCookie(expiredCookie);
		}
		

		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		
		String currentURL = driver.getCurrentUrl();

	}
	
	
	void broken_link_check() {
		// capture all the links from the webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());

		int noOfBrokenLink = 0;

		for (WebElement l : links) {

			String hrefAttrValue = l.getAttribute("href");

			if (hrefAttrValue == null || hrefAttrValue.isEmpty()) {
				System.out.println(l.getText() + "href attribute value is empty => Impossible to check");
				continue;
			}

			// hit the URL to the server
			try {

				URL linkURL = new URL(hrefAttrValue); // converted href value from string to URL format
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); // open connection to the server
				conn.connect(); // connect to server and send request to the server

				if (conn.getResponseCode() >= 400) {
					System.out.println(
							l.getText() + "	" + conn.getResponseCode() + "	" + hrefAttrValue + "	(Broken link)");
					noOfBrokenLink++;
				} else {
					System.out.println(l.getText() + "	" + hrefAttrValue + "	=> Not a broken link");
				}

			} catch (Exception e) {
			}

		}

		System.out.println("Number of broken links: " + noOfBrokenLink);

	}

	void check_covered_password() {
		WebElement input = driver.findElement(By.xpath("//input[@id='input-password']"));
		input.sendKeys("123125dgf");

		// Check if the CSS forces password masking symbols visually
		String textSecurity = input.getCssValue("-webkit-text-security");

		if ("disc".equals(textSecurity) || "circle".equals(textSecurity) || "square".equals(textSecurity)) {
			System.out.println("The text is visually masked by CSS.");
		}
	}

	void store_null_element_attribute() {

		String s = driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("placeholder");
		String s1 = driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("placeholder");
		String s3 = null;

		ArrayList<String> placeholders = new ArrayList<String>();
		placeholders.add(s);
		placeholders.add(s1);
		placeholders.add(s3);

		System.out.println(placeholders.toString());

	}

	void get_pseudo_element_content() {

		// 1. Locate the parent element
		WebElement parentElement = driver.findElement(By.cssSelector(".your-element-class"));

		// 2. Execute JavaScript to get the property
		String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";
		String content = (String) ((JavascriptExecutor) driver).executeScript(script, parentElement);

		System.out.println(content);

	}
}
