package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_002_ProductDisplayPageNameBrandCodeTest extends BaseClass {

	String searchInput = "iMac";
	String productBrand = "Apple";
	String productCode = "Product 14";

	@Test(groups = {"master", "product display"})
	public void validate_product_name_brand_code_display()
	{

		logger.info("***Starting TC_PDP_002_ProductDisplayPageNameBrandCodeTest ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		Assert.assertTrue(dp.isProductNameDisplay(searchInput), "Incorrect product name display! | ");
		Assert.assertTrue(dp.isProductBrandDisplay(productBrand), "Incorrect product brand display! | ");
		Assert.assertTrue(dp.isProductCodeDisplay(productCode), "Incorrect product code display! | ");

		logger.info("***Finished TC_PDP_002_ProductDisplayPageNameBrandCodeTest ***");

	}

}
