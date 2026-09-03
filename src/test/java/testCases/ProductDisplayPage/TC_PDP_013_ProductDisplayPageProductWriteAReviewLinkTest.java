package testCases.ProductDisplayPage;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_013_ProductDisplayPageProductWriteAReviewLinkTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_write_a_review_link() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_013_ProductDisplayPageProductWriteAReviewLinkTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.clickWriteAReviewLink();
			assertTrue(dp.isReviewsTabActive(), "Review tab is not focused!");
			
			logger.info("***Finished TC_PDP_013_ProductDisplayPageProductWriteAReviewLinkTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
