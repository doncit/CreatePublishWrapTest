package selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CreateAndPublishWrapPage;
import pages.SignUpForPersonalPlanPage;

/**
 * Created by vaididon on 6/11/2016.
 */
public class WrapTest {

    private static final SignUpForPersonalPlanPage signUpForPersonalPlanPage = new SignUpForPersonalPlanPage();
    private static final CreateAndPublishWrapPage createAndPublishWrapPage = new CreateAndPublishWrapPage();

    @BeforeClass
    public static void PrepareBrowser() {

        signUpForPersonalPlanPage.init();
    }

    @Test
    public void createAndPublishWrap() throws InterruptedException {
        signUpForPersonalPlanPage.clickOnFreeTrialButton();
        signUpForPersonalPlanPage.signUp();
        signUpForPersonalPlanPage.enterEmail();
        signUpForPersonalPlanPage.submitEmail();
        signUpForPersonalPlanPage.clickOnLinkToEnterUsername();
        signUpForPersonalPlanPage.enterPassword();
        signUpForPersonalPlanPage.createAccount();
        signUpForPersonalPlanPage.fillInCompleteAccountInfoForm();
        signUpForPersonalPlanPage.finalCreateAccount();
        createAndPublishWrapPage.clickOnCreateNewWrap();
        createAndPublishWrapPage.selectTemplate();
        createAndPublishWrapPage.clickToCreateWrap();
        createAndPublishWrapPage.clickCloseHelpIcon();
    }

    @AfterClass
    public static void Quit() {
        createAndPublishWrapPage.quitDriver();
    }
}

