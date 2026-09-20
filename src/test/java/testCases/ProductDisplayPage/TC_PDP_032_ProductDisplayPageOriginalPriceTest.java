package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_032_ProductDisplayPageOriginalPriceTest extends BaseClass {

	String searchInput = "Apple Cinema";
	int productOriginalPrice =  122;

	@Test(groups = {"master", "product display"})
	public void validate_product_name_reward_points_display()
	{

		logger.info("***Starting TC_PDP_032_ProductDisplayPageOriginalPriceTest.java ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		Assert.assertTrue(dp.isOriginalProductPriceDisplay(productOriginalPrice), "Incorrect product original price display! | ");
		
		logger.info("***Finished TC_PDP_032_ProductDisplayPageOriginalPriceTest ***");

	}

}
