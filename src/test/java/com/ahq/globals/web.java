package com.ahq.globals;
import com.ahq.addons.patternLoc;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class web {
    /**
     * @param pageName [Set page name for Locator Name Generation]
     */
    @And("Web: Set Page name {string}")
    @QAFTestStep(description = "Web: Set Page name {0}")
    public static void setPageName(String pageName) throws Exception {
        getBundle().setProperty("auto.page.name",pageName);
    }

    /**
     * @param locationName [Set Location name of the field within Page]
     */
    @QAFTestStep(description = "Web: Set field Location {0}")
    public static void setFieldLocation(String locationName) throws Exception {
        String pageName = getBundle().getPropertyValue("auto.page.name");
        if (pageName.contains("::")) {
            String[] fldNameSplit = pageName.trim().split("::");
            getBundle().setProperty("auto.page.name", fldNameSplit[0].trim()+"::"+locationName.trim());
        } else {
            getBundle().setProperty("auto.page.name",pageName+"::"+locationName.trim());
        }
    }

    /**
     *
     */
    @QAFTestStep(description = "Web: Remove field Location")
    public static void removeFieldLocation() throws Exception {
        String pageName = getBundle().getPropertyValue("auto.page.name");
        if (pageName.contains("::")) {
            String[] fldNameSplit = pageName.trim().split("::");
            getBundle().setProperty("auto.page.name", fldNameSplit[0].trim());
        }
    }

    /**
     * Setting Current execution time to variable - var.exec.dateTime
     */
    @QAFTestStep(description = "Web: Set current exec date time")
    public static void setCurrentExecDateTime() throws Exception {
        getBundle().setProperty("var.exec.dateTime",Utils.dateTime_currentDateTime());
    }

    /**
     * Getting execution time from variable - var.exec.dateTime
     */
    @QAFTestStep(description = "Web: Get execution date time {0}")
    public static String getExecDateTime() throws Exception {
        return getBundle().getPropertyValue("var.exec.dateTime");
    }

    /**
     * @param url [Open browser with URL]
     */
    @QAFTestStep(description = "Web: Open url {0}")
    public static void openBrowser(String url) throws Exception {
        BrowserGlobal.iOpenWebBrowser(url);
        web.setCurrentExecDateTime();
    }
    /**
     * @param url [Open browser with URL]
     */
    @QAFTestStep(description = "Web: Open url {0} And Maximize")
    public static void openMaximizedBrowser(String url) throws Exception {
        BrowserGlobal.iOpenWebBrowserAndMaximize(url);
        setCurrentExecDateTime();
    }
    /**
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Click Link {0}")
    public static void clickLink(String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.link(getPageName(),field));
        BrowserGlobal.iScrollToAnElement(patternLoc.link(getPageName(),field));
        BrowserGlobal.iWaitUntilElementEnabled(patternLoc.link(getPageName(),field));
        BrowserGlobal.iClickOn(patternLoc.link(getPageName(),field));
    }

    /**
     * @param button_name [Button name]
     */
    @QAFTestStep(description = "Web: Click Button {0}")
    public static void clickButton(String button_name) throws Exception {
        BrowserGlobal.iScrollToAnElement(patternLoc.button(getPageName(), button_name));
        BrowserGlobal.iWaitUntilElementEnabled(patternLoc.button(getPageName(), button_name));
        BrowserGlobal.iClickOn(patternLoc.button(getPageName(), button_name));
    }

    /**
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Click Switch Button {0}")
    public static void clickSwitchButton(String field) throws Exception {
        BrowserGlobal.iScrollToAnElement(patternLoc.switchButton(getPageName(), field));
        BrowserGlobal.iWaitUntilElementEnabled(patternLoc.switchButton(getPageName(), field));
        BrowserGlobal.iClickOn(patternLoc.switchButton(getPageName(), field));
    }

    /**
     * @param text [text to fill]
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Input {0} into {1}")
    public static void input(String text,String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.input(getPageName(),field));
        BrowserGlobal.iScrollToAnElement(patternLoc.input(getPageName(),field));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.input(getPageName(),field));
        BrowserGlobal.iInputInTo(text, patternLoc.input(getPageName(),field));
    }

    /**
     * @param text [text to fill]
     * @param placeholder_text [Placeholder Text]
     */
    @QAFTestStep(description = "Web: Input {0} into {1} with Placeholder")
    public static void inputWithPlaceholder(String text,String placeholder_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.input(getPageName(),placeholder_text,Boolean.FALSE));
        BrowserGlobal.iScrollToAnElement(patternLoc.input(getPageName(),placeholder_text,Boolean.FALSE));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.input(getPageName(),placeholder_text,Boolean.FALSE));
        BrowserGlobal.iInputInTo(text, patternLoc.input(getPageName(),placeholder_text,Boolean.FALSE));
    }

    /**
     *
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Click Checkbox with text {1}")
    public static void clickCheckBox(String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.checkbox(getPageName(),field));
        BrowserGlobal.iScrollToAnElement(patternLoc.checkbox(getPageName(),field));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.checkbox(getPageName(),field));
        BrowserGlobal.iClickOn(patternLoc.checkbox(getPageName(),field));
    }

    /**
     * @param dropdown_Text [Text to be selected in dropdown]
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Select Dropdown with text {0} in {1}")
    public static void selectDropdownByText(String dropdown_Text, String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.select(getPageName(), field));
        BrowserGlobal.iScrollToAnElement(patternLoc.select(getPageName(), field));
        BrowserGlobal.iSelectDropdownWithText(patternLoc.select(getPageName(), field), dropdown_Text);
    }

    /**
     * @param dropdown_Text [Text to be selected in dropdown]
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Select dropdown by input text {0} in {1}")
    public static void selectDropdownByInput(String dropdown_Text, String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.input(getPageName(), field));
        BrowserGlobal.iScrollToAnElement(patternLoc.input(getPageName(), field));
        BrowserGlobal.iFillInTo(dropdown_Text, patternLoc.input(getPageName(), field));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressKey("Enter");
    }

    /**
     * @param radio_Text [Text to be selected in Radio button]
     * @param field [Field name]
     */

    @QAFTestStep(description = "Web: Click Radio Button with text {0} in {1}")
    public static void clickRadioButton(String radio_Text, String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.radioButton(getPageName(),field,radio_Text));
        BrowserGlobal.iScrollToAnElement(patternLoc.radioButton(getPageName(),field,radio_Text));
        BrowserGlobal.iClickOn(patternLoc.radioButton(getPageName(),field,radio_Text));
    }


    /**
     * @param header_text [Header text to be verified]
     */
    @QAFTestStep(description = "Web: Verify page header with Text {0}")
    public static void verifyPageHeader(String header_text) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iScrollToAnElement(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iAssertElementText(patternLoc.header(getPageName(),header_text),header_text);
    }

    /**
     * @param partial_title [Partial Page Title of the page]
     */
    @QAFTestStep(description = "Web: Verify partial page title {1}")
    public static void verifyPartialPageTitle(String partial_title) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        getBundle().setProperty("auto.page.name",getPageName());
        BrowserGlobal.iAssertTitlePartialText(partial_title);
    }

    /**
     * @param title_text [Page Title of the page]
     */
    @QAFTestStep(description = "Web: Verify partial page title {1}")
    public static void verifyPageTitle(String title_text) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        getBundle().setProperty("auto.page.name",getPageName());
        BrowserGlobal.iAssertTitleText(title_text);
    }


