package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SiteMapPage;
import testBase.BaseClass;

public class TC_SF_017_SearchPageSiteMapNavigationTest extends BaseClass {

	@Test(groups = {"master", "search"})
	void access_search_page_from_sitemap() {

		logger.info("******* Starting TC_SF_017_SearchPageSiteMapNavigationTest *******");
		
		try {
		
			HomePage hp = new HomePage();
			SiteMapPage smp = hp.clickSiteMapLink();
			SearchPage sp = smp.clickSearchPageLink();

			Assert.assertTrue(sp.getPageTitle().contains("Search"), "Faield to navigate to Seach page through Site Map page");


		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_017_SearchPageSiteMapNavigationTest *******");
		
		
	}
	
}
