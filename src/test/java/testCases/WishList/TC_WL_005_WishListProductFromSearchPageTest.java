package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.SubCategoryPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_WL_005_WishListProductFromSearchPageTest extends BaseClass{
	
	String searchInput = "iMac";
	int testProductIndex = 1; 
	
	@Test(groups = { "master", "wish list" })
	public void wish_list_product_from_search_page() {
		logger.info("***Starting TC_WL_005_WishListProductFromSearchPageTest ***");
		
		HomePage hp = new HomePage();
		
		hp.clickMyAccount();
		
		LoginPage lp = hp.clickLogin();
		
		MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

		WishListPage wp = map.clickWishListLnk();
		
		wp.clearWishList();
		
		SearchPage sp = wp.searchAProduct(searchInput);
		
		String testProductTitle = sp.getProductTitleByIndex(testProductIndex);
		
		sp.clickSearchWishListBtnByIndex(testProductIndex);

		Assert.assertTrue(sp.isWishListSuccessAlertDisplay(testProductTitle), "Failed to locate success message!");
		
		wp =  sp.clickAlertWishListLnk();
		
		Assert.assertTrue(wp.isProductAdded(testProductTitle), "Failed to locate wish listed product on page.");

		logger.info("***Finshed TC_WL_005_WishListProductFromSearchPageTest ***");
	}

}
