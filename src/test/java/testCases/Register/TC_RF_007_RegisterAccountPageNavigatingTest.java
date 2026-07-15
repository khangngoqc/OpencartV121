package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_007_RegisterAccountPageNavigatingTest extends BaseClass{

	@Test(groups= {"master", "register"})
	void verify_different_ways_of_navigating(){
		
		logger.info("***Starting TC_RF_007_RegisterAccountPageNavigatingTest ***");
		
		try {
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			hp.clickMyAccount();
			hp.clickLogin();
			
			//click the Continue button on LoginPage
			LoginPage lp = new LoginPage();
			lp.clickContine();
			
			//repeat step 3 and 4
			hp.clickMyAccount();
			hp.clickLogin();
			
			//click Register from the right column
			lp.clickRegisterBtnGrp();
			
			Assert.assertEquals(getDriver().getTitle(), "Register Account");
				
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}
		
		logger.info("***Finished TC_RF_007_RegisterAccountPageNavigatingTest ***");

		
	}
	
	
}
