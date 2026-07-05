package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_009_SearchExistingProductSelectingCategoryTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_product_with_selecting_category() {

		logger.info("******* Starting TC_SF_009_SearchExistingProductSelectingCategoryTest *******");
		
		try {
		
			String searchProductTitle = "iMac";
			String[] categories = {"Mac", "PC"};
			
			HomePage hp = new HomePage();
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			sp.inputSearchCriteria(searchProductTitle);
			
			//validate with valid category
			sp.selectCategory(categories[0]);
			sp.clickSearchBtn();
			Assert.assertTrue(sp.isSearchProductExist(searchProductTitle), "Product should be successfully displayed in the search results");
			
			//validate with invalid category
			sp.selectCategory(categories[1]);
			sp.clickSearchBtn();
			Assert.assertTrue(sp.isResultMessageDiplayed(), "Product with invalid category should not be displayed in the search results");
			
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_009_SearchExistingProductSelectingCategoryTest *******");
		
		
	}
	
}
