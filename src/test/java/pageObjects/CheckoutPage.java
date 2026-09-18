package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		super();
	}

	@FindBy(xpath = "//input[@value='existing']")
	WebElement existingAddressRadio;
	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement addressContinueBtn;

	@FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']")
	WebElement existingShippingAddressRadio;
	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement shippingAddressContinueBtn;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement shippingMethodContinueBtn;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreeCheckbox;
	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement paymentMethodContinueBtn;

	@FindBy(xpath = "//div[1]/table/tbody/tr/td[1]/a")
	WebElement productName;

	// action
	public void clickExistingAddressRaido() {
		if (!existingAddressRadio.isSelected()) {
			click(existingAddressRadio);
		} else {
			return;
		}
	}

	public void addressContinueBtn() {
		click(addressContinueBtn);
	}

	public void clickExistingShippingAddressRaido() {
		if (!existingShippingAddressRadio.isSelected()) {
			click(existingShippingAddressRadio);
		} else {
			return;
		}
	}

	public void clickShippingAddressContinueBtn() {
		click(shippingAddressContinueBtn);
	}

	public void clickShippingMethodContinueBtn() {
		click(shippingMethodContinueBtn);
	}

	public void clickAgreeCheckbox() {
		if (!agreeCheckbox.isSelected()) {
			click(agreeCheckbox);
		} else {
			return;
		}
	}

	public void clickPaymentMethodContinueBtn() {
		click(paymentMethodContinueBtn);
	}

	public ProductDisplayPage clickProductName() {
		click(productName);
		
		return new ProductDisplayPage();
	}

	public void skipToStep(int step) throws InterruptedException {

		if (step <= 2 || step > 6) {
			System.out.println("Invalid step input!");
			return;
		}
		
		Thread.sleep(1000);
		
		if (step >= 3) {
			// Step 2
			clickExistingAddressRaido();
			addressContinueBtn();
		}

		Thread.sleep(1000);
		
		if (step >= 4) {
			// Step 3
			clickExistingShippingAddressRaido();
			clickShippingAddressContinueBtn();
		}
		
		Thread.sleep(1000);

		if (step >= 5) {
			// Step 4
			clickShippingMethodContinueBtn();
		}
		
		Thread.sleep(1000);

		if (step == 6) {
			// Step 5
			clickAgreeCheckbox();
			clickPaymentMethodContinueBtn();
		}

		Thread.sleep(1000);
	}

}
