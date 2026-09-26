package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_022_ProductDisplayPageRelatedProductsTest extends BaseClass {

	String searchInput = "iMac";

	@Test(groups = { "master", "product display" })
	public void validate_related_product() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_022_ProductDisplayPageRelatedProductsTest ***");

			HomePage hp = new HomePage();
			
			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			String relatedProduct = dp.getFirstProductTitle(); 
			dp.clickFirstRelatedProductTitle();
			
			Assert.assertTrue(dp.isCorrectProductNameDisplay(relatedProduct), "Failed to navigate to related product display page!| ");
			
			logger.info("***Finished TC_PDP_022_ProductDisplayPageRelatedProductsTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
