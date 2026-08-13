package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_003_ProductDisplayPageAvaialabilityTest extends BaseClass {

	String searchInput = "iMac";
	String[] productAvailability = {"Out Of Stock", "In Stock"};

	@Test(groups = {"master", "product display"})
	public void validate_product_availability_display()
	{

		logger.info("***Starting TC_PDP_003_ProductDisplayPageAvaialabilityTest ***");
		
		HomePage hp = new HomePage();
		
		SearchPage sp = hp.searchAProduct(searchInput);
		ProductDisplayPage dp = sp.clickFirstProductTitle();
		
		Assert.assertTrue(dp.isProductAvailabilityDisplay(productAvailability[0]), "Incorrect product availability display! | ");

		logger.info("***Finished TC_PDP_003_ProductDisplayPageAvaialabilityTest ***");

	}

}
