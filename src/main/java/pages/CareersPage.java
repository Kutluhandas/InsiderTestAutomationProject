package pages;

import commons.BaseCommons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CareersPage extends BaseCommons {

    private By seeAllTeamsButtonLocator = By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']");
    private By qualityAssuranceButtonLocator = By.xpath("(//h3[@class='text-center mb-4 mb-xl-5'])[12]");
    private By checkTeamsLocator = By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']");  //(//h3[@class='category-title-media'])[1]
    private By checkLocationsLocator = By.cssSelector("h3[class='category-title-media ml-0']");
    private By checkLifeAtInsiderLocator = By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[2]");

    private String teamsGetTextField(){
        return getTextViaAttribute(checkTeamsLocator);
    }
    private String locationGetTextField(){
        return getTextViaAttribute(checkLocationsLocator);
    }
    private String lifeAtInsiderGetTextField(){
        return getTextViaAttribute(checkLifeAtInsiderLocator);
    }

    public CareersPage checkBlocksOfCareerPage() throws InterruptedException {
        Assertions.assertEquals("See all teams", teamsGetTextField(), "There is no Teams field!");
        Assertions.assertEquals("\n" +
                "Our Locations ", locationGetTextField(), "There is no Locations field!");
        Assertions.assertEquals("Life at Insider", lifeAtInsiderGetTextField(), "There is no Life at Insider field!");
        return this;
    }

    public CareersPage checkIsOpenedCareerPage(){
        Assertions.assertEquals("Insider Careers", getTitle(), "Not on Career Page");
        return this;
    }

    public CareersPage clickSeeAllTeams() throws InterruptedException {
        Thread.sleep(2000); //Dynamic wait not working due to bug in chrome version 103. so i used this function.
        clickElementWithJS((RemoteWebDriver) driver, seeAllTeamsButtonLocator);
        return this;
    }

    public QualityAssurancePage clickQualityAssurance() {
        clickElementWithJS((RemoteWebDriver) driver, qualityAssuranceButtonLocator);
        return new QualityAssurancePage();
    }
}
