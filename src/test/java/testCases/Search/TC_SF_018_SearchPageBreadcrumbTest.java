package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SiteMapPage;
import testBase.BaseClass;

public class TC_SF_018_SearchPageBreadcrumbTest extends BaseClass {

	@Test(groups = {"master", "search"})
	void search_page_breadcrumb() {

		logger.info("******* Starting TC_SF_018_SearchPageBreadcrumbTest *******");
		
		try {
		
			HomePage hp = new HomePage();
			hp.setSearchInput("Mac");
			SearchPage sp = hp.clickSearch();

			Assert.assertTrue(sp.isBreadcrumbWork(), "Breadcrumb test failed!");


		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_017_SearchPageSiteMapNavigationTest *******");
		
		
	}
	
}
