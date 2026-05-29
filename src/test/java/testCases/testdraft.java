package testCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testdraft {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("merilovig@mailinator.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123123Sd@");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(2000);
		
		Set<Cookie> cookies =  driver.manage().getCookies();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		driver = new FirefoxDriver();
		
		Thread.sleep(2000);
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		
        driver.navigate().refresh();
		
        
		
		//driver.quit();
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
