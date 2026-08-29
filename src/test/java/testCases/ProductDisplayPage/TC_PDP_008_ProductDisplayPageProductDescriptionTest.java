package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_008_ProductDisplayPageProductDescriptionTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	public void validate_product_description() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_008_ProductDisplayPageProductDescriptionTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();

			Assert.assertTrue(dp.isCorrectProductDecriptionDisplay(), "Incorrect description display! Primary keyword not found!");
			Assert.assertTrue(dp.isDescGrammarCorrect(), "Grammar issue found in description! ");
			
			
			logger.info("***Finished TC_PDP_008_ProductDisplayPageProductDescriptionTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
