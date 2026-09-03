package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_011_ProductDisplayPageProductNonReviewsTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_non_reivew_available_text() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_011_ProductDisplayPageProductNonReviewsTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			dp.clickReviewsTab();
			
			Assert.assertTrue(dp.isNonReviewTextDisplay(), "Cannot find expected message!");
			
			
			logger.info("***Finished TC_PDP_011_ProductDisplayPageProductNonReviewsTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
