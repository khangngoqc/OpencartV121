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

public class TC_PDP_019_ProductDisplayPageWishListTest extends BaseClass {

	String searchInput = "iMac";

	@Test(groups = { "master", "product display" })
	public void validate_review_mandatory_fields() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_019_ProductDisplayPageWishListTest ***");

			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			SearchPage sp = map.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.clickAddToWishListBtn();
			
			Assert.assertTrue(dp.isWishListSuccessAlertDisplay(), "Unexpected alert message! | ");
			
			WishListPage wlp = dp.clickAlertWishListLnk();

			Assert.assertTrue(wlp.isPageHeadingDisplay(), "Unexpected page heading! | ");
			
			logger.info("***Finished TC_PDP_019_ProductDisplayPageWishListTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
