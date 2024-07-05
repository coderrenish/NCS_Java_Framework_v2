package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.And;


public class defaultPage {
    @QAFTestStep(description = "Test Step here with {0}")
    @And("Test Step here with {string}")
    public void testStepHere(String test) throws Exception {
        BrowserGlobal.iComment(test);
    }
}
