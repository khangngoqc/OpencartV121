package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_016_SearchComponentVisibilityTest extends BaseClass {

	String[] pagesToTest = {"/index.php?route=account/login", "/index.php?route=product/search","/index.php?route=account/register"};

	@Test(groups = {"master", "search"})
	void search_component_visibility() {

		logger.info("******* Starting TC_SF_016_SearchComponentVisibilityTest *******");
		
		try {
		
			BasePage bp = new BasePage();

			Assert.assertTrue(bp.isSearchComponentDisplay(), "The search component is not available homepage.");

			for(String page : pagesToTest){
				getDriver().get(p.getProperty("appURL")+ page);
				Assert.assertTrue(bp.isSearchComponentDisplay(), "The search component is not available " + page +"page.");
			}


		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_016_SearchComponentVisibilityTest *******");
		
		
	}
	
}
