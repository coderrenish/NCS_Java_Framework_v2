package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.web;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.And;


public class demoCommSteps {
    @QAFTestStep(description = "I Verify {0} page header text is {1}")
    @And("I Verify {string} page header text is {string}")
    public void iVerifyPageHeaderText(String pageName, String headerText) throws Exception {
        web.setPageName_Web(pageName);
        web.verifyPageHeader_Web(headerText,pageName);
    }

    @QAFTestStep(description = "I Verify {0} page title text is {1}")
    @And("I Verify {string} page title text is {string}")
    public void iVerifyPageTitleText(String pageName, String titleText) throws Exception {
        web.setPageName_Web(pageName);
        web.verifyPageTitle_Web(titleText,pageName);
    }

    @QAFTestStep(description = "I fail step")
    @And("I fail step")
    public void iFailStep() throws Exception {
        BrowserGlobal.iFailStepWithInfo("");
    }

    @QAFTestStep(description = "I skip step")
    @And("I skip step")
    public void iSkipStep() throws Exception {
//
    }

}

