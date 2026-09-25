package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_034_ProductDisplayPageAvailableOptionTest extends BaseClass {

	String searchInput = "Apple Cinema 30\"";
	String option1 = "Red (+$4.80)";
	String option2 = "Blue (+$3.60)";
	String option3 = "Green (+$1.20)";
	
	
	@Test(groups = { "master", "product display" })
	public void validate_product_available_option() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_034_ProductDisplayPageAvailableOptionTest ***");

			HomePage hp = new HomePage();

			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();

			Assert.assertTrue(dp.isMinimumQuantityDisplay(),
					"Incorrect product default quantity display! | found: " + dp.getQuantityValue());

			// fill product form

			dp.enableCheckbox1();
			dp.enableCheckbox2();
			dp.handleFormSelect(2);
			Assert.assertTrue(dp.isOptionSelected(option1), "Incorrect selected option display! | ");
			
			dp.handleFormSelect(3);
			Assert.assertTrue(dp.isOptionSelected(option2), "Incorrect selected option display! | ");
			
			dp.handleFormSelect(4);
			Assert.assertTrue(dp.isOptionSelected(option3), "Incorrect selected option display! | ");
						

			
			
			logger.info("***Finished TC_PDP_034_ProductDisplayPageAvailableOptionTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