// Verify "Dashboard" page is displayed with title "Home Dashboard"
    /**
     * @param page [Page name]
     * @param title [Part Title of the page]
     */
    @QAFTestStep(description = "Web: Verify {0} page is displayed with title {1}")
    public static void verifyPageWithPartialTitle(String page, String title) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        getBundle().setProperty("auto.page.name",page);
        BrowserGlobal.iAssertTitlePartialText(title);
    }
    /**
     * @param page [Page name]
     * @param header_text [Header text to be verified]
     */
    @QAFTestStep(description = "Web: Verify {0} page is displayed with header text {1}")
    public static void verifyPageWithHeader(String page, String header_text) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iScrollToAnElement(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iAssertElementText(patternLoc.header(page,header_text),header_text);
    }
    /**
     * @param page [Page name]
     * @param header_text [Header text to be verified]
     */
    @QAFTestStep(description = "Web: Verify {0} page is displayed with Text {1}")
    public static void verifyPageText(String page, String header_text) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iScrollToAnElement(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.header(getPageName(),header_text));
        BrowserGlobal.iAssertElementText(patternLoc.header(page,header_text),header_text);
    }
    /**
     * @param page [Page name]
     * @param header_text [Header text to be verified]
     */
    @QAFTestStep(description = "Web: Verify {0} page is displayed with Partial Text {1}")
    public static void verifyPartialText(String page, String header_text) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementPresentWithTimeout(patternLoc.link(getPageName(),header_text), "10");
        BrowserGlobal.iScrollToAnElement(patternLoc.link(getPageName(),header_text));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.link(getPageName(),header_text));
        String msgSuccess = BrowserGlobal.iGetText(patternLoc.link(getPageName(),header_text));
        msgSuccess.contains(header_text);
    }
    /**
     *
     * @throws Exception
     */
    @QAFTestStep(description = "Web: I wait for page Load")
    public static void waitForPageLoad() throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
    }
    /**
     *
     * @param tabNumber [Tab number to locate]
     *
     */
    @QAFTestStep(description = "Web: I swift to the tab {0}")
    public static void moveTab(String tabNumber) throws Exception {
        BrowserGlobal.iSwitchWindowByIndex(tabNumber);
    }


/**
 * @param radio_Text [Text to be selected in Radio button]
 * @param field [Field name]
 */
