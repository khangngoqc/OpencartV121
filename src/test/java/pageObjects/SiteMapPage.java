package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SiteMapPage extends BasePage{
    public  SiteMapPage() {
        super();
    }

    @FindBy(xpath ="//div[@id='content']//ul//a")
    List<WebElement> siteMapLinks;

    @FindBy(xpath="//div[@id='content']//ul//a[contains(.,'Search')]") WebElement SearchPageLink;

    public SearchPage clickSearchPageLink(){
        SearchPageLink.click();
        return new SearchPage();
    }

    public List<WebElement> getSiteMapLinks(){
        return siteMapLinks;
    }





}
