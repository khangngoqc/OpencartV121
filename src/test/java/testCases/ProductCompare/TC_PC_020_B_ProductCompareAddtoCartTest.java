package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_020_B_ProductCompareAddtoCartTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_add_two_product() {

		String searchKeyword = "iMac";
		String searchKeyword2 = "iPhone";
		String searchKeyword3 = "Macbook Air";
		String searchKeyword4 = "Macbook";

		logger.info("***Starting TC_PC_020_B_ProductCompareAddtoCartTest ***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);

			sp.clickCompareThisProductBtn();

			Thread.sleep(500);
			sp.setSearchInput(searchKeyword2);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();
			
			Thread.sleep(500);

			sp.setSearchInput(searchKeyword3);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();
			
			Thread.sleep(500);

			sp.setSearchInput(searchKeyword4);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();
			
			Thread.sleep(500);


			ProductComparePage cp = sp.clickProductCompareLink();
		
			cp.addToCartAllProducts();

			Assert.assertTrue(cp.allProductsAddedToCart(), "Failed to add multiple products to cart!");


		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_020_B_ProductCompareAddtoCartTest ***");

		
	}

}
