package testCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testdraft {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");


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
