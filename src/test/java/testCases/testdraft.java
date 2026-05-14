package testCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testdraft {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		

		String s = driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("placeholder");
		String s1 = driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("placeholder");
		String s3 = null;
		
		ArrayList<String> placeholders = new ArrayList<String>();
		placeholders.add(s);
		placeholders.add(s1);
		placeholders.add(s3);
		
		System.out.println(placeholders.toString());

	}

}
