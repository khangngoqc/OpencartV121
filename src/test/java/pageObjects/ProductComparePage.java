package pageObjects;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage {

	public ProductComparePage() {
		super();
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li//a")
	List<WebElement> breadcrumbLinks;

	@FindBy(xpath = "(//p[normalize-space()='You have not chosen any products to compare.'])[1]")
	WebElement nonProductAddedMessage;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueBtn;

	public boolean isNonProductAddedMessageDisplayed() {
		return isDisplay(nonProductAddedMessage);
	}

	public HomePage clickContinueBtn() {
		click(continueBtn);
		return new HomePage();
	}

	public boolean isBreadcrumbWork() throws InterruptedException {

		for (int i = 0; i < breadcrumbLinks.size(); i++) {

			// System.out.println(breadcrumbLinks.get(i).getText());

			if (!breadcrumbLinks.get(i).isDisplayed()) {
				return false;

			} else if (i == 0) {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(getDriver().getCurrentUrl()).contains("home")) {
					// System.out.println(getDriver().getCurrentUrl());
					return false;
				}
				Thread.sleep(2000);

				getDriver().navigate().back();

			} else {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(getDriver().getCurrentUrl())
						.contains("compare")) {
					//System.out.println(getDriver().getCurrentUrl());
					return false;
				}
				Thread.sleep(2000);

				getDriver().navigate().back();

			}

		}

		return true;

	}
}
