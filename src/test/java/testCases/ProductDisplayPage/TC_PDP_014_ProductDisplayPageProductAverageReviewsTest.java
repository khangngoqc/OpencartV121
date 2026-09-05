package testCases.ProductDisplayPage;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_014_ProductDisplayPageProductAverageReviewsTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_average_review() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_014_ProductDisplayPageProductAverageReviewsTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			assertTrue(dp.isAverageStarDisplay(), "Average review stars is presented on page!");
			assertTrue(dp.isReviewsNumberDisplay(), "Number of reviews is not presented on page!");
			
			logger.info("***Finished TC_PDP_014_ProductDisplayPageProductAverageReviewsTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
