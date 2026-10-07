package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_WL_003_WishListFeaturedProductFromHomePageTest extends BaseClass{
	
	String searchInput = "iMac";
	int testProductIndex = 1; 
	
	@Test(groups = { "master", "wish list" })
	public void adding_featured_product_from_home_page() {
		logger.info("***Starting TC_WL_003_WishListFeaturedProductFromHomePageTest ***");
		
		HomePage hp = new HomePage();
		
		hp.clickMyAccount();  
		
		LoginPage lp = hp.clickLogin();
		
		MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

		HomePage hp2 = map.clickStoreLogo();

		hp2.clickFeaturedWishListBtnByIndex(testProductIndex);
		
		String testProductTitle = hp2.getProductTitleByIndex(testProductIndex);

		Assert.assertTrue(hp2.isWishListSuccessAlertDisplay(testProductTitle), "Failed to locate success message!");
		
		WishListPage wp = hp2.clickAlertWishListLnk();
		
		Assert.assertTrue(wp.isProductAdded(testProductTitle), "Failed to locate wish listed product on page.");

		logger.info("***Finshed TC_WL_003_WishListFeaturedProductFromHomePageTest ***");
	}

}
