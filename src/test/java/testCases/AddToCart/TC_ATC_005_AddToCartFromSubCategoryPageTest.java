package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SubCategoryPage;
import testBase.BaseClass;

public class TC_ATC_005_AddToCartFromSubCategoryPageTest extends BaseClass {

	int testProductIndex = 1;
	
	@Test(groups = { "master", "add to cart" })
	public void validate_add_from_subcategory_page() throws InterruptedException {
		try {
			logger.info("***Starting TC_ATC_005_AddToCartFromSubCategoryPageTest ***");

			HomePage hp = new HomePage();
			
			hp.hoverNavBarDesktop();
			
			SubCategoryPage sb = hp.clickMacSubMenu();
			
			String addedProduct = sb.getProductTitleByIndex(testProductIndex);
			
			sb.clickAddToCartByIndex(testProductIndex);
			
			Assert.assertTrue(sb.isAddToCartSuccessAlertDisplay(addedProduct), "Failed to locate added to cart success message!");
			
			ShoppingCartPage scp = sb.clickShoppingCartLnk();
			
			Assert.assertTrue(scp.isProductAdded(addedProduct), "Can not find added product!");
			
			logger.info("***Finished TC_ATC_005_AddToCartFromSubCategoryPageTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
