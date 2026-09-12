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

public class TC_PDP_023_ProductDisplayPageAccessFromWishListImageTest extends BaseClass {

	String searchInput = "iMac";
	int testProductIndex = 1;

	@Test(groups = { "master", "product display" })
	public void validate_acccess_from_wish_list_() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_023_ProductDisplayPageAccessFromWishListImageTest ***");

			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			SearchPage sp = hp.searchAProduct(searchInput);
			sp.clickAddToWishList();
			
			WishListPage wlp = sp.clickWishListLnk();
			
			
			String wishListProduct = wlp.getProductNameByIndex(testProductIndex);
			
			ProductDisplayPage pdp = wlp.clickProductImageByIndex(testProductIndex);
					
			Assert.assertTrue(pdp.isCorrectProductNameDisplay(wishListProduct), "Failed to navigate to related product display page!| ");
			
			logger.info("***Finished TC_PDP_023_ProductDisplayPageAccessFromWishListImageTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
