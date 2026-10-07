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

public class TC_WL_002_WishListRelatedProductFromDisplayPageTest extends BaseClass{
	
	String searchInput = "iMac";
	int testProductIndex = 1; 
	
	@Test(groups = { "master", "wish list" })
	public void adding_related_product_from_display_page() {
		logger.info("***Starting TC_WL_002_WishListRelatedProductFromDisplayPageTest ***");
		
		HomePage hp = new HomePage();
		
		hp.clickMyAccount();  
		
		LoginPage lp = hp.clickLogin();
		
		MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
		
		SearchPage sp = map.searchAProduct(searchInput);
		
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		String testProductTitle = dp.getRelatedProductTitleByIndex(testProductIndex);
		
		dp.clickRelatedWishListBtnByIndex(testProductIndex);
		
		Assert.assertTrue(dp.isWishListSuccessAlertDisplay(testProductTitle), "Failed to locate success message!");
		
		WishListPage wp = dp.clickAlertWishListLnk();
		
		Assert.assertTrue(wp.isProductAdded(testProductTitle), "Failed to locate wish listed product on page.");
		
		
		
		logger.info("***Finshed TC_WL_002_WishListRelatedProductFromDisplayPageTest ***");
	}

}
