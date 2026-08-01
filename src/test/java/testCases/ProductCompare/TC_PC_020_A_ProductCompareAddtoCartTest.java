package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_020_A_ProductCompareAddtoCartTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_adding_a_product_cart() {

		String searchKeyword = "iMac";
		
		logger.info("***Starting TC_PC_020_A_ProductCompareAddtoCartTest***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);

			sp.clickCompareThisProductBtn();

			ProductComparePage cp = sp.clickProductCompareLink();
			
			cp.clickAddToCartBtn();
			cp.clickCartBtn();

			Assert.assertEquals(cp.isProductAddedToCart(searchKeyword), true , "Failed to add product to cart!");
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_020_A_ProductCompareAddtoCartTest***");

		
	}

}
