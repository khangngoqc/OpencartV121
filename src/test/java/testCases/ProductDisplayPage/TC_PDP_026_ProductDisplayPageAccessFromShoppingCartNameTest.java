package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_PDP_026_ProductDisplayPageAccessFromShoppingCartNameTest extends BaseClass {

	String searchInput = "iMac";
	int testProductIndex = 1;

	@Test(groups = { "master", "product display" })
	public void validate_acccess_shopping_cart_name() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_026_ProductDisplayPageAccessFromShoppingCartNameTest ***");

			HomePage hp = new HomePage();

			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			SearchPage sp = hp.searchAProduct(searchInput);
			sp.clickAddToCart();
			
			ShoppingCartPage scp = sp.clickShoppingCartLnk();
			
			//Thread.sleep(2000);
			
			String addedProduct = scp.getProductNameByIndex(testProductIndex);
			
			ProductDisplayPage pdp = scp.clickProductNameByIndex(testProductIndex);
					
			Assert.assertTrue(pdp.isCorrectProductNameDisplay(addedProduct), "Failed to navigate to product display page!| ");
			
			logger.info("***Finished TC_PDP_026_ProductDisplayPageAccessFromShoppingCartNameTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
