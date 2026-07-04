package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_006_SearchInputPlaceholderTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_search_input_placeholder() {

		logger.info("******* Starting TC_SF_006_SearchInputPlaceholderTest *******");
		
		try {
		
			String searchKeyword = "Mac";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			
			Assert.assertTrue(sp.searchTxtBoxPlaceholder().contains("Search"), "Proper placeholder text should be displayed");
			Assert.assertTrue(sp.searchCriteriaPlaceholder().contains("Keywords"), "Proper placeholder text should be displayed");
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_006_SearchInputPlaceholderTest *******");
		
		
	}
	
}
