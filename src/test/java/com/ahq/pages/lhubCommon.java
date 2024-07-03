package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.qmetry.qaf.automation.step.QAFTestStep;

// OLD CODE.

public class lhubCommon {
    @QAFTestStep(description="{0}: Menu: I click on {1} button")
    public void MenuIClickOnButton(String page, String button_text) throws Exception{
        BrowserGlobal.iClickOn("xpath=//button[@type='button']//span[text()='"+button_text+"']");
    }

    @QAFTestStep(description="{0}: I verify I'm in {1} page")
    public void IVerifyImInPage(String page, String title) throws Exception{
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresent("loc.lhub.comm.text.dataloader");
        BrowserGlobal.iWaitUntilElementNotPresent("loc.lhub.comm.text.dataloader");
//        BrowserGlobal.iWaitForSeconds("2");
        if(page.equalsIgnoreCase("FundingCompCreate-Page")) {
            try {
                BrowserGlobal.iAssertTitlePartialText("LHUB | LHUB");
            } catch (Exception e){
                BrowserGlobal.iAssertTitlePartialText(title);
            }

        } else {
            BrowserGlobal.iAssertTitlePartialText(title);
        }
    }

    @QAFTestStep(description="{0}: I verify I'm in {1} home page")
    public void IVerifyImInHomePage(String page, String title) throws Exception{
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitForSeconds("1");
//        BrowserGlobal.iWaitUntilElementPresent("loc.lhub.comm.text.dataloader");
//        BrowserGlobal.iWaitUntilElementNotPresent("loc.lhub.comm.text.dataloader");
        BrowserGlobal.iAssertTitlePartialText(title);
    }


}

