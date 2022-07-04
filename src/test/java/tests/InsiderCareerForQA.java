package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import tests.base.BaseTest;

public class InsiderCareerForQA extends BaseTest {

    HomePage homePage;

    /*
    The reason why I used some static waits;
    Due to the current version of chrome, some parts of the project are giving errors despite the dynamic waits written.
    My research says that this problem will be fixed when the chrome version is updated.
    To solve this, static waits were added to some points of the project.
     */
    @Test
    public void insider_job_application_process_for_QA() throws InterruptedException {
        homePage = new HomePage();
        homePage.acceptAllCookies()
                .checkIsOpenedHomePage()
                .clickMoreButton()
                .clickCareersButtonInMore()
                .checkIsOpenedCareerPage()
                .checkBlocksOfCareerPage()
                .clickSeeAllTeams()
                .clickQualityAssurance()
                .clickSeeAllQAJobs()
                .clickFilterLocationDropdown()
                .selectLocationForIstanbul()
                .selectDepartmentForQualityAssurance()
                .checkJobList()
                .checkDepartmentNames()
                .checkPositionNames()
                .checkLocationNames()
                .selectApplyNow()
                .checkIsOpenedLeverApplicationPage();
    }
}
