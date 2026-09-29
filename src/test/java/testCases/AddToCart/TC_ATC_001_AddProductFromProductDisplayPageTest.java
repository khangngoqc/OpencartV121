package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;


public class TC_ATC_001_AddProductFromProductDisplayPageTest extends BaseClass{
	
	String searchInput = "iMac";
	
	@Test(groups = { "master", "add to cart" })
	public void validate_adding_product_from_display_page() throws InterruptedException {
		
		logger.info("***Starting TC_ATC_001_AddProductFromProductDisplayPageTest ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		dp.addProductToCartByQuantity(1);
		
		Assert.assertTrue(dp.isAddToCartSuccessAlertDisplay(), "Failed to verify Add to Cart success alert!");
		
		Thread.sleep(1000);
		
		ShoppingCartPage scp = dp.clickAlertShoppingCartLnk();
		
		Assert.assertTrue(scp.isProductAdded(searchInput), "Can not find added product!");
		
		logger.info("***Finshed TC_ATC_001_AddProductFromProductDisplayPageTest ***");
	}
}
