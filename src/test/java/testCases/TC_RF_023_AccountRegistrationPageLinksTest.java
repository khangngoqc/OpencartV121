package testCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_023_AccountRegistrationPageLinksTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_on_page_links() {

		logger.info("******* Starting TC_RF_023_AccountRegistrationPageLinksTest *******");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			// capture all the links from the webpage
			List<WebElement> links = driver.findElements(By.tagName("a"));
			logger.info("Total number of links: " + links.size());

			int noOfBrokenLink = 0;

			for (WebElement l : links) {

				String hrefAttrValue = l.getAttribute("href");

				if (hrefAttrValue == null || hrefAttrValue.isEmpty()) {
					logger.info(l.getText() + "href attribute value is empty => Impossible to check");
					continue;
				}

				// hit the URL to the server
				try {

					URL linkURL = new URL(hrefAttrValue); // converted href value from string to URL format
					HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); // open connection to the
																							// server
					conn.connect(); // connect to server and send request to the server

					if (conn.getResponseCode() >= 400) {
						logger.info(l.getText() + "		" + conn.getResponseCode() + "		" + hrefAttrValue + "	(Broken link)");
						noOfBrokenLink++;
					}
				} catch (Exception e) {
				}

			}

			logger.info("Number of broken links: " + noOfBrokenLink);

			if (noOfBrokenLink > 0) {
				Assert.assertTrue(false,"Broken links detected! " + noOfBrokenLink +" " );

			}

		} catch (Exception e) {

			Assert.fail();
			logger.debug(e.getMessage());

		}

		logger.info("******* Finished TC_RF_023_AccountRegistrationPageLinksTest *******");

	}

}
