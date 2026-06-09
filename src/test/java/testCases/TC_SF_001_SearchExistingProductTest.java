package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_001_SearchExistingProductTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_existing_product() {

		logger.info("******* Starting TC_SF_001_SearchExistingProductTest *******");
		
		try {
		
			HomePage hp = new HomePage();
			hp.setSearchInput("iMac");
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			
			Assert.assertTrue(sp.isSearchProductExist());
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail();
		
		}
		
		logger.info("******* Finished TC_SF_001_SearchExistingProductTest *******");
		
		
	}
	
}
