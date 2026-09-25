package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_033_ProductDisplayPageBulkPurchasePricesTest extends BaseClass {

	String searchInput = "Apple Cinema";
	float productBulkPurchsePrice10 = 107.6f;
	float productBulkPurchsePrice20 = 94.40f;
	float productBulkPurchsePrice30 = 81.20f;

	@Test(groups = {"master", "product display"})
	public void validate_product_bulk_purchase_price()
	{

		logger.info("***Starting TC_PDP_033_ProductDisplayPageBulkPurchasePricesTest.java ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		Assert.assertTrue(dp.isCorrectBulkPurchasePriceDisplay(10, productBulkPurchsePrice10), "Incorrect bulk purchase price display! | ");
		Assert.assertTrue(dp.isCorrectBulkPurchasePriceDisplay(20, productBulkPurchsePrice20), "Incorrect product original price display! | ");
		Assert.assertTrue(dp.isCorrectBulkPurchasePriceDisplay(30, productBulkPurchsePrice30), "Incorrect product original price display! | ");
		
		logger.info("***Finished TC_PDP_033_ProductDisplayPageBulkPurchasePricesTest ***");

	}

}
