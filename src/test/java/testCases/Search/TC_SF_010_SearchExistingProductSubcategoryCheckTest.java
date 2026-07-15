package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_010_SearchExistingProductSubcategoryCheckTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_product_with_selecting_subcategory() {

		logger.info("******* Starting TC_SF_010_SearchExistingProductSelectingSubcategoryTest *******");
		
		try {
		
			String searchProductTitle = "iMac";
			String category = "Desktops";
			
			HomePage hp = new HomePage();
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			sp.inputSearchCriteria(searchProductTitle);
			
			//validate with valid category
			sp.selectCategory(category);
			sp.clickSearchBtn();
			Assert.assertTrue(sp.isResultMessageDiplayed(), "Product with invalid category should not be displayed in the search results");
			
			//validate with invalid category
			sp.checkSubCategoryCheckBox();
			sp.clickSearchBtn();
			Assert.assertTrue(sp.isSearchProductExist(searchProductTitle), "Searched product should be successfully displayed in the search results");
			
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_010_SearchExistingProductSelectingSubcategoryTest *******");
		
		
	}
	
}
