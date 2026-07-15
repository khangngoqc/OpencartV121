package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_005_SearchMultipleExistingProductTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_multiple_existing_product() {

		logger.info("******* Starting TC_SF_005_SearchMultipleExistingProductTest *******");
		
		try {
		
			String searchKeyword = "Mac";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			
			//
			Assert.assertTrue(sp.searchProductCount()>1, "More than one products should be displayed in the search results page");
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_005_SearchMultipleExistingProductTest *******");
		
		
	}
	
}
