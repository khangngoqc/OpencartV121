package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_031_ProductDisplayPageRewardPointTest extends BaseClass {

	String searchInput = "Apple Cinema";
	int productPoints =  100;

	@Test(groups = {"master", "product display"})
	public void validate_product_name_reward_points_display()
	{

		logger.info("***Starting TC_PDP_031_ProductDisplayPageRewardPointTest ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		Assert.assertTrue(dp.isProductRewardPointsDisplay(productPoints), "Incorrect product reward points display! | ");
		
		logger.info("***Finished TC_PDP_031_ProductDisplayPageRewardPointTest ***");

	}

}
