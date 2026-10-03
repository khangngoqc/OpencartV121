package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_ATC_007_AddToCartFromProductComparisonPageTest extends BaseClass {

	int testProductIndex = 1;
	
	@Test(groups = { "master", "add to cart" })
	public void validate_add_from_home_page() throws InterruptedException {
		try {
			logger.info("***Starting TC_ATC_007_AddToCartFromProductComparisonPageTest ***");

			HomePage hp = new HomePage();
			
			hp.clickCompareProductByIndex(testProductIndex);
			
			ProductComparePage pcp = hp.clickAlertProductComparisonProductLink();
			
			pcp.clickAddToCartByIndex(testProductIndex);
			
			String addedProduct = pcp.getProductTitleByIndex(testProductIndex);
			
			Assert.assertTrue(pcp.isAddToCartSuccessAlertDisplay(addedProduct), "Failed to locate added to cart success message!");
			
			ShoppingCartPage scp = pcp.clickAlertShoppingCartLnk();
			
			Assert.assertTrue(scp.isProductAdded(addedProduct), "Can not find added product!");
			
			logger.info("***Finished TC_ATC_007_AddToCartFromProductComparisonPageTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
