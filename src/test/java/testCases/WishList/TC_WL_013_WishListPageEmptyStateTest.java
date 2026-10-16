package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_WL_013_WishListPageEmptyStateTest extends BaseClass {

	@Test(groups = { "master", "search", "wish list" })
	void wishlist_page_empty_state() {

		logger.info("******* Starting TC_WL_013_WishListPageEmptyStateTest *******");

		try {

			HomePage hp = new HomePage();
			
			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			WishListPage wp = map.clickModifyWishLink();

			wp.clearWishList();
			
			Thread.sleep(2000);
			
			Assert.assertTrue(wp.isEmptyWishListTextDisplay(), "Failed to locate empty state text!");
			
			map = wp.clickContinueBtn();
			
			Assert.assertTrue(map.isMyAccountHeadingExist(), "Failed to locate My Account Page heading!");
			
			

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());

		}

		logger.info("******* Finished TC_WL_013_WishListPageEmptyStateTest *******");

	}

}
