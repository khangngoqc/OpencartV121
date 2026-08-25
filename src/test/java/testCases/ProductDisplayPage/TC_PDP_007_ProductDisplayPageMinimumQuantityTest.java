package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_007_ProductDisplayPageMinimumQuantityTest extends BaseClass {

	String searchInput = "Apple Cinema 30\"";
	String testFilePath = "D:\\TestFile.txt";

	@Test(groups = { "master", "product display" })
	public void validate_product_minimum_quantity_display() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_007_ProductDisplayPageMinimumQuantityTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();

			Assert.assertTrue(dp.isMinimumQuantityDisplay(),
					"Incorrect product default quantity display! | found: " + dp.getQuantityValue());

			// fill product form

			dp.enableCheckbox1();
			dp.enableCheckbox2();
			dp.handleFormSelect(2);
			dp.inputFormTextarea("test textarea");
			dp.uploadFormFile(testFilePath);
			dp.InputFormDate(2026, 6, 27);
			dp.InputFormTime(8, 50);
			dp.inputFormDateTime(2026, 6, 27, 9, 31);
			dp.addProductToCartByQuantity(1);

			Assert.assertTrue(dp.isMinimumWarningQuantityExistInDOM(), "Unable to find expected messsage! | ");
			Assert.assertTrue(dp.isAddToCartByQuantityWork(2), "Fail to add produc to cart!");
			
			logger.info("***Finished TC_PDP_007_ProductDisplayPageMinimumQuantityTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
