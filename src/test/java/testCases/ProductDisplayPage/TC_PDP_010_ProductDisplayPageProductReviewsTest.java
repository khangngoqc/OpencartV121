package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_010_ProductDisplayPageProductReviewsTest extends BaseClass {

	String searchInput = "Apple Cinema 30\"";
	String testName = "My review name";
	String testReview = "This is my test review of " + searchInput;
	int ratingPoint = 3;
	
	@Test(groups = { "master", "product display" })
	public void validate_product_specification() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_010_ProductDisplayPageProductReviewsTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.clickReviewsTab();
			dp.inputYourName(testName);
			dp.inputYourReview(testReview);
			dp.selectRating(ratingPoint);
			dp.clickContinueBtn();
			
			Assert.assertTrue(dp.isSuccessMsgDisplay(), "Failed to write a review!");
			
			
			logger.info("***Finished TC_PDP_010_ProductDisplayPageProductReviewsTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
