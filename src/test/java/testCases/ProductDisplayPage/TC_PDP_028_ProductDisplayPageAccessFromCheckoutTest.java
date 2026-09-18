package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_PDP_028_ProductDisplayPageAccessFromCheckoutTest extends BaseClass {

	String searchInput = "HP LP3065";
	int testProductIndex = 2;

	@Test(groups = { "master", "product display" })
	public void validate_acccess_from_checkout_page() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_028_ProductDisplayPageAccessFromCheckoutTest ***");

			HomePage hp = new HomePage();
			
			hp.clickMyAccount();

			LoginPage lp = hp.clickLogin();

			MyAccountPage map = lp.loginAs(p.getProperty("email"), p.getProperty("password"));
			
			SearchPage sp = hp.searchAProduct(searchInput);
			
			sp.clearCart();
		
			String searchProduct = sp.getFirstSearchProductTitle();
			
			ProductDisplayPage pdp = sp.clickFirstProductTitle();
			pdp.addProductToCartByQuantity(1);
			
			CheckoutPage cp = pdp.clickCheckoutLnk();
			
			Thread.sleep(1000);
			
			cp.skipToStep(6); //go to confirm order section
			
			cp.clickProductName();
			
			Assert.assertTrue(pdp.isCorrectProductNameDisplay(searchProduct), "Failed to navigate to product display page!| ");
			
			
			logger.info("***Finished TC_PDP_028_ProductDisplayPageAccessFromCheckoutTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
