package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_020_SearchPageHeadingURLTitleTest extends BaseClass {

    @Test(groups = {"master", "search"})
    void search_page_heading_title_url() {

        logger.info("******* Starting TC_SF_020_SearchPageHeadingURLTitleTest *******");

        try {

            HomePage hp = new HomePage();

            SearchPage sp = hp.searchWithKeyboard("Mac");

            Thread.sleep(2000);

            Assert.assertTrue(sp.isPageHeadingDisplayed(), "Incorrect page heading display!");
            Assert.assertTrue(sp.isPageTitleDisplayed("Search"), "Incorrect page title display!");
            Assert.assertTrue(sp.isPageURLDisplayed("Search"), "Incorrect page url display!");



        } catch (Exception e) {

            logger.debug(e.getMessage());
            Assert.fail(e.getMessage());

        }

        logger.info("******* Finished TC_SF_020_SearchPageHeadingURLTitleTest *******");


    }

}
