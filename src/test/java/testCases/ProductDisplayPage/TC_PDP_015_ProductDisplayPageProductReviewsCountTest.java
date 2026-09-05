package testCases.ProductDisplayPage;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_015_ProductDisplayPageProductReviewsCountTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_review_count() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_015_ProductDisplayPageProductReviewsCountTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.clickReviewsTab();
			
			assertTrue(dp.isReviewCountDisplay(), "Reviews count is not presented on page!");
			
			logger.info("***Finished TC_PDP_015_ProductDisplayPageProductReviewsCountTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
