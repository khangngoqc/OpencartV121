package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_004_WarningMessageTest extends BaseClass {

	@Test(groups = { "master" })
	void verify_required_field_warning() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		rp.clickContinue();

		boolean[] warningsDiplayed = new boolean[] { rp.isWarningDisplayed(rp.getFirstNameWarning()),
				rp.isWarningDisplayed(rp.getLastNameWarning()), rp.isWarningDisplayed(rp.getEmailWarning()),
				rp.isWarningDisplayed(rp.getPasswordWarning()), rp.isWarningDisplayed(rp.getPolicyWarning())};
	
		for(boolean warning : warningsDiplayed) {
			Assert.assertTrue(warning, "One or more warning was not displayed");
		}
	
	}

}
