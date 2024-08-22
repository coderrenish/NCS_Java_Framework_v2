package com.ahq.pages;

import com.ahq.globals.*;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class demoHomePage {
    @QAFTestStep(description="Home: I verify I'm in homepage")
    public void homeIVerifyIMInHomepage() throws Exception {
        BrowserGlobal.iAssertTextPresentInPage("Products");

    }

    @QAFTestStep(description="TEST: I test {0}")
    public void tESTITest(String testString){
        BrowserGlobal.iComment("==CSV==> " + testString);
    }


}
