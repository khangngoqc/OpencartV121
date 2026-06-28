package testCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_013_FieldsPlaceholderTest extends BaseClass{

	@Test(groups= {"master", "registration"})
	void validate_fields_placeholder(){
		
		logger.info("******* Starting TC_RF_013_FieldsPlaceholderTest *******");

		try {

			//go to Register page
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage rp = new AccountRegistrationPage();
			
			ArrayList<String> placeholders = new ArrayList<String>();
		
			placeholders.add(rp.getPlaceholderValue(rp.getTxtFirstName()));
			placeholders.add(rp.getPlaceholderValue(rp.getTxtLastName()));
			placeholders.add(rp.getPlaceholderValue(rp.getTxtEmail()));
			placeholders.add(rp.getPlaceholderValue(rp.getTxtTelephone()));
			placeholders.add(rp.getPlaceholderValue(rp.getTxtPassword()));
			placeholders.add(rp.getPlaceholderValue(rp.getTxtPasswordConfirm()));

			
			for(String p : placeholders) {
				if (p.equals(null)) {
					Assert.fail();
					break;
				}
			}
			
			Assert.assertTrue(true);
			
			
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();
		}
		
		logger.info("******* Finished TC_RF_013_FieldsPlaceholderTest *******");

	}
	
}
