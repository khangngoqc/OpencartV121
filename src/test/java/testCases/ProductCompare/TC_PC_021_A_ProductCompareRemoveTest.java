package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_021_A_ProductCompareRemoveTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_remove_a_product_from_page() {

		String searchKeyword = "iMac";
		
		logger.info("***Starting TC_PC_021_A_ProductCompareRemoveTest***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);

			sp.clickCompareThisProductBtn();

			ProductComparePage cp = sp.clickProductCompareLink();
			
			cp.clickRemoveBtn();
			
			Assert.assertEquals(cp.isNonProductAddedMessageDisplayed(), true , "Failed to remove product! ");
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_021_A_ProductCompareRemoveTest***");

		
	}

}
