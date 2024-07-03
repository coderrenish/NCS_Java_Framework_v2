package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class lhubFundingCompPage {
    @QAFTestStep(description="FundingComp-Page: I verify I'm in funding Component page")
    public void fundingcompPageIVerifyImInFundingComponentPage() throws Exception{
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresent("loc.lhub.comm.text.dataloader");
        BrowserGlobal.iWaitUntilElementNotPresent("loc.lhub.comm.text.dataloader");
        BrowserGlobal.iAssertTitlePartialText("Funding Component");
    }
    @QAFTestStep(description="FundingComp-Page: I click on Create button")
    public void fundingCompPageIClickOnCreateButton() throws Exception{
        BrowserGlobal.iClickOn("loc.lhub.fundingComponent.button.create");
    }

}

