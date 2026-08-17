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
	int zeroInput = 0;
	String[] error = { "Quantity should be a positive number", "Quantity cannot be zero, null or negative" };

	@Test(groups = { "master", "product display" })
	public void validate_product_quantity_display() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_006_ProductDisplayPageNegativeQuantityTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();

			//validate negative value
			dp.addProductToCartByQuantity(negInput);

			boolean errorWarningFound = false;

			for (String string : error) {
				if (dp.findInDOM(string)) {
					errorWarningFound = true;
				}
			}

			Assert.assertEquals(errorWarningFound, true, "Missing warning for negative quantity value! | ");
			
			
			//validate 0 value
			dp.addProductToCartByQuantity(zeroInput);

			boolean errorWarningFound2 = false;

			for (String string : error) {
				if (dp.findInDOM(string)) {
					errorWarningFound = true;
				}
			}

			Assert.assertEquals(errorWarningFound2, true, "Missing warning for quantity as 0 value! | ");

			//validate null value
			dp.addProductToCartByQuantity(null);

			boolean errorWarningFound3 = false;

			for (String string : error) {
				if (dp.findInDOM(string)) {
					errorWarningFound = true;
				}
			}

			Assert.assertEquals(errorWarningFound3, true, "Missing warning for quantity as null! | ");
			
			
			logger.info("***Finished TC_PDP_006_ProductDisplayPageNegativeQuantityTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
