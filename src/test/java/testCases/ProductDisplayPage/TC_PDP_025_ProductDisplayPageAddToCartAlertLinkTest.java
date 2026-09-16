package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_PDP_025_ProductDisplayPageAddToCartAlertLinkTest extends BaseClass {

	String searchInput = "iMac";
	int testProductIndex = 2;

	@Test(groups = { "master", "product display" })
	public void validate_acccess_from_add_to_cart_link() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_025_ProductDisplayPageAddToCartAlertLinkTest ***");

			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			SearchPage sp = hp.searchAProduct(searchInput);
			String searchProduct = sp.getFirstSearchProductTitle();
			sp.clickAddToCart();
			ProductDisplayPage dp = sp.clickAlertProductLink();
			
			Assert.assertTrue(dp.isCorrectProductNameDisplay(searchProduct), "Failed to navigate to product display page!| ");
			
			
			logger.info("***Finished TC_PDP_025_ProductDisplayPageAddToCartAlertLinkTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
