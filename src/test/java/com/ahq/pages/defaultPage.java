package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class defaultPage {
    @QAFTestStep(description = "TEst Step here with {0}")
    public void testStepHere(String test) throws Exception {
        BrowserGlobal.iComment(test);
    }
}