/* @QAFTestStep(description = "Choose Field:{0} Value:{1}")
public static void radioButton(String radio_Text, String field) throws Exception {
BrowserGlobal.iWaitUntilElementPresentWithTimeout(patternLoc.radio(getPageName(),field,radio_Text),"10");
BrowserGlobal.iWaitUntilElementPresent(patternLoc.radio(getPageName(),field,radio_Text));
BrowserGlobal.iScrollToAnElement(patternLoc.radio(getPageName(),field,radio_Text));
BrowserGlobal.iClickOn(patternLoc.radio(getPageName(),field,radio_Text));
} */
    /**
     *
     * @param field [Field name]
     *
     */
    @QAFTestStep(description = "Web: Choose Field:{0} Value:{1}")
    public static void tabOut( String field) throws Exception {
        BrowserGlobal.iClickAndTabInToThenEnter(patternLoc.input(getPageName(),field));
    }
/**
 *
 * @param field [Field name]
 *
 */
/* @QAFTestStep(description = "tab Out and Enter on Field {0}")
public static void tabOnceAndEnter( String field) throws Exception {
BrowserGlobal.iTabInToThenEnter(patternLoc.input(getPageName(),field));
} */
    /**
     * @param text [text to fill]
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Input {0} into {1} without label")
    public static void inputWithoutLabel(String text,String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.input(getPageName(),field, false));
        BrowserGlobal.iScrollToAnElement(patternLoc.input(getPageName(),field, false));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.input(getPageName(),field, false));
        BrowserGlobal.iInputInTo(text, patternLoc.input(getPageName(),field, false));
    }

/**
 * @param field [Field name]
 */
/* @QAFTestStep(description = "Click button {0}")
public static void clickModalButton(String field) throws Exception {
BrowserGlobal.iWaitUntilElementVisibleWithTimeout(patternLoc.modalButton(getPageName(),field),"10");
BrowserGlobal.iScrollToAnElement(patternLoc.modalButton(getPageName(),field));
BrowserGlobal.iWaitUntilElementEnabled(patternLoc.modalButton(getPageName(),field));
BrowserGlobal.iClickOn(patternLoc.modalButton(getPageName(),field));
} */
    /**
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Click Input field {0}")
    public static void clickInput(String field) throws Exception {
        BrowserGlobal.iClickOn(patternLoc.input(getPageName(),field));
    }

    /**
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Double click on link {0}")
    public static void doubleClickButton(String field) throws Exception {
        BrowserGlobal.iScrollToAnElement(patternLoc.link(getPageName(),field));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.link(getPageName(),field));
        BrowserGlobal.iWaitUntilElementEnabled(patternLoc.link(getPageName(),field));
        BrowserGlobal.iDoubleClickOn(patternLoc.link(getPageName(),field));
    }

    /**
     *
     * @param waitTime [Time to Wait]
     *
     */
    @QAFTestStep(description = "Web: I wait for {0} Secs")
    public static void waitInSecs(String waitTime) throws Exception {
        BrowserGlobal.iWaitForSeconds(waitTime);
    }
    /**
     *
     *
     */
    @QAFTestStep(description = "Web: And I take screeshot")
    public static void takeScreenShot() throws Exception {
        BrowserGlobal.iTakeScreenshot();
    }
    /**
     *
     * @param waitTime [Wait time in Milli Secs]
     *
     */
    @QAFTestStep(description = "I wait for {0} MilliSecs")
    public static void waitInMilliSecs(String waitTime) throws Exception {
        BrowserGlobal.iWaitForMilliseconds(waitTime);
    }
    /**
     *
     * @param frame- [Frame Name]
     *
     */
    @QAFTestStep(description="Web: Moving into the frame {0}")
    public static void moveToFrame(String frame) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iSwitchToIFrameByIdOrName(frame);
    }
    /**
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Move to Subheader {0}")
    public static void clickSubHeader(String field) throws Exception {
        BrowserGlobal.iScrollToAnElement(patternLoc.subHeader(getPageName(),field));
        BrowserGlobal.iWaitUntilElementVisible(patternLoc.subHeader(getPageName(),field));
        BrowserGlobal.iWaitUntilElementEnabled(patternLoc.subHeader(getPageName(),field));
        BrowserGlobal.iClickOn(patternLoc.subHeader(getPageName(),field));
    }

    /**
     *
     * @param field [Field name]
     */
    @QAFTestStep(description = "Web: Click select field with value Value:{1}")
    public static void clickSelect(String field) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(patternLoc.select(getPageName(),field));
        BrowserGlobal.iScrollToAnElement(patternLoc.select(getPageName(),field));
        BrowserGlobal.iClickOn(patternLoc.select(getPageName(),field));
    }

//    /**
//     * @param field [Field name]
//     */
//    @QAFTestStep(description = "Click Graph link {0}")
//    public static void clickGraphLink(String field) throws Exception {
//// BrowserGlobal.iScrollToAnElement(patternLoc.link(getPageName(),field));
//        BrowserGlobal.iWaitUntilElementPresent(patternLoc.graphlink(getPageName(),field));
//        BrowserGlobal.iWaitUntilElementEnabled(patternLoc.graphlink(getPageName(),field));
//        BrowserGlobal.iClickOn(patternLoc.graphlink(getPageName(),field));
//    }

    /**
     *
     * @return [Page Name]
     */
    private static String getPageName() {
        return getBundle().getProperty("auto.page.name").toString();
    }
}