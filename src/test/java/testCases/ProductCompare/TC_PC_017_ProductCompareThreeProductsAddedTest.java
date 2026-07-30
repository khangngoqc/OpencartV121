package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_017_ProductCompareThreeProductsAddedTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_add_two_product() {

		String searchKeyword = "iMac";
		String searchKeyword2 = "iPhone";
		String searchKeyword3 = "Macbook Air";

		logger.info("***Starting TC_PC_017_ProductCompareThreeProductAddedTest ***");
 
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

			ProductComparePage cp = sp.clickProductCompareLink();

			Assert.assertTrue(cp.isNProductAdded(3), "Failed to add three products to Product Compare page!");


		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_017_ProductCompareThreeProductAddedTest ***");

		
	}

}
