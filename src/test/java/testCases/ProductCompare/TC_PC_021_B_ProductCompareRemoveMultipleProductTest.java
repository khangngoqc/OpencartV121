package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_021_B_ProductCompareRemoveMultipleProductTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_remove_products() {

		String searchKeyword = "iMac";
		String searchKeyword2 = "iPhone";
		String searchKeyword3 = "Macbook Air";
		String searchKeyword4 = "Macbook";
		int noOfComparedProducts = 0;
		int noOfRemovedProducts = 3;

		logger.info("***Starting TC_PC_021_B_ProductCompareRemoveMultipleProductTest ***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);

			sp.clickCompareThisProductBtn();
			noOfComparedProducts++;

			Thread.sleep(500);
			sp.setSearchInput(searchKeyword2);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();
			noOfComparedProducts++;
			
			Thread.sleep(500);

			sp.setSearchInput(searchKeyword3);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();
			noOfComparedProducts++;
			
			Thread.sleep(500);

			sp.setSearchInput(searchKeyword4);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();
			noOfComparedProducts++;
			
			Thread.sleep(500);

			

			
			ProductComparePage cp = sp.clickProductCompareLink();
			cp.removeProducts(noOfRemovedProducts);

			Assert.assertEquals(cp.getComparedProductsCount(), noOfComparedProducts - noOfRemovedProducts,"Failed to remove multiple products from page!");


		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_021_B_ProductCompareRemoveMultipleProductTest ***");

		
	}

}
