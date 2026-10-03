package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SubCategoryPage;
import testBase.BaseClass;

public class TC_ATC_006_AddToCartFromHomePageTest extends BaseClass {

	int testProductIndex = 1;
	
	@Test(groups = { "master", "add to cart" })
	public void validate_add_from_home_page() throws InterruptedException {
		try {
			logger.info("***Starting TC_ATC_006_AddToCartFromHomePageTest ***");

			HomePage hp = new HomePage();
			
			hp.clickAddToCartByIndex(testProductIndex);
			
			String addedProduct = hp.getProductTitleByIndex(testProductIndex);
			
			Assert.assertTrue(hp.isAddToCartSuccessAlertDisplay(addedProduct), "Failed to locate added to cart success message!");
			
			ShoppingCartPage scp = hp.clickAlertShoppingCartLnk();
			
			Assert.assertTrue(scp.isProductAdded(addedProduct), "Can not find added product!");
			
			logger.info("***Finished TC_ATC_006_AddToCartFromHomePageTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
