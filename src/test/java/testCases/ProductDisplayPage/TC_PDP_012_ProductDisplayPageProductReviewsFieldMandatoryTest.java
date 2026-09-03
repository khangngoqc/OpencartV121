package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_012_ProductDisplayPageProductReviewsFieldMandatoryTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_review_mandatory_fields() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_012_ProductDisplayPageProductReviewsFieldMandatoryTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.clickReviewsTab();
			Assert.assertTrue(dp.mandatoryFieldsMarked(), "Non marked mandatory field found!");
			
			//validate Your Name
			dp.clickReviewsTab();
			dp.writeAReview("", "this is a test review message for product " + searchInput, 3);
			Assert.assertTrue(dp.isCorrectAlertMsgDisplay("Name"), "Missing warning for message Your Name input!");
			dp.refreshPage();
	
			//validate Your Name
			dp.clickReviewsTab();
			dp.writeAReview("Test Your Name", "", 3);
			Assert.assertTrue(dp.isCorrectAlertMsgDisplay("Text"), "Missing warning for message Your Review input!");
			dp.refreshPage();
			
			//validate Your Name
			dp.clickReviewsTab();
			dp.writeAReview("Test Your Name", "this is a test review message for product " + searchInput, 0);
			Assert.assertTrue(dp.isCorrectAlertMsgDisplay("review rating"), "Missing warning for message Rating input!");
	
			
			logger.info("***Finished TC_PDP_012_ProductDisplayPageProductReviewsFieldMandatoryTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
