package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_018_ProductDisplayPageReviewRequiredCharTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_review_mandatory_fields() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_018_ProductDisplayPageReviewRequiredCharTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
	
			//validate Your Review
			dp.clickReviewsTab();
			dp.writeAReview("Test Your Name", "short review", 3);
			Assert.assertTrue(dp.isCorrectAlertMsgDisplay("25 and 1000"), "Missing warning for message Your Review input!");
			dp.refreshPage();
			
			logger.info("***Finished TC_PDP_018_ProductDisplayPageReviewRequiredCharTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
