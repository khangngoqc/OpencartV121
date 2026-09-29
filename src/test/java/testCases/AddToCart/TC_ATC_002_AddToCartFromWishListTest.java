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

public class TC_ATC_002_AddToCartFromWishListTest extends BaseClass {

	String searchInput = "iMac";
	int testProductIndex = 1;

	@Test(groups = { "master", "add to cart" })
	public void validate_acccess_from_wish_list() throws InterruptedException {
		try {
			logger.info("***Starting TC_ATC_002_AddToCartFromWishListTest ***");

			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			map.clearCart();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			sp.clickAddToWishList();
			
			WishListPage wlp = sp.clickWishListLnk();
			
			String wishListProduct = wlp.getProductNameByIndex(testProductIndex);
			
			wlp.clickAddToCartOf(wishListProduct);
					
			Assert.assertTrue(wlp.isAddToCartSuccessAlertDisplay(wishListProduct), "Failed to locate success message!| ");
			
			ShoppingCartPage scp = wlp.clickAlertShoppingCartLnk();
			
			Assert.assertTrue(scp.isProductAdded(searchInput), "Can not find added product!");
			
			logger.info("***Finished TC_ATC_002_AddToCartFromWishListTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
