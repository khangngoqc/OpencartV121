package testCases.Search;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SiteMapPage;
import testBase.BaseClass;

import java.util.List;

public class TC_SF_016_SearchComponentVisibilityTest extends BaseClass {

	@Test(groups = {"master", "search"})
	void search_component_visibility() {

		logger.info("******* Starting TC_SF_016_SearchComponentVisibilityTest *******");
		
		try {
			BasePage bp = new BasePage();
			HomePage hp = new HomePage();
			SiteMapPage smp = hp.clickSiteMapLink();

			//Assert.assertTrue(bp.isSearchComponentDisplay(), "The search component is not available homepage.");

			List<WebElement> pagesToTest = smp.getSiteMapLinks();

			for(WebElement page : pagesToTest){
				smp.click(page);
				Assert.assertTrue(bp.isSearchComponentDisplay(), "The search component is not available " + page +"page.");
				bp.backToPreviousPage();
			}


		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_016_SearchComponentVisibilityTest *******");
		
		
	}
	
}
