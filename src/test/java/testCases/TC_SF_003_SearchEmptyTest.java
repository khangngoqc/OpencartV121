package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_003_SearchEmptyTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void empty_search() {

		logger.info("******* Starting TC_SF_003_SearchEmptyTest *******");
		
		try {
		
			HomePage hp = new HomePage();
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			Assert.assertEquals(sp.isResultMessageDiplayed(), true);
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_003_SearchEmptyTest *******");
		
		
	}
	
}
