package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_010_InvalidEmailRegistrationTest extends BaseClass{

	@Test(groups = {"master", "register"})
	void validate_registration_with_invalid_email(){
		
		logger.info("******* Starting TC_RF_0010_InvalidEmailRegistrationTest *******");
		
		try {
		
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage rp = new AccountRegistrationPage();
			rp.setFirstName(randomString());
			rp.setLastName(randomString());
			
			rp.setTelephone(randomNumber());
			
			String pwd = p.getProperty("password");
			rp.setPassword(pwd);
			rp.setPasswordConfirm(pwd);
			
			rp.clickPrivacyPolicy();
			
			String[] invalidEmail = {randomString(), randomString()+"@", randomString()+"@gmail"};
 			
			for(String e : invalidEmail) {
			
				rp.setEmail(e);
				rp.clickContinue();
				
				if (rp.getConfirmMessage().equals("Your Account Has Been Created!")) {
					Assert.fail("test failed with one invalid email available!");
					break;
				}
				
				rp.clearEmail();
				
			}
				
			Assert.assertTrue(true);
		
		
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail();
			
		}
		
		logger.info("******* Finished TC_RF_0010_InvalidEmailRegistrationTest *******");

			
	}
	
}
