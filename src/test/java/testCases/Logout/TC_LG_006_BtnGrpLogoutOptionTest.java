package testCases.Logout;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_LG_006_BtnGrpLogoutOptionTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_logout_btn_grp_before_login () {
		logger.info("***Starting TC_LG_006_BtnGrpLogoutOptionTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage rp = new AccountRegistrationPage();

			List<WebElement> groupItems = rp.getGroupItems();
			
			for (WebElement item : groupItems) {
			
				// validation
				if(item.getText().contains("Logout")) {			
					Assert.assertTrue(false, "Logout option should not be displayed in the 'Right Column'.");
				};
			}
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_006_BtnGrpLogoutOptionTest ***");

	}

}
