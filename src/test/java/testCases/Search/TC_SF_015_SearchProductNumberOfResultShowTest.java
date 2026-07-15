package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_015_SearchProductNumberOfResultShowTest extends BaseClass {

	int[] options = {20, 25, 50, 75, 100};

	@Test(groups = {"master", "search"})
	void number_of_search_result_show() {

		logger.info("******* Starting TC_SF_015_SearchProductNumberOfResultShowTest *******");
		
		try {
		
			String searchProductTitle = "Mac";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchProductTitle);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			Thread.sleep(2000);

			for(int op : options){
				Assert.assertTrue(sp.isNumberOfResultsShowWork(op), "The Show dropdown does not work at option " + op);
			}


		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_015_SearchProductNumberOfResultShowTest *******");
		
		
	}
	
}
