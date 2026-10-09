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

public class TC_WL_006_WishListPageHeaderNavigatingTest extends BaseClass{
	
	String searchInput = "iMac";
	int testProductIndex = 1; 
	
	@Test(groups = { "master", "wish list" })
	public void wish_list_page_navigating_test() {
		logger.info("***Starting TC_WL_006_WishListPageHeaderNavigatingTest ***");
		
		HomePage hp = new HomePage();
		
		hp.clickMyAccount();
		
		LoginPage lp = hp.clickLogin();
		
		MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

		WishListPage wp = map.clickWishListLnk();
		
		wp.clearWishList();
		
		SearchPage sp = wp.searchAProduct(searchInput);
		
		String testProductTitle = sp.getProductTitleByIndex(testProductIndex);
		
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		dp.clickAddToWishListBtn();
		
		Assert.assertTrue(sp.isWishListSuccessAlertDisplay(testProductTitle), "Failed to locate success message!");
		
		wp =  sp.clickAlertWishListLnk();
		
		Assert.assertTrue(wp.isPageHeadingDisplay(), "Failed to locate wish list page heading.");

		logger.info("***Finshed TC_WL_006_WishListPageHeaderNavigatingTest ***");
	}

}
