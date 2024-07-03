package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class lhubFundingPage {
    @QAFTestStep(description="Funding-Page: I verify I'm in funding home page")
    public void fundingPageIVerifyIMInFundingHomePage() throws Exception{
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresent("loc.lhub.fundingHome.text.fundingComponent");
        BrowserGlobal.iAssertTextPresentInPage("Funding");
    }

    @QAFTestStep(description="Funding-Page: I navigate to Funding component")
    public void fundingPageINavigateToFundingComponent() throws Exception{
        BrowserGlobal.iClickOn("loc.lhub.fundingHome.text.fundingComponent");

    }

}

