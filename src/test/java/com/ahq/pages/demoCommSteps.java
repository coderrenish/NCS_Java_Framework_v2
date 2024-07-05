package com.ahq.pages;

import com.ahq.globals.web;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.And;


public class demoCommSteps {
    @QAFTestStep(description = "I Verify {0} page header text is {1}")
    @And("I Verify {string} page header text is {string}")
    public void iVerifyPageHeaderText(String pageName, String headerText) throws Exception {
        web.setPageName_Web(pageName);
        web.waitAndVerifyPageHeaderTextWithPageName_Web(headerText,pageName);
    }

    @QAFTestStep(description = "I Verify {0} page title text is {1}")
    @And("I Verify {string} page title text is {string}")
    public void iVerifyPageTitleText(String pageName, String titleText) throws Exception {
        web.setPageName_Web(pageName);
        web.waitAndVerifyPageTitleTextWithPageName_Web(titleText,pageName);
    }

}

