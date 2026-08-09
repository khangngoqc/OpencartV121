package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_001_ProductDisplayPageThumbnailTest extends BaseClass {
	
	String searchInput = "iMac";

	
	@Test(groups = {"master", "product display"})
	public void validate_thumbnail() {
		
		logger.info("***Starting TC_PDP_001_ProductDisplayPageThumbnailTest ***");
		
		try {
			
			HomePage hp = new HomePage();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			
			
		} catch (Exception e) {
		
			Assert.fail(e.getMessage());
		}

		logger.info("***Finished TC_PDP_001_ProductDisplayPageThumbnailTest ***");

	}

}
