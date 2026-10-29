package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_WL_015_WishListPageRemovingProductTest extends BaseClass {
	
	String searchInput = "iMac";

	@Test(groups = { "master", "search", "wish list" })
	void wishlist_page_remove_product() {

		logger.info("******* Starting TC_WL_015_WishListPageRemovingProductTest *******");

		try {

			HomePage hp = new HomePage();
			
			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();
			
			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			WishListPage wp = map.clickModifyWishLink();

			wp.clearWishList();
			
			SearchPage sp = wp.searchAProduct(searchInput);
			
			sp.clickAddToWishList();
			
			wp = sp.clickAlertWishListLnk();
			
			Thread.sleep(2000);
			
			wp.removeProducByIndex(1);
			
			Thread.sleep(1000);
			
			Assert.assertTrue(wp.isModifySuccessAlertBannerDisplay(), "Failed to locate modify success alert banner");
			Assert.assertTrue(wp.isEmptyWishListTextDisplay(), "Failed to locate empty state message");
			

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());

		}

		logger.info("******* Finished TC_WL_015_WishListPageRemovingProductTest *******");

	}

}
