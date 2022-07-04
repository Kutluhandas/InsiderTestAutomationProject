package pages;

import commons.BaseCommons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


public class AllOpenPositionsPage extends BaseCommons {

    private By filterLocationDropdownLocator = By.cssSelector("span[id='select2-filter-by-location-container']");
    private By filterDepartmentDropdownLocator = By.cssSelector("span[id='select2-filter-by-department-container']");
    private By locationForExpectedLocator = By.cssSelector("select[name='filter-by-location']");
    private By departmentForExpectedLocator = By.cssSelector("select[name='filter-by-department']");
    private By jobPostingFrameLocator = By.xpath("(//p[@class='position-title font-weight-bold'])[4]");
    private By applyNowButtonLocator = By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[4]");
    private By jobShowingLocator = By.cssSelector("p[id='resultCounter']");
    private By departmentsLocatorsForList = By.cssSelector("span[class='position-department text-large font-weight-600 text-primary']");
    private By locationsLocatorForList = By.cssSelector("div[class='position-location text-large']");
    private By positionsLocatorForList = By.cssSelector("p[class='position-title font-weight-bold']");

    public AllOpenPositionsPage checkPositionNames() {
        checkingSameFieldsInAds(positionsLocatorForList, "Quality Assurance");
        return this;
    }

    public AllOpenPositionsPage checkDepartmentNames() {
        checkingSameFieldsInAds(departmentsLocatorsForList, "Quality Assurance");
        return this;
    }

    public AllOpenPositionsPage checkLocationNames() {
        checkingSameFieldsInAds(locationsLocatorForList, "Istanbul, Turkey");
        return this;
    }

    public AllOpenPositionsPage checkJobList() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(contains(jobShowingLocator, "Showing"), "There is no job on these filters!");
        return this;
    }

    public AllOpenPositionsPage clickFilterLocationDropdown() throws InterruptedException {
        scroll(500);
        Thread.sleep(1000);
        click(filterLocationDropdownLocator);
        return this;
    }

    public AllOpenPositionsPage selectLocationForIstanbul() throws InterruptedException {
        Thread.sleep(2000);
        selection(locationForExpectedLocator, "Istanbul, Turkey");
        click(filterLocationDropdownLocator);
        return this;
    }

    public AllOpenPositionsPage selectDepartmentForQualityAssurance() throws InterruptedException {
        click(filterDepartmentDropdownLocator);
        Thread.sleep(2000);
        selection(departmentForExpectedLocator, "Quality Assurance");
        click(filterDepartmentDropdownLocator);
        return this;
    }

    public LeverAppFormPage selectApplyNow() throws InterruptedException {
        scroll(500);
        Thread.sleep(2000);
        hoverOver(jobPostingFrameLocator);
        click(applyNowButtonLocator);
        return new LeverAppFormPage();
    }
}
