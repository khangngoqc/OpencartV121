package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_001_SearchExistingProductTest extends BaseClass {

	@Test(groups = {"master", "sanity"})
	void validate_search_existing_product() {
		
		HomePage hp = new HomePage(driver);
		hp.setSearchInput("iMac");
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		
		Assert.assertTrue(sp.isSearchProductExist());
		
		
	}
	
}
