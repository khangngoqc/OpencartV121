package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_005_ProductDisplayPageDefaultQuantityTest extends BaseClass {

	String searchInput = "iMac";
	

	@Test(groups = {"master", "product display"})
	public void validate_product_quantity_display() throws InterruptedException
	{
		try {
			logger.info("***Starting TC_PDP_005_ProductDisplayPageDefaultQuantityTest ***");
			
			HomePage hp = new HomePage();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			Assert.assertTrue(dp.isDefaultQuantityDisplay(), "Incorrect product default quantity display! | found: "  + dp.getQuantityValue());
			Assert.assertTrue(dp.isAddToCartByQuantityWork(3),
					"Incorrect added product quantity display! | found: " + dp.getCartTotalText());
			

			logger.info("***Finished TC_PDP_005_ProductDisplayPageDefaultQuantityTest ***");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		

	}

}
