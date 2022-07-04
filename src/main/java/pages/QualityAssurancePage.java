package pages;

import commons.BaseCommons;
import org.openqa.selenium.By;

public class QualityAssurancePage extends BaseCommons {

    private By seeAllQAJobsButtonLocator = By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']");

    public AllOpenPositionsPage clickSeeAllQAJobs() throws InterruptedException {
        Thread.sleep(2000); //Dynamic wait not working due to bug in chrome version 103. so i used this function.
        click(seeAllQAJobsButtonLocator);
        return new AllOpenPositionsPage();
    }
}
