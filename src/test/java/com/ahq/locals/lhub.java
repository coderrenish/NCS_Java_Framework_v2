/*******************************************************************************
 * Copyright (c) 2023 Access HQ (NCS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.ahq.locals;

import com.ahq.globals.BrowserGlobal;
import com.ahq.addons.loc;
import com.ahq.globals.web;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import org.openqa.selenium.WebElement;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class lhub {

    @QAFTestStep(description="{0}: Verify-Page-Header Text:{1}")
    public void verifyPageHeader_LHUB(String pageName,String headerName) throws Exception{
        web.setPageName(pageName);
        web.verifyPageHeader(headerName);
    }

    @QAFTestStep(description="{0}: Verify-Partial-Page-Title Text:{1}")
    public void verifyPartialPageTitle_LHUB(String pageName,String titleName) throws Exception{
        web.setPageName(pageName);
        web.verifyPartialPageTitle(titleName);
    }

    @QAFTestStep(description="{0}: Verify-Page-Title Text:{1}")
    public void verifyPageTitle_LHUB(String pageName,String titleName) throws Exception{
        web.setPageName(pageName);
        web.verifyPageTitle(titleName);
    }

    @QAFTestStep(description="{0}: Verify-Page-Header-And-Partial-Page-Title Header-Text:{1} Title-Text:{2}")
    public void verifyPageHeaderAndPartialPageTitle_LHUB(String pageName,String headerName, String titleName) throws Exception{
        web.setPageName(pageName);
        web.verifyPageHeader(headerName);
        web.verifyPartialPageTitle(titleName);
    }

    @QAFTestStep(description="{0}: Verify-Page-Header-And-Page-Title Header-Text:{1} Title-Text:{2}")
    public void verifyPageHeaderAndPageTitle_LHUB(String pageName,String headerName, String titleName) throws Exception{
        web.setPageName(pageName);
        web.verifyPageHeader(headerName);
        web.verifyPageTitle(titleName);
    }

    @QAFTestStep(description="Navigate-To-Main-Module Text:{0}")
    public void navigateToMainModule_LHUB(String menuText) throws Exception{
        web.clickLink(menuText);
    }

    @QAFTestStep(description="Navigate-To-Sub-Module Text:{0}")
    public void navigateToSubModule_LHUB(String menuText) throws Exception{
        web.clickLink(menuText);
    }

    @QAFTestStep(description="Click-On-Top-Menu-Button Text:{0}")
    public void clickOnTopMenuButton_LHUB(String menuButtonText) throws Exception{
        web.clickButton(menuButtonText);
    }

    public static void addSupportDocuments_LHUB(String documentNames) throws Exception{
        String[] docNames =  documentNames.split(",");
        int loopCount = 0;
        String lastVal = null;
        for (String dName: docNames) {
            loopCount++;
            web.clickButton("Add");
            if (loopCount > 1) {
                BrowserGlobal.iClickOn("xpath=(//input[@value='"+lastVal+"']/following-sibling::span)[1]");
            }
            lastVal = dName;
            web.setFieldLocation("dialog");
//            web.setPageName("FUNDING-COMPONENTS-FORM::dialog");
            web.inputWithPlaceholder(dName,"Search (min. 3 characters) by funding supporting document or description");
            BrowserGlobal.iPressReturnOrEnterKey();
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iClickOn("xpath=//tr[@class='ant-table-row ant-table-row-level-0']//input[@class='ant-checkbox-input']");
            web.clickButton("OK");
            web.setFieldLocation("main_content");
//            web.removeFieldLocation();
//            web.setPageName("FUNDING-COMPONENTS-FORM");
        }
    }



    // OLD CODE - We can deprecate it.

    public static void clickSwitchButton(String page, String switchName, String clickStatus, String instance) throws Exception{
        if (clickStatus.equalsIgnoreCase("Yes")) {
//            BrowserGlobal.iWaitUntilElementNotPresentWithTimeout("xpath=//span[text()='Oops! Something went wrong...']","20");
            BrowserGlobal.iMouseoverOn(loc.pattern(page,"button.switch",switchName,instance));
            BrowserGlobal.iClickOn(loc.pattern(page,"button.switch",switchName,instance));
        }
    }
        public static void clickValidateButtonInstance(String buttonInstance) throws Exception{
//        BrowserGlobal.iWaitUntilElementEnabled(loc.patternLoc("FundingCompCreate","button","Validate",buttonInstance));
        BrowserGlobal.iMouseoverOn(loc.pattern("FundingCompCreate","button","Validate",buttonInstance));
        BrowserGlobal.iClickOn(loc.pattern("FundingCompCreate","button","Validate",buttonInstance));
    }


}
