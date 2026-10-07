package testCases.WishList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SubCategoryPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_WL_004_WishListProductFromSubCategoryPageTest extends BaseClass{
	
	String searchInput = "iMac";
	int testProductIndex = 1; 
	
	@Test(groups = { "master", "wish list" })
	public void wish_list_product_from_category_page() {
		logger.info("***Starting TC_WL_004_WishListProductFromSubCategoryPageTest ***");
		
		HomePage hp = new HomePage();
		
		hp.clickMyAccount();
		
		LoginPage lp = hp.clickLogin();
		
		MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));

		map.hoverNavBarDesktop();
		
		DesktopsPage dp = map.clickShowAllDesktopFromNavBarDesktopMenu();
		
		SubCategoryPage  scp = dp.clickSideOptionMac();
		
		String testProductTitle = scp.getProductTitleByIndex(testProductIndex);
		
		scp.clickWishListBtnByIndex(testProductIndex);

		Assert.assertTrue(scp.isWishListSuccessAlertDisplay(testProductTitle), "Failed to locate success message!");
		
		WishListPage wp = scp.clickAlertWishListLnk();
		
		Assert.assertTrue(wp.isProductAdded(testProductTitle), "Failed to locate wish listed product on page.");

		logger.info("***Finshed TC_WL_004_WishListProductFromSubCategoryPageTest ***");
	}

}
