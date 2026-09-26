package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_PDP_030_ProductDisplayPageAccessFromCartProductImageTest extends BaseClass {

	String searchInput = "iMac";
	int testProductIndex = 1;

	@Test(groups = { "master", "product display" })
	public void validate_acccess_from_cart_image() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_030_ProductDisplayPageAccessFromCartProductImageTest ***");

			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

			map.clearCart();

			SearchPage sp = map.searchAProduct(searchInput);

			String searchProduct = sp.getFirstSearchProductTitle();

			sp.clickAddToCart();
			
			Thread.sleep(1000);

			sp.clickCartBtn();

			Thread.sleep(1000);
			
			ProductDisplayPage pdp = sp.clickCartProductImageByIndex(testProductIndex);

			Thread.sleep(1000);

			Assert.assertTrue(pdp.isCorrectProductNameDisplay(searchProduct),
					"Failed to navigate to product display page!| ");

			logger.info("***Finished TC_PDP_030_ProductDisplayPageAccessFromCartProductImageTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
