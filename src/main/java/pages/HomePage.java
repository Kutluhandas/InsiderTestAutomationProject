package pages;


import commons.BaseCommons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BaseCommons {

    public HomePage() {
        super();
        driver.get(baseUrl);
    }

    private By acceptAllCookiesLocator = By.id("wt-cli-accept-all-btn");
    private By moreButtonLocator = By.cssSelector("a[class='nav-link dropdown-toggle']");
    private By careersButtonLocator = By.xpath("//a[@class='d-flex flex-column flex-fill' and @href='https://useinsider.com/careers/']");

    public HomePage acceptAllCookies() {
        click(acceptAllCookiesLocator);
        return this;
    }

    public HomePage clickMoreButton() {
        clickInList(moreButtonLocator, 3);
        return this;
    }

    public HomePage checkIsOpenedHomePage(){
        Assertions.assertEquals("Insider personalization engine for seamless customer experiences",
                getTitle(), "Not on home page!");
        return this;
    }

    public CareersPage clickCareersButtonInMore() throws InterruptedException {
        Thread.sleep(2000);
        click(careersButtonLocator);
        return new CareersPage();
    }


}
