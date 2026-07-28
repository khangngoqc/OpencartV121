package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_013_ProductCompareSuccessMessageTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_success_message_links() {

		String searchKeyword = "iMac";
		logger.info("***Starting TC_PC_013_ProductCompareSuccessMessageTest ***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();

			Thread.sleep(500);
		
			Assert.assertTrue(sp.isProductCompareAlertBannerWork(searchKeyword), "Incorrect banner display!");

			Assert.assertTrue(sp.isAlertProductLinkWork(), "Unable to navigate to Product Display page!");
			sp.backToPreviousPage();

			Assert.assertTrue(sp.isAlertProductComparisonLinkWork(), "Unable to navigate to Product Comparison page!");



		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_013_ProductCompareSuccessMessageTest ***");

		
	}

}
