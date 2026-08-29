package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_009_ProductDisplayPageProductSpecificationTest extends BaseClass {

	String searchInput = "Apple Cinema 30\"";
	
	@Test(groups = { "master", "product display" })
	public void validate_product_specification() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_009_ProductDisplayPageProductSpecificationTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			dp.clickSpecificationTab();

			Assert.assertTrue(dp.isCorrectProductDecriptionDisplay(), "Incorrect specification display! Primary keyword not found!");
			Assert.assertTrue(dp.isSpecGrammarCorrect(), "Grammar issue found in specification! ");
			
			
			logger.info("***Finished TC_PDP_009_ProductDisplayPageProductSpecificationTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}


}
