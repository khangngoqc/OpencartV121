package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_007_ProductDisplayPageMinimumQuantityTest extends BaseClass {

	String searchInput = "Apple Cinema 30\"";
	

	@Test(groups = {"master", "product display"})
	public void validate_product_minimum_quantity_display() throws InterruptedException
	{
		try {
			logger.info("***Starting TC_PDP_007_ProductDisplayPageMinimumQuantityTest ***");
			
			HomePage hp = new HomePage();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			Assert.assertTrue(dp.isMinimumQuantityDisplay(), "Incorrect product default quantity display! | found: "  + dp.getQuantityValue());
			

			logger.info("***Finished TC_PDP_007_ProductDisplayPageMinimumQuantityTest ***");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		

	}

}
