package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.SiteMapPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_WL_011_WishListPageBreadcrumbTest extends BaseClass {

	@Test(groups = {"master", "wish list"})
	void wish_list_page_breadcrumb() {

		logger.info("******* Starting TC_WL_011_WishListPageBreadcrumbTest *******");
		
		try {
		
			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();
			
			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

			WishListPage wp = map.clickFooterWishListLnk();

			Assert.assertTrue(wp.isBreadcrumbWork(), "Breadcrumb test failed!");


		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_WL_011_WishListPageBreadcrumbTest *******");
		
		
	}
	
}
