package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_WL_012_WishListPageHeadingURLTitleTest extends BaseClass {

	@Test(groups = { "master", "search", "wish list" })
	void wishlist_page_heading_title_url() {

		logger.info("******* Starting TC_WL_012_WishListPageHeadingURLTitleTest *******");

		try {

			HomePage hp = new HomePage();
			
			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			WishListPage wp = map.clickModifyWishLink();
			
			Thread.sleep(2000);

			Assert.assertTrue(wp.isPageHeadingDisplayed("wish"), "Incorrect page heading display!");
			Assert.assertTrue(wp.isPageTitleDisplayed("wish"), "Incorrect page title display!");
			Assert.assertTrue(wp.isPageURLDisplayed("wishlist"), "Incorrect page url display!");

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());

		}

		logger.info("******* Finished TC_WL_012_WishListPageHeadingURLTitleTest *******");

	}

}
