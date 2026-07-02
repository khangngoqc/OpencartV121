package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_004_SearchAfterLoginTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void search_after_login() {

		logger.info("******* Starting TC_SF_003_SearchEmptyTest *******");
		
		try {
		
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage();
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			
			String searchKeyword = "iMac";
			
			hp.setSearchInput(searchKeyword);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			Assert.assertEquals(sp.isSearchProductExist(searchKeyword), true);
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_003_SearchEmptyTest *******");
		
		
	}
	
}
