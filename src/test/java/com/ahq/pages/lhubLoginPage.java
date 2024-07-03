package com.ahq.pages;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.Utils;
import com.ahq.globals.web;
import com.qmetry.qaf.automation.step.QAFTestStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.lang.annotation.*;


import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class lhubLoginPage {
    @QAFTestStep(description="Login-Page: I login to LHUB with following details {0}")
    public void loginPageILoginToLHUBWithFollowingDetails(String url) throws Exception{
//        BrowserGlobal.iOpenWebBrowser(url);
        web.openBrowser(url);
    }

    // @QAFTestStep(description="LOGIN: Login To LHUB with following details {0} {1} and {2}")
    // public void LoginToLHUBWithFollowingDetails(String url) throws Exception{
    //     web.openBrowser(url);
    //     web.setPageName("LOGIN");
    //     web.clickLink("Dashboard");
    // }

    @Given("^LOGIN: Login To LHUB with following details (\\d+) (\\d+) and (\\d+)$")
    // @QAFTestStep(description="LOGIN: Login To LHUB with following details {0} {1} and {2}")
    public void LoginToLHUBWithFollowingDetails(String url) throws Exception{
        web.openBrowser(url);
        web.setPageName("LOGIN");
        web.clickLink("Dashboard");
    }


    @Given("LOGIN: Login To LHUB {0}")
    @QAFTestStep(description="^LOGIN: Login To LHUB {0}$")
    public void LoginToLHUB(String url) throws Exception{
        web.openBrowser(url);
        web.setPageName("LOGIN");
        web.clickLink("Dashboard");
    }



}

