package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_002_SearchNonExistingProductTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_non_existing_product() {

		logger.info("******* Starting TC_SF_002_SearchNonExistingProductTest *******");
		
		try {
		
			String searchKeyword = "Fitbit";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			
			Assert.assertEquals(sp.isSearchProductExist(searchKeyword), false);
			Assert.assertEquals(sp.isResultMessageDiplayed(), true);
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_002_SearchNonExistingProductTest *******");
		
		
	}
	
}
