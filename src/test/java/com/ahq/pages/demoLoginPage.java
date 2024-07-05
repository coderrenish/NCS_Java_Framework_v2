package com.ahq.pages;

import com.ahq.globals.*;
//import com.ahq.BrowserGlobal.utils.*;
import com.ahq.addons.*;
//import com.ahq.utils.nics_singapore;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.And;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class demoLoginPage {
    @QAFTestStep(description = "I login to SauseDemo using {0}, {1} and {2}")
    @And("I login to SauseDemo using {string}, {string} and {string}")
    public void iLoginToSauseDemo(String url, String username, String password) throws Exception {
        web.setPageName_Web("Login Page");
        web.openBrowser_Web(url);
        web.inputTextWithPlaceholder_Web(username,"Username");
        web.inputTextWithPlaceholder_Web(password,"Password");
        web.clickButton_Web("Login");
    }

}

