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

public class TC_WL_010_WishListPageFooterOptionNavigatingTest extends BaseClass {

	@Test(groups = { "master", "wish list" })
	public void wish_list_page_footer_option_navigating_test() {
		logger.info("***Starting TC_WL_010_WishListPageFooterOptionNavigatingTest ***");

		HomePage hp = new HomePage();

		hp.clickMyAccount();

		LoginPage lp = hp.clickLogin();

		MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

		WishListPage wp = map.clickFooterWishListLnk();

		Assert.assertTrue(wp.isPageHeadingDisplay(), "Failed to locate wish list page heading.");

		logger.info("***Finshed TC_WL_010_WishListPageFooterOptionNavigatingTest ***");
	}

}
