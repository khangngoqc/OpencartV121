package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountEditPage extends BasePage {
	
	public AccountEditPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath ="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath ="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath ="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath ="//input[@id='input-telephone']") WebElement txtTelephone;
	
	//get field input value as String
	public String getValueAttribute(WebElement e) {
		return e.getAttribute("value");
	}

	//getters
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtTelephone() {
		return txtTelephone;
	}
	
	


}
