package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_019_ProductCompareProductsAddingLimitTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_adding_limit() {

		String searchKeyword = "iMac";
		String searchKeyword2 = "iPhone";
		String searchKeyword3 = "Macbook Air";
		String searchKeyword4 = "Macbook";
		String searchKeyword5 = "Macbook Pro";

		logger.info("***Starting TC_PC_019_ProductCompareProductsAddingLimitTest ***");
 
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

			sp.setSearchInput(searchKeyword5);
			sp.clickSearchBtn();
			sp.clickCompareThisProductBtn();

			Thread.sleep(500);


			ProductComparePage cp = sp.clickProductCompareLink();

			Assert.assertEquals(cp.isNProductAdded(5), false , "Product Compare page should be limit at 4 products [A]!");
			Assert.assertEquals(cp.isNProductAdded(4), true , "Product Compare page should be limit at 4 products [B]!");
			Assert.assertEquals(cp.isProductAdded(searchKeyword5), true, "The fifth compared product failed to be added!" );
			Assert.assertEquals(cp.isProductAdded(searchKeyword), false, "The first compared prodcut is not removed!" );

		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_019_ProductCompareProductsAddingLimitTest ***");

		
	}

}
