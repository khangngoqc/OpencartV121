package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_007_RegisterAccountPageNavigatingTest extends BaseClass{

	@Test(groups= {"master", "register"})
	void verify_different_ways_of_navigating(){
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			hp.clickMyAccount();
			hp.clickLogin();
			
			//click the Continue button on LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.clickContine();
			
			//repeat step 3 and 4
			hp.clickMyAccount();
			hp.clickLogin();
			
			//click Register from the right column
			lp.clickRegister();
			
			Assert.assertEquals(driver.getTitle(), "Register Account");
				
		} catch (Exception e) {
			Assert.fail();
			logger.debug(e.getMessage());
		
		}
		
		
	}
	
	
}
