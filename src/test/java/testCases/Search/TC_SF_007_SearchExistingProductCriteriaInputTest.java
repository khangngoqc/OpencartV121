package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_007_SearchExistingProductCriteriaInputTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_criteria_functionality() {

		logger.info("******* Starting TC_SF_007_SearchExistingProductCriteriaInputTest *******");
		
		try {
		
			String searchKeyword = "Mac";
			
			HomePage hp = new HomePage();
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			sp.inputSearchCriteria(searchKeyword);
			sp.clickSearchBtn();
			
			Assert.assertTrue(sp.isSearchProductExist(searchKeyword), "Searched product should be displayed in the search results");
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_007_SearchExistingProductCriteriaInputTest *******");
		
		
	}
	
}
