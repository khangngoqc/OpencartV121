package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_006_ProductDisplayPageNegativeQuantityTest extends BaseClass {

	String searchInput = "iMac";
	int negInput = -3;
	String[] error = {"Quantity should be a positive number", "Quantity cannot be zero, null or negative"};
	
	@Test(groups = {"master", "product display"})
	public void validate_product_quantity_display() throws InterruptedException
	{
		try {
			logger.info("***Starting TC_PDP_006_ProductDisplayPageNegativeQuantityTest ***");
			
			HomePage hp = new HomePage();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.addProductToCartByQuantity(negInput);
			
			boolean errorWarningFound = false;
			
			for (String string : error) {
				if(dp.findInDOM(string)) {
					errorWarningFound = true;
				}
			}
			
			Assert.assertEquals(errorWarningFound, true, "Missing warning for negative quantity value! | ");

			logger.info("***Finished TC_PDP_006_ProductDisplayPageNegativeQuantityTest ***");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		

	}

}
