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

public class TC_WL_014_WishListPageOneProductAddedStateTest extends BaseClass {
	
	String searchInput = "iMac";

	@Test(groups = { "master", "search", "wish list" })
	void wishlist_page_single_product_added_state() {

		logger.info("******* Starting TC_WL_014_WishListPageOneProductAddedStateTest *******");

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
			
			Assert.assertTrue(wp.isWishListedProductDisplayed(1, "41", searchInput, "Product 14", "Out Of Stock", "$100.00"), "Unexpected wishlisted product info");
			
			ProductDisplayPage dp = wp.clickProductImageByIndex(1);
			Assert.assertTrue(dp.isPageTitleDisplayed(searchInput), "Failed to locate title: " + searchInput);
			
			dp.backToPreviousPage();
			
			dp = wp.clickProductNameByIndex(1);
			Assert.assertTrue(dp.isPageTitleDisplayed(searchInput), "Failed to locate title: " + searchInput);
			
			dp.backToPreviousPage();
			map = wp.clickContinueBtn();
			Assert.assertTrue(dp.isPageTitleDisplayed("My Account"), "Failed to locate title: My Account");
			

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());

		}

		logger.info("******* Finished TC_WL_014_WishListPageOneProductAddedStateTest *******");

	}

}
