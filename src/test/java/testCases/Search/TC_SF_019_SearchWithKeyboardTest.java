package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_019_SearchWithKeyboardTest extends BaseClass {

    @Test(groups = {"master", "search"})
    void search_keyboard_actions() {

        logger.info("******* Starting TC_SF_018_SearchPageBreadcrumbTest *******");

        try {

            HomePage hp = new HomePage();

            SearchPage sp = hp.searchWithKeyboard("Mac");

            Assert.assertTrue(sp.getPageTitle().contains("Search"), "Failed to search with keyboard");


        } catch (Exception e) {

            logger.debug(e.getMessage());
            Assert.fail(e.getMessage());

        }

        logger.info("******* Finished TC_SF_017_SearchPageSiteMapNavigationTest *******");


    }

}
