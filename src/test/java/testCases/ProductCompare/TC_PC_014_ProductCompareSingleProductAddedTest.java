package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_014_ProductCompareSingleProductAddedTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_add_single_product() {

		String searchKeyword = "iMac";
		logger.info("***Starting TC_PC_014_ProductCompareSingleProductAddedTest ***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);

			sp.clickCompareThisProductBtn();
			ProductComparePage cp = sp.clickProductCompareLink();

			Assert.assertTrue(cp.isNProductAdded(1), "Failed to add single product to Product Compare page!");


		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_014_ProductCompareSingleProductAddedTest ***");

		
	}

}
