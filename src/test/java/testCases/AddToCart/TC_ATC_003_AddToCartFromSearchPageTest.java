package testCases.AddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_ATC_003_AddToCartFromSearchPageTest extends BaseClass {

	String searchInput = "iMac";
	int testProductIndex = 1;

	@Test(groups = { "master", "add to cart" })
	public void validate_acccess_from_search_page() throws InterruptedException {
		try {
			logger.info("***Starting TC_ATC_003_AddToCartFromSearchPageTest ***");

			HomePage hp = new HomePage();
	
			SearchPage sp = hp.searchAProduct(searchInput);
			sp.clickAddToCart();
	
			Assert.assertTrue(sp.isAddToCartSuccessAlertDisplay(searchInput), "Failed to locate success message!");
			
			sp.clickCartBtn();
			
			ShoppingCartPage scp = sp.clickViewCartLnk();
			
			Assert.assertTrue(scp.isProductAdded(searchInput), "Can not find added product!");
			
			logger.info("***Finished TC_ATC_003_AddToCartFromSearchPageTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
