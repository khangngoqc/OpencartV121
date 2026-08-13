package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_004_ProductDisplayPagePricesTest extends BaseClass {

	String searchInput = "iMac";
	String productPrice = "$122";
	String productExTaxPrice = "$100";

	@Test(groups = {"master", "product display"})
	public void validate_product_availability_display()
	{

		logger.info("***Starting TC_PDP_004_ProductDisplayPagePricesTest ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		Assert.assertTrue(dp.isProductPriceDisplay(productPrice), "Incorrect product price display! | ");
		Assert.assertTrue(dp.isProductExTaxPriceDisplay(productExTaxPrice), "Incorrect product excluded tax price display! | ");

		logger.info("***Finished TC_PDP_004_ProductDisplayPagePricesTest ***");

	}

}
