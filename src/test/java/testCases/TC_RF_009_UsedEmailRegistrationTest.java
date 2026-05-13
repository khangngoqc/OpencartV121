package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_009_UsedEmailRegistrationTest extends BaseClass{

	@Test(groups = {"master", "register"})
	void validate_registration_with_used_email(){
		
		try {
		
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			rp.setFirstName(randomString());
			rp.setLastName(randomString());
			
			rp.setEmail(p.getProperty("email"));
			
			rp.setTelephone(randomNumber());
			
			String pwd = p.getProperty("password");
			rp.setPassword(pwd);
			rp.setPasswordConfirm(pwd);
			
			rp.clickPrivacyPolicy();
			
			rp.clickContinue();
			
			boolean warningDisplay = rp.isWarningDisplayed(rp.getUsedEmailWarning());
			
			Assert.assertTrue(warningDisplay);
		
		
		} catch (Exception e) {
		
			Assert.fail();
			logger.debug(e.getMessage());
			
		}
			
	}
	
}
