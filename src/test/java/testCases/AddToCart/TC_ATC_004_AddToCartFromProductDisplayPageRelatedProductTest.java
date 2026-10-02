package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_ATC_004_AddToCartFromProductDisplayPageRelatedProductTest extends BaseClass {

	String searchInput = "Apple Cinema 30";
	int testProductIndex = 1;

	@Test(groups = { "master", "add to cart" })
	public void validate_add_product_form_display_page_related_product() throws InterruptedException {
		try {
			logger.info("***Starting TC_ATC_004_AddToCartFromProductDisplayPageRelatedProductTest ***");

			HomePage hp = new HomePage();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			String addedRelatedProduct = dp.getFirstProductTitle();
			
			dp.clickFirstRelatedProductAddToCartBtn();
			
			Assert.assertTrue(dp.isAddToCartSuccessAlertDisplay(addedRelatedProduct), "Failed to locate added to cart success message!");
			
			ShoppingCartPage scp = sp.clickShoppingCartLnk();
			
			Assert.assertTrue(scp.isProductAdded(addedRelatedProduct), "Can not find added product!");
			
			logger.info("***Finished TC_ATC_004_AddToCartFromProductDisplayPageRelatedProductTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
