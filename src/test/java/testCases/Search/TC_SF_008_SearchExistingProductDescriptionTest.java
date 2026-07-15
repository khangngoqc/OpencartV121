package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_008_SearchExistingProductDescriptionTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_product_with_description_functionality() {

		logger.info("******* Starting TC_SF_008_SearchExistingProductDescriptionTest *******");
		
		try {
		
			String searchProductTitle = "iMac";
			String searchProductPartialDescription = "Leopard and iLife";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchProductPartialDescription);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			
			Assert.assertTrue(sp.isSearchProductExist(searchProductTitle), "Product having the given text in its description should be displayed in the search results"
					+ "");
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_008_SearchExistingProductDescriptionTest *******");
		
		
	}
	
}
