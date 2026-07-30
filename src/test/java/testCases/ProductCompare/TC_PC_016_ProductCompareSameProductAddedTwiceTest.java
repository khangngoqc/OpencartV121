package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_016_ProductCompareSameProductAddedTwiceTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_add_two_product() {

		String searchKeyword = "iMac";

		logger.info("***Starting TC_PC_016_ProductCompareSameProductAddedTwiceTest ***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);

			sp.clickCompareThisProductBtn();

			Thread.sleep(500);
			sp.setSearchInput(searchKeyword);
			sp.clickSearchBtn();

			sp.clickCompareThisProductBtn();
			Thread.sleep(500);

			ProductComparePage cp = sp.clickAlertProductComparisonLink();

			Assert.assertTrue(cp.isNProductAdded(1), "Only one entry of the added product should display!");


		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_016_ProductCompareSameProductAddedTwiceTest ***");

		
	}

}
