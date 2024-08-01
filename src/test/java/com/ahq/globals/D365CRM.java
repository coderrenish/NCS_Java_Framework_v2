package com.ahq.globals;

import com.ahq.addons.d365Loc;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.ahq.addons.loc;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;


import java.util.Objects;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class D365CRM {
    static String d365Global_input_text_select_all_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.text.select_all.wait"),"d365Global.input.text.select_all.wait") && !getBundle().getPropertyValue("d365Global.input.text.select_all.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.text.select_all.wait") : "2000";
    static String d365Global_input_date_double_click_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.date.double_click.wait"),"d365Global.input.date.double_click.wait") && !getBundle().getPropertyValue("d365Global.input.date.double_click.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.date.double_click.wait") : "2000";
    static String d365Global_input_date_select_all_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.date.select_all.wait"),"d365Global.input.date.select_all.wait") && !getBundle().getPropertyValue("d365Global.input.date.select_all.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.date.select_all.wait") : "2000";
    static String d365Global_input_date_fill_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.date.fill.wait"),"d365Global.input.date.fill.wait") && !getBundle().getPropertyValue("d365Global.input.date.fill.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.date.fill.wait") : "2000";
    static String d365Global_input_lookup_select_type = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.type"),"d365Global.input.lookup.select.type") && !getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().isEmpty() && (Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().toLowerCase(),"click") || Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().toLowerCase(),"keys")))? getBundle().getPropertyValue("d365Global.input.lookup.select.type").trim().toLowerCase() : "click";
    static String d365Global_input_lookup_load_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.load.wait"),"d365Global.input.lookup.load.wait") && !getBundle().getPropertyValue("d365Global.input.lookup.load.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.lookup.load.wait") : "2000";
    static String d365Global_input_lookup_select_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.select.wait"),"d365Global.input.lookup.select.wait") && !getBundle().getPropertyValue("d365Global.input.lookup.select.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.lookup.select.wait") : "2000";
    static String d365Global_input_lookup_clear_wait = (!Objects.equals(getBundle().getPropertyValue("d365Global.input.lookup.clear.wait"),"d365Global.input.lookup.clear.wait") && !getBundle().getPropertyValue("d365Global.input.lookup.clear.wait").trim().isEmpty())? getBundle().getPropertyValue("d365Global.input.lookup.clear.wait") : "2000";

    /**
     * @param text [text to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
//    @Given(D365CRM Input Text:\"{string}\" Field:\"{string}\" Page:\"{string}\"")
    @And("D365CRM: Input Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Input Text:{0} Field:{1} Page:{2}")
    public static void inputText_D365CRM(String text,String field,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);
        String locName = d365Loc.inputText(pageName,fieldLoc,fieldName);
        waitFieldToBePresentScrollVisibleAndEnabled(locName);
        BrowserGlobal.iClickOn(locName);
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(text,locName);
    }

    /**
     * @param date [Date to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Input-Date Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Input-Date Text:{0} Field:{1} Page:{2}")
    public static void inputDate_D365CRM(String date,String field,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);
        String locName = d365Loc.inputDate(pageName,fieldLoc,fieldName);
        waitFieldToBePresentScrollVisibleAndEnabled(locName);
        BrowserGlobal.iClickOn(locName);
        BrowserGlobal.iWaitForMilliseconds("500");
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_double_click_wait);
        BrowserGlobal.iClickOn(locName);
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_date_fill_wait);
        BrowserGlobal.iInputInTo(date,locName);
    }

    /**
     * @param time [time to fill]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Input-Time Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Input-Time Text:{0} Field:{1} Page:{2}")
    public static void inputTime_d365Crm(String time,String field,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);
        String locName = d365Loc.inputTime(pageName,fieldLoc,fieldName);
        waitFieldToBePresentScrollVisibleAndEnabled(locName);

        BrowserGlobal.iClickOn(locName);
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_text_select_all_wait);
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iInputInTo(time,locName);
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Input-Lookup Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Input-Lookup Text:{0} Field:{1} Page:{2}")
    public static void inputLookUp_D365CRM(String text, String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);
        String locName = d365Loc.inputLookup(pageName,fieldLoc,fieldName);
        String LocName2 = d365Loc.link(page,"DROPDOWN_LIST",text);
        waitFieldToBePresentScrollVisibleAndEnabled(locName);

        BrowserGlobal.iClickOn(locName);
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(text, locName);
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
        BrowserGlobal.iWaitUntilElementPresent(LocName2);
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iClickOn(LocName2);
        } else {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iPressReturnOrEnterKey();
        }
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
    }

    /**
     * @param text [text to be entered in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Input-Lookup-If-Empty Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Input-Lookup-If-Empty Text:{0} Field:{1} Page:{2}")
    public static void inputLookUpIfEmpty_D365CRM(String text, String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);
//        Boolean fieldPresent = false;
//        int defaultTimeout = getBundle().getInt("selenium.wait.timeout");
//        try {
//            BrowserGlobal.iVerifyElementPresent(d365Loc.inputLookup(pageName,fieldLoc,fieldName));
//            fieldPresent = true;
//        } catch (Exception e) {
//            fieldPresent = false;
//        }
        if ( BrowserGlobal.isElementVisibleWithTimeout(d365Loc.inputLookup(pageName,fieldLoc,fieldName), "3000")) {
            BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookup(pageName,fieldLoc,fieldName));
            BrowserGlobal.iScrollToAnElement(d365Loc.inputLookup(pageName,fieldLoc,fieldName));
            BrowserGlobal.iClickOn(d365Loc.inputLookup(pageName,fieldLoc,fieldName));
            BrowserGlobal.iWaitForMilliseconds("500");
            BrowserGlobal.iPressControlOrCommandAByOs();
            BrowserGlobal.iWaitForMilliseconds("500");
            BrowserGlobal.iInputInTo(text, d365Loc.inputLookup(pageName,fieldLoc,fieldName));
            BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
            BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(page,"DROPDOWN_LIST",text));
            if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
                BrowserGlobal.iClickOn(d365Loc.link(page,"DROPDOWN_LIST",text));
            } else {
                BrowserGlobal.iPressKey("ARROW_DOWN");
                BrowserGlobal.iWaitForMilliseconds("1000");
                BrowserGlobal.iPressReturnOrEnterKey();
            }
            BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
        }
    }
//    /**
//     * Clearing Existing value by name in Lookup ad then enter
//     * Note: Should know existing value
//     * @param text [text to be entered in lookup]
//     * @param clear_value [Existing Value to clear in lookup]
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "MsDynamicsGlobal: Input-Lookup Text:{0} By-Clearing-Value:{1} Field:{2} Page:{3}")
//    public static void inputLookUpByClearingValue(String text, String clear_value, String field, String page) throws Exception {
////        String splitFields[];
////        String delField = field.replace(", Lookup","");
////        if (field.contains(":")) {
////            splitFields = field.split(":");
////            delField = clear_value.replace(", Lookup","");
////        }
////        clear_value = clear_value.replace(", Lookup","");
//        if (!field.contains(", Lookup")) { field = field +", Lookup"; }
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"lookup",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"lookup",field));
//        BrowserGlobal.iClickOn("xpath=(//*[@title='"+clear_value+"'])[2]");
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_clear_wait);
//        BrowserGlobal.iClickOn(loc.get(page,"d365_lookup","Delete"));
//        BrowserGlobal.iWaitForMilliseconds("500");
//        BrowserGlobal.iPressControlOrCommandAByOs();
//        BrowserGlobal.iWaitForMilliseconds("500");
//        BrowserGlobal.iInputInTo(text, loc.get(page,"d365_lookup",field));
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_link",text));
//        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
//            BrowserGlobal.iClickOn(loc.get(page,"text",text));
//        } else {
//            BrowserGlobal.iPressKey("ARROW_DOWN");
//            BrowserGlobal.iWaitForMilliseconds("1000");
//            BrowserGlobal.iPressReturnOrEnterKey();
//        }
//        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
//    }

    /**
     * Clearing Existing value by name in Lookup ad then enter
     * Note: Should know existing value
     * @param text [text to be entered in lookup]
     * @param clear_value [Existing Value to clear in lookup]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Input-Lookup Text:{string} By-Clearing-Value:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Input-Lookup Text:{0} By-Clearing-Value:{1} Field:{2} Page:{3}")
    public static void inputLookUpByClearingValue_D365CRM(String text, String clear_value, String field, String page) throws Exception {
        String splitFields[];
        String delField = field.replace(", Lookup","");
        if (field.contains(":")) {
            splitFields = field.split(":");
            delField = splitFields[0].replace(", Lookup","");
        }
        if (!field.contains(", Lookup")) { field = field +", Lookup"; }
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookup(page,"main",field));
//        BrowserGlobal.iScrollToAnElement(d365Loc.inputLookup(page,"main",field));
//        BrowserGlobal.iClickOn("xpath=(//*[@title='"+delField+"'])[2]");

        BrowserGlobal.iMouseoverOn(d365Loc.link(page,"main",clear_value));
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(page,"main","Delete "+clear_value));
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"main","Delete "+clear_value));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_clear_wait);
        BrowserGlobal.iClickOn(d365Loc.button(page,"main","Delete "+clear_value));
//        BrowserGlobal.iClickOn(loc.get(page,"input","Delete"));
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressControlOrCommandAByOs();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iInputInTo(text, d365Loc.inputLookup(page,"main",field));
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_load_wait);
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookup(page,"main",field));
        if (d365Global_input_lookup_select_type.equalsIgnoreCase("click")) {
            BrowserGlobal.iClickOn(d365Loc.inputLookup(page,"main",field));
        } else {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iPressReturnOrEnterKey();
        }
        BrowserGlobal.iWaitForMilliseconds(d365Global_input_lookup_select_wait);
    }

//    /**
//     * @param keyword [Keyword to fill]
//     * @param instance [Instance of Keyword field]
//     */
//    @QAFTestStep(description = "MsDynamicsGlobal: Input-Filter-Keyword Text:{0} Instance:{1}")
//    public static void inputFilterKeyword(String keyword, String instance) throws Exception {
//        String loc = "xpath=(//input[@placeholder='Filter by keyword'])["+instance+"]";
//
//        BrowserGlobal.iWaitUntilElementPresent(loc.get());
//        BrowserGlobal.iScrollToAnElement(loc);
//        BrowserGlobal.iClickOn(loc);
//        BrowserGlobal.iInputInTo(keyword,loc);
//        BrowserGlobal.iPressReturnOrEnterKey();
//    }


//    /**
//     * @param menu_text [Menu Text to be clicked]
//     */
//    @QAFTestStep(description = "D365CRM: Click-Menu Text:{0}")
//    public static void clickMenuWithText(String menu_text) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc("menu","link",menu_text));
//        BrowserGlobal.iScrollToAnElement(d365Loc.loc("menu","link",menu_text));
//        BrowserGlobal.iClickOn(d365Loc.loc("menu","link",menu_text));
//    }
    /**
     * @param field [Button Name]
     * @param page [Page Name]
     */
    @And("D365CRM: Click-Button Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Button Field:{0} Page:{1}")
    public static void clickButton_D365CRM(String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");

        BrowserGlobal.iScrollToAnElement(d365Loc.button(pageName,fieldLoc,field));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(pageName,fieldLoc,field));
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button(pageName,fieldLoc,field));
        BrowserGlobal.iClickOn(d365Loc.button(pageName,fieldLoc,field));
    }

    /**
     * @param field [Button Name]
     * @param page [Page Name]
     */
    @And("D365CRM: Click-Close-Window Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Close-Window Field:{0} Page:{1}")
    public static void clickCloseWindow_D365CRM(String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");

        BrowserGlobal.iScrollToAnElement(d365Loc.button(pageName,fieldLoc,"Close"));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(pageName,fieldLoc,"Close"));
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button(pageName,fieldLoc,"Close"));
        BrowserGlobal.iClickOn(d365Loc.button(pageName,fieldLoc,"Close"));
    }
    /**
     * @param button_text [Button text to be clicked]
     */
    @And("D365CRM: Click-Popup-Button Text:{string}")
    @QAFTestStep(description = "D365CRM: Click-Popup-Button Text:{0}")
    public static void clickPopupButton_D365CRM(String button_text) throws Exception {
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button("popup","POPUP_DIALOG",button_text));
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button("popup","POPUP_DIALOG",button_text));
        BrowserGlobal.iClickOn(d365Loc.button("popup","POPUP_DIALOG",button_text));
    }

//    /**
//     * @param section [Section of the page]
//     * @param page [Page Name]
//     */
//    @QAFTestStep(description = "D365CRM: Click-More-Commands Section:{0} Then-Sub-Menu-Button Text:{1} Page:{2}")
//    public static void clickMoreCommands(String section, String page) throws Exception {
//        String pageName = pageNameCheck(page);
//        String fieldLoc = fieldLocCheck(page,"MAIN");
//
//        BrowserGlobal.iScrollToAnElement(d365Loc.button(pageName,fieldLoc,field));
//        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(pageName,fieldLoc,field));
//        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button(pageName,fieldLoc,field));
//        BrowserGlobal.iClickOn(d365Loc.button(pageName,fieldLoc,field));
//    }

    /**
     * @param tab_text [Tab text/name to be clicked]
     * @param page [Page Name]
     */
    @And("D365CRM: Click-Tab Text:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Tab Text:{0} Page:{1}")
    public static void clickTabWithText_D365CRM(String tab_text, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,tab_text,"MAIN");
//        Boolean tabScroll = false;
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.scrollVerticalTabPanel(page,tab_text));

//        for (int i = 0; i < 3; i++) {
        if (BrowserGlobal.isElementVisibleWithTimeout(d365Loc.tab(pageName, fieldLoc, tab_text), "5000")) {
            BrowserGlobal.iScrollToAnElement(d365Loc.tab(pageName, fieldLoc, tab_text));
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tab(pageName, fieldLoc, tab_text), "5");
            BrowserGlobal.iClickOn(d365Loc.tab(pageName, fieldLoc, tab_text));
//            tabScroll = true;
        } else if (BrowserGlobal.isElementVisibleWithTimeout(d365Loc.tab(pageName, fieldLoc, "More Tabs"), "3000")) {
            BrowserGlobal.iScrollToAnElement(d365Loc.tab(pageName, fieldLoc, "More Tabs"));
            BrowserGlobal.iClickOn(d365Loc.tab(pageName, fieldLoc, "More Tabs"));
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.link(pageName, "DROPDOWN_TAB", tab_text), "5");
            BrowserGlobal.iScrollToAnElement(d365Loc.link(pageName, "DROPDOWN_TAB", tab_text));
            BrowserGlobal.iClickOn(d365Loc.link(pageName, "DROPDOWN_TAB", tab_text));
//            tabScroll = true;
//        } else if (BrowserGlobal.isElementVisibleWithTimeout(d365Loc.tab(pageName, fieldLoc, "Related"), "3")) {
        } else {
            BrowserGlobal.iScrollToAnElement(d365Loc.tab(pageName, fieldLoc, "Related"));
            BrowserGlobal.iClickOn(d365Loc.tab(pageName, fieldLoc, "Related"));
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.link(pageName, "DROPDOWN_TAB", tab_text), "5");
            BrowserGlobal.iScrollToAnElement(d365Loc.link(pageName, "DROPDOWN_TAB", tab_text));
            BrowserGlobal.iClickOn(d365Loc.link(pageName, "DROPDOWN_TAB", tab_text));
        }
//        }
        if ( BrowserGlobal.isElementVisibleWithTimeout(d365Loc.scrollVerticalTabPanel(page, tab_text), "3000")) {
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("3000",d365Loc.scrollVerticalTabPanel(page, tab_text));
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("2000",d365Loc.scrollVerticalTabPanel(page, tab_text));
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("-5000",d365Loc.scrollVerticalTabPanel(page, tab_text));
        }

//        if (tabScroll) {
//            BrowserGlobal.iWaitForPageToLoad();
//            BrowserGlobal.iWaitUntilElementVisible(d365Loc.scrollVerticalTabPanel(page,tab_text));
//            BrowserGlobal.iMouseoverOn(d365Loc.scrollVerticalTabPanel(page,tab_text));
//            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("2000",d365Loc.scrollVerticalTabPanel(page,tab_text));
//            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("-2000",d365Loc.scrollVerticalTabPanel(page,tab_text));
//        }

    }

    /**
     * @param link_text [Link text to be clicked]
     */
    @And("D365CRM: Click-Link Text:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Link Text:{0} Page:{1}")
    public static void clickLinkWithText_D365CRM(String link_text,String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(page,"main",link_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.link(page,"main",link_text));
        BrowserGlobal.iClickOn(d365Loc.link(page,"main",link_text));
    }

    /**
     * @param field [Field name]
     * @param page [Page name]
     * Note: It will work only for 1 record selection lookup
     */
    @And("D365CRM: Click-Lookup-Record-Link Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Lookup-Record-Link Field:{0} Page:{1}")
    public static void clickLookupRecordLink_D365CRM(String field,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(pageName,fieldLoc,fieldName+", Lookup"));
        BrowserGlobal.iScrollToAnElement(d365Loc.link(pageName,fieldLoc,fieldName+", Lookup"));
        BrowserGlobal.iClickOn(d365Loc.link(pageName,fieldLoc,fieldName+", Lookup"));
    }

    /**
     * @param link_text [Link text to be clicked]
     */
    @And("D365CRM: Click-Left-Menu Text:{string}")
    @QAFTestStep(description = "D365CRM: Click-Left-Menu Text:{0}")
    public static void clickLeftMenu_D365CRM(String link_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link("menu","NAV_LEFT",link_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.link("menu","NAV_LEFT",link_text));
        BrowserGlobal.iClickOn(d365Loc.link("menu","NAV_LEFT",link_text));
    }

    /**
     * @param mainMenu_text [Main Menu Text/name to be clicked]
     * @param subMenu_text [Sub Menu Text/name to be clicked]
     */
    @And("D365CRM: Click-Left-Menu Text:{string} Then-Sub-Menu Text:{string}")
    @QAFTestStep(description = "D365CRM: Click-Left-Menu Text:{0} Then-Sub-Menu Text:{1}")
    public static void clickLeftMenuAndSubMenu_D365CRM(String mainMenu_text,String subMenu_text) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link("menu","nav_left",mainMenu_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.link("menu","nav_left",mainMenu_text));
        BrowserGlobal.iClickOn(d365Loc.link("menu","nav_left",mainMenu_text));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.link("menu","nav_left",subMenu_text));
        BrowserGlobal.iClickOn(d365Loc.link("menu","nav_left",subMenu_text));
    }

    /**
     * @param button_text [Button text to be clicked]
     */
    @And("D365CRM: Click-Top-Menu-Button Text:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Top-Menu-Button Text:{0} Page:{1}")
    public static void clickTopMenuButton_D365CRM(String button_text, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"MAIN",button_text));
//        BrowserGlobal.iWaitForMilliseconds("2000");
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button(page,"MAIN",button_text));
        try {
            BrowserGlobal.iClickOn(d365Loc.button(page,"MAIN",button_text));
        } catch (Exception e) {
            BrowserGlobal.iWaitForMilliseconds("5000");
            BrowserGlobal.iClickOn(d365Loc.button(page,"MAIN",button_text));
        }
        waiForLoaderToDisappear_D365CRM(page);
    }

    /**
     * @param main_button_text [Main Button Text/Name]
     * @param sub_button_text [Sub Button Text/Name]
     */
    @And("D365CRM: Click-Top-Menu-Button Text:{string} Then-Sub-Menu-Button Text:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Top-Menu-Button Text:{0} Then-Sub-Menu-Button Text:{1} Page:{2}")
    public static void clickTopMenuButtonAndSubMenuButton_D365CRM(String main_button_text,String sub_button_text, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(page,"MAIN",main_button_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"MAIN",main_button_text));
        BrowserGlobal.iClickOn(d365Loc.button(page,"MAIN",main_button_text));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"DROPDOWN_MENU",sub_button_text));
        BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_MENU",sub_button_text));
        waiForLoaderToDisappear_D365CRM(page);
    }

//    /**
//     * @param main_button_name [Main Menu name]
//     * @param wait_in_secs [Wait in Secs before clicking second Button in dropdown]
//     * @param sub_button_name [Sub Menu name]
//     */
//    @QAFTestStep(description = "D365CRM: Click-Main-Menu-Button Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
//    public static void clickMainAndSubMenuButtonWithWaitInSecs(String main_button_name,String wait_in_secs, String sub_button_name) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iClickOn(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iWaitForSeconds(wait_in_secs);
//        BrowserGlobal.iClickOn(loc.get("menu","button",sub_button_name));
//    }

    /**
     * @param mainView_text [Main System View Text/name to be clicked]
     * @param subView_text [Sub System View Text/name to be clicked]
     *                     [Note: No Section]
     */
    @And("D365CRM: Click-Main-System-View Text:{string} Then-Sub-System-View Text:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Click-Main-System-View Text:{0} Then-Sub-System-View Text:{1} Page:{2}")
    public static void clickMainAndSubSystemView_D365CRM(String mainView_text,String subView_text,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"","MAIN");

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.systemViewOrHeaderTitle(pageName,fieldLoc,mainView_text));
        BrowserGlobal.iScrollToAnElement(d365Loc.systemViewOrHeaderTitle(pageName,fieldLoc,mainView_text));
        BrowserGlobal.iClickOn(d365Loc.systemViewOrHeaderTitle(pageName,fieldLoc,mainView_text));
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link(pageName,"DROPDOWN_SYSTEM_VIEW",subView_text));
        BrowserGlobal.iClickOn(d365Loc.link(pageName,"DROPDOWN_SYSTEM_VIEW",subView_text));
        waiForLoaderToDisappear_D365CRM(page);
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc(page,"SYSTEM_VIEW",mainView_text));
//        BrowserGlobal.iScrollToAnElement(d365Loc.loc(page,"SYSTEM_VIEW",mainView_text));
//        BrowserGlobal.iClickOn(d365Loc.loc(page,"SYSTEM_VIEW",mainView_text));
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.loc(page,"SYSTEM_VIEW_LIST",subView_text));
//        BrowserGlobal.iClickOn(d365Loc.loc(page,"SYSTEM_VIEW_LIST",subView_text));
    }

    /**
     * @param dropdown_Text [Text to be selected in dropdown]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Select Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Select Text:{0} Field:{1} Page:{2}")
    public static void selectByText_D365CRM(String dropdown_Text, String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldName = fieldNameCheck(field);

        if (getD365CrmVersion().equals("v9.2.nl")) {
            BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(pageName,fieldLoc,fieldName));
            BrowserGlobal.iScrollToAnElement(d365Loc.button(pageName,fieldLoc,fieldName));
            BrowserGlobal.iMouseoverOn(d365Loc.button(pageName,fieldLoc,fieldName));
            BrowserGlobal.iClickOn(d365Loc.button(pageName,fieldLoc,fieldName));
            BrowserGlobal.iWaitUntilElementPresent(d365Loc.selectListBox(page,"DROPDOWN_LISTBOX",dropdown_Text));
            BrowserGlobal.iClickOn(d365Loc.selectListBox(page,"DROPDOWN_LISTBOX",dropdown_Text));
        } else {
            BrowserGlobal.iWaitUntilElementPresent(d365Loc.select(pageName,fieldLoc,fieldName));
            BrowserGlobal.iScrollToAnElement(d365Loc.select(pageName,fieldLoc,fieldName));
            BrowserGlobal.iSelectDropdownWithText(d365Loc.select(pageName,fieldLoc,field),dropdown_Text);
        }



//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_select",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_select",field));
//        BrowserGlobal.iSelectDropdownWithText(loc.get(page,"d365_select",field),dropdown_Text);
    }

    /**
     * @param dropdown_Text_Index [String] [Index of the Text to be selected in dropdown starting with 0]
     * @param field [String] [Field name]
     * @param page [String] [Page name]
     */
    @And("D365CRM: Select Index:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Select Index:{0} Field:{1} Page:{2}")
    public static void selectByIndex_D365CRM(String dropdown_Text_Index, String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.select(pageName,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.select(pageName,fieldLoc,field));
        BrowserGlobal.iSelectDropdownWithIndex(d365Loc.select(pageName,fieldLoc,field),dropdown_Text_Index);
    }

    /**
     * @param multiple_dropdown_Text [Multiple value separated by comma]
     * @param field [Field name]
     * @param page [Page name]
     */
    @And("D365CRM: Select-Multiple Text:{string} Field:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Select-Multiple Text:{0} Field:{1} Page:{2}")
    public static void selectMultipleByText_D365CRM(String multiple_dropdown_Text, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"select",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"select",field));
        BrowserGlobal.iClickOn(loc.get(page,"select",field));
        BrowserGlobal.iWaitForMilliseconds("1000");
        BrowserGlobal.iClickOn("xpath=//button[@aria-label='Toggle menu']");
        BrowserGlobal.iWaitForMilliseconds("1000");
        String[] dropdownText = multiple_dropdown_Text.split(",");
        for (String selected_text : dropdownText) {
            BrowserGlobal.iClickOn("xpath=//label[@title='"+selected_text+"']");
            BrowserGlobal.iWaitForMilliseconds("500");
        }
        BrowserGlobal.iClickOn("xpath=//button[@aria-label='Toggle menu']");
    }

    // ============= TABLE / GRID ==============
    /**
     * @param text [Keyword / Search text to fill]
     */
    @And("D365CRM: Table-Input-Filter Text:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Table-Input-Filter Text:{0} Page:{1}")
    public static void tableInputFilter_D365CRM(String text, String page) throws Exception {
        String[] tempFieldVal = fieldValueCheck(text);
        text = tempFieldVal[0];
        String instance = (tempFieldVal[1].isEmpty()) ? "::1" : tempFieldVal[1];
        String filterFieldName = "Filter by keyword";
        if (getD365CrmVersion().equals("v9.1")) { filterFieldName = "Search this view"; }

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputText(page,"MAIN",filterFieldName+instance));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputText(page,"MAIN",filterFieldName+instance));
        BrowserGlobal.iClickOn(d365Loc.inputText(page,"MAIN",filterFieldName+instance));
        BrowserGlobal.iInputInTo(text,d365Loc.inputText(page,"MAIN",filterFieldName+instance));
        BrowserGlobal.iPressReturnOrEnterKey();
        BrowserGlobal.iWaitForMilliseconds("1000");
        BrowserGlobal.iWaitForPageToLoad();
    }

//    /**
//     * Note: To be used if multiple Tables are in single page
//     * @param text [Keyword / Search text to fill]
//     * @param instance [Instance of Keyword field]
//     */
//    @QAFTestStep(description = "D365CRM: Table-Input-Filter Text:{0} By-Instance:{1} Page:{2}")
//    public static void tableInputFilterByInstance(String text, String instance, String page) throws Exception {
////        String loc = "xpath=(//input[@placeholder='Filter by keyword'])["+instance+"]";
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iClickOn(loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iInputInTo(text,loc.get(page,"d365_filter",instance));
//        BrowserGlobal.iPressReturnOrEnterKey();
//    }

    /**
     * Note: To be used if multiple Tables are in single page
     * @param filters [Following parameters: ['Field','Opertor','Value/s'] Eg: ['Allow ECard','Equals','No,Yes'],['Year','Contains data','']"
     * @param page [Page name]
     */
    @And("D365CRM: Table-Edit-Filter-Delete-All-And-Input-New filters:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Table-Edit-Filter-Delete-All-And-Input-New filters:{0} Page:{1}")
    public static void tableEditFilterDeleteAllAndInputNew_D365CRM(String filters, String page) throws Exception {
        String editFilterButtonName = "Edit filters";
        switch (getD365CrmVersion()) {
            case ("v9.1"): { editFilterButtonName = "Open advanced filtering panel";
                BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"MAIN","Open advanced filtering panel"));
                BrowserGlobal.iClickOn(d365Loc.button(page,"MAIN","Open advanced filtering panel"));
                BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"TABLE_EDIT_FILTER","Apply"));
                for (int i = 0; i < 50; i++) {
                    if (BrowserGlobal.isElementCurrentlyVisible(d365Loc.button(page,"TABLE_EDIT_FILTER","More commands::1"))){
                        BrowserGlobal.iClickOn(d365Loc.button(page,"TABLE_EDIT_FILTER","More commands::1"));
                        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU","Delete"));
                        BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU","Delete"));
                        BrowserGlobal.iWaitForSeconds("1");
                    } else {
                        break;
                    }
                }
                break;}
            default: {
                BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"MAIN","Edit filters"));
                BrowserGlobal.iClickOn(d365Loc.button(page,"MAIN","Edit filters"));
                BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"TABLE_EDIT_FILTER","Apply"));
                BrowserGlobal.iClickOn(d365Loc.button(page,"TABLE_EDIT_FILTER","Delete all filters"));
                break;
            }
        }

        String[] filterArray = filters.split("],\\[");
        int filterCount = 0;
        for ( String filter : filterArray )
        {
            filterCount = filterCount + 1;

            BrowserGlobal.iClickOn(d365Loc.button(page,"TABLE_EDIT_FILTER","Add"));
            BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU","Add row"));
            BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU","Add row"));
            int counter = 0;
            String[] rowFilter = filter.replace("[","").replace("]","").split("','");
            for (String singleFilter : rowFilter)
            {
                counter = counter + 1;
                singleFilter = singleFilter.replace("'","").trim();
                if (counter == 1) {
                    BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"TABLE_EDIT_FILTER","field selector::"+filterCount));
                    BrowserGlobal.iClickOn(d365Loc.button(page,"TABLE_EDIT_FILTER","field selector::"+filterCount));
                    BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU",singleFilter));
                    BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU",singleFilter));

                } else if (counter == 2) {
                    if (!singleFilter.isEmpty()) {
                        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"TABLE_EDIT_FILTER","Operator::"+filterCount));
                        BrowserGlobal.iClickOn(d365Loc.button(page,"TABLE_EDIT_FILTER","Operator::"+filterCount));
                        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU",singleFilter));
                        BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU",singleFilter));
                    }
                } else if (counter == 3) {
                    if (!singleFilter.isEmpty()) {
                        String[] valueFilters = singleFilter.replace("'","").split(",");
                        for (String valFilter : valueFilters)
                        {
                            BrowserGlobal.iClickOn(d365Loc.inputText(page,"TABLE_EDIT_FILTER","Value::"+filterCount));
                            if (BrowserGlobal.isElementVisibleWithTimeout(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU",valFilter),"2000")) {
                                BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_EDIT_FILTER_MENU",valFilter));
                            } else {
                                BrowserGlobal.iInputInTo(valFilter,d365Loc.inputText(page,"TABLE_EDIT_FILTER","Value::"+filterCount));
                            }
                        }
                    }
                }
            }
        }
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"TABLE_EDIT_FILTER","Apply"));
        BrowserGlobal.iClickOn(d365Loc.button(page,"TABLE_EDIT_FILTER","Apply"));

    }

    /**
     * To reset Table Filters
     * @param page [Page name]
     */
    @And("D365CRM: Table-Edit-Filter-Reset-To-Default Page:{string}")
    @QAFTestStep(description = "D365CRM: Table-Edit-Filter-Reset-To-Default Page:{0}")
    public static void tableEditFilterResetToDefault_D365CRM(String page) throws Exception {
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"BUTTON","Edit filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"BUTTON","Edit filters"));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Clear filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Clear filters"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Apply the current advanced filters"));
        BrowserGlobal.iClickOn(d365Loc.loc(page,"TABLE_EDIT_FILTER_PANEL_BUTTON","Apply the current advanced filters"));
    }

    /**
     * Note: To be used if multiple Tables are in single page.
     * This will select particular table to do other operations
     * @param instance [Instance of Table to be selected]
     */
    @And("D365CRM: Table-Select By-Instance:{string} Page:{string}")
    @QAFTestStep(description = "D365CRM: Table-Select By-Instance:{0} Page:{1}")
    public static void tableSelectByInstance_D365CRM(String instance, String page) throws Exception {
        try {
            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.button(page,"main","More commands for::"+instance),"3");
//            BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.loc(page,"TABLE_OVERFLOW_MENU_INSTANCE",instance),"3");
        } catch (Exception e) {
            int scrollLength = 250;
            for (int i = 0; i < 10; i++) {
                BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField(Integer.toString(scrollLength), d365Loc.button(page,"main","More commands for::1"));
//                BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField(Integer.toString(scrollLength), d365Loc.loc(page,"TABLE_OVERFLOW_MENU_INSTANCE","1"));
                BrowserGlobal.iWaitForSeconds("1");
                try {
                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.button(page,"main","More commands for::"+instance),"2");
//                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.loc(page,"TABLE_OVERFLOW_MENU_INSTANCE",instance),"2");
                    break;
                } catch(Exception e2) { scrollLength = scrollLength + 250; }

            }
        }
        BrowserGlobal.iScrollToAnElement(d365Loc.button(page,"main","More commands for::"+instance));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"main","More commands for::"+instance));
        BrowserGlobal.iClickOn(d365Loc.button(page,"main","More commands for::"+instance));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.button(page,"DROPDOWN_MENU","See all records"));
        BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_MENU","See all records"));
    }

    /**
     *
     * @param header_column_text [header column number of the Table to be clicked]
     * @param header_column_number [header column number of the Table to be clicked]
     * @param dropdown_text [dropdown /button text  to be clicked]
     * @param page [Page name]
     *
     */
    @QAFTestStep(description = "D365CRM: Table-Click-Header Text:{0} Column:{1} Then-Click-Dropdown-Button Text:{2} Page:{3}")
    @And("D365CRM: Table-Click-Header Text:{string} Column:{string} Then-Click-Dropdown-Button Text:{string} Page:{string}")
    public static void tableClickHeaderColumnThenClickDropdownButton_D365CRM(String header_column_text,String header_column_number,String dropdown_text, String page) throws Exception {
        int tempColNum = Integer.parseInt(header_column_number) + 1;
        tableHeaderScrollRight( tempColNum, page);
        BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableHeader(page,"TABLE",header_column_text+"::none::"+tempColNum),"2");
        BrowserGlobal.iClickOn(d365Loc.tableHeader(page,"main",header_column_text+"::none::"+tempColNum));
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(page,"DROPDOWN_TABLE_COLUMN",dropdown_text));
        BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_COLUMN",dropdown_text));
        tableHeaderScrollLeft(tempColNum);
//
//        int colNum = Integer.parseInt(header_column_number) + 1;
//        String tempLoc = d365Loc.scrollHorizontal(page);
//        boolean scrollStatus = false;
//        for (int i = 0; i < 10; i++) {
//            try {
//                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableHeader(page,"OTHER",header_column_text+":: ::"+colNum),"2");
////                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum),"2");
//                break;
//            } catch (Exception e) {
//                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
//                scrollStatus = true;
////                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",loc.get(page,"d365_table_horizontal_scroll","scrollHorizontal"));
//            }
//        }
//        BrowserGlobal.iClickOn(d365Loc.tableHeader(page,"main",header_column_text+":: ::"+colNum));
//        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(page,"DROPDOWN_TABLE_COLUMN",dropdown_text));
//        BrowserGlobal.iClickOn(d365Loc.button(page,"DROPDOWN_TABLE_COLUMN",dropdown_text));
//        if (scrollStatus) {
//            BrowserGlobal.iScrollHorizontalUsingScrollLocator("-500",d365Loc.scrollHorizontal(page));
//        }
    }

    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Double-Click-Table-Cell Row:{0} Column:{1} Page:{2}")
    @And("D365CRM: Double-Click-Table-Cell Row:{string} Column:{string} Page:{string}")
    public static void doubleClickTableCell_D365CRM(String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;

        tableScrollDown(tempRowNum, page);
        tableScrollRight(tempRowNum, tempColNum, page);
        BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),"2");
        BrowserGlobal.iDoubleClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum));
    }

    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Table-Row-Select Row:{0} Page:{1}")
    public static void tableRowSelect_D365CRM(String row_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::1"));
    }

    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Table-Row-Deselect Row:{0} Page:{1}")
    public static void tableRowDeSelect_D365CRM(String row_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::1"));
    }
    /**
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Table-All-Row-Select Page:{0}")
    public static void tableAllRowSelect_D365CRM(String page) throws Exception {
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::1::1"));
    }

    /**
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Table-All-Row-Deselect Page:{0}")
    public static void tableAllRowDeselect_D365CRM(String page) throws Exception {
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::1::1"));
    }
    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Click-Table-Cell Row:{0} Column:{1} Page:{2}")
    public static void clickTableCell_D365CRM(String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;

        tableScrollDown(tempRowNum, page);
        tableScrollRight(tempRowNum, tempColNum, page);
        BrowserGlobal.iWaitUntilElementPresentWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),"5");
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum));

    }

    //    /**
//     * @param main_button_name [Main Menu name]
//     * @param wait_in_secs [Wait in Secs before clicking second Button in dropdown]
//     * @param sub_button_name [Sub Menu name]
//     */
//    @QAFTestStep(description = "MsDynamicsGlobal: Click-Table-Row Text:{0} Wait-In Secs:{1} Sub-Menu-Button Text:{1} ")
//    public static void clickMainAndSubMenuButtonWithWaitInSecs(String main_button_name,String wait_in_secs, String sub_button_name) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iScrollToAnElement(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iClickOn(loc.get("menu","button",main_button_name));
//        BrowserGlobal.iWaitForSeconds(wait_in_secs);
//        BrowserGlobal.iClickOn(loc.get("menu","button",sub_button_name));
//    }

    // ============= WAIT ==============
    /**
     * @param tab_text [Header text to be verified]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Wait-For-New-Tab-To-Be-Present Text:{0} Page:{1}")
    @And("D365CRM: Wait-For-New-Tab-To-Be-Present Text:{string} Page:{string}")
    public static void waitForNewTabToBePresent_D365CRM(String tab_text,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,tab_text,"MAIN");
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.tab(pageName, fieldLoc, tab_text));
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.tab(pageName, fieldLoc, tab_text));
    }

    /**
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Wait-For-Loader-To-Disappear Page:{0}")
    @And("D365CRM: Wait-For-Loader-To-Disappear Page:{string}")
    public static void waiForLoaderToDisappear_D365CRM(String page) throws Exception {
        String pageName = pageNameCheck(page);
        if (BrowserGlobal.isElementVisibleWithTimeout(d365Loc.loader(pageName, "MAIN"),"3000")){
            BrowserGlobal.iWaitUntilElementNotPresent(d365Loc.loader(pageName, "MAIN"));
        }

    }


    // ============= VERIFY ==============
    /**
     * @param header_text [Header text to be verified]
     * @param page [Page name]
     */

    @QAFTestStep(description = "D365CRM: Wait-And-Verify-Page-Header Text:{0} Page:{1}")
    @And("D365CRM: Wait-And-Verify-Page-Header Text:{string} Page:{string}")
    public static void waitAndVerifyPageHeader_D365CRM(String header_text,String page) throws Exception {
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.systemViewOrHeaderTitle(page,"MAIN", header_text));
        BrowserGlobal.iAssertElementPresent(d365Loc.systemViewOrHeaderTitle(page,"MAIN", header_text));
//        BrowserGlobal.iWaitUntilElementVisible(d365Loc.loc(page,"HEADER",header_text));
//        BrowserGlobal.iAssertElementPresent(d365Loc.loc(page,"HEADER",header_text));
        BrowserGlobal.iAssertTitlePartialText(header_text);
        if ( BrowserGlobal.isElementVisibleWithTimeout(d365Loc.scrollVerticalUsingSubHeader(page,"MAIN", ""), "3000")) {
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("3000",d365Loc.scrollVerticalUsingSubHeader(page,"MAIN", ""));
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("2000",d365Loc.scrollVerticalUsingSubHeader(page,"MAIN", ""));
            BrowserGlobal.iWaitForMilliseconds("1000");
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("-5000",d365Loc.scrollVerticalUsingSubHeader(page,"MAIN", ""));
        } else {
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("5000",d365Loc.scrollVertical(page));
            BrowserGlobal.iWaitForMilliseconds("500");
            BrowserGlobal.iScrollUsingMouseWheelByValueFromVisibleField("-5000",d365Loc.scrollVertical(page));
        }

    }

    /**
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-field-locked Field:{0} Page:{1}")
    @And("D365CRM: Verify-field-locked Field:{string} Page:{string}")
    public static void verifyFieldLocked_D365CRM(String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.fieldLock(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.fieldLock(page,fieldLoc,field));
        BrowserGlobal.iAssertElementVisible(d365Loc.fieldLock(page,fieldLoc,field));
    }

    /**
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-field-mandatory Field:{0} Page:{1}")
    @And("D365CRM: Verify-field-mandatory Field:{string} Page:{string}")
    public static void verifyFieldMandatory_D365CRM(String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.fieldMandatory(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.fieldMandatory(page,fieldLoc,field));
        BrowserGlobal.iAssertElementVisible(d365Loc.fieldMandatory(page,fieldLoc,field));
    }

    /**
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-field-secured Field:{0} Page:{1}")
    @And("D365CRM: Verify-field-secured Field:{string} Page:{string}")
    public static void verifyFieldSecured_D365CRM(String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.fieldSecured(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.fieldSecured(page,fieldLoc,field));
        BrowserGlobal.iAssertElementVisible(d365Loc.fieldSecured(page,fieldLoc,field));
    }

    /**
     * @param text [text to verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Input-Value Text:{0} Field:{1} Page:{2}")
    @And("D365CRM: Verify-Input-Value Text:{string} Field:{string} Page:{string}")
    public static void verifyInputValue_D365CRM(String text,String field,String page) throws Exception {
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String pageName = pageNameCheck(page);
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputText(pageName,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputText(pageName,fieldLoc,field));
        BrowserGlobal.iAssertElementValue(d365Loc.inputText(pageName,fieldLoc,field),text);

    }
//
//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365CRM: Verify-Input-Disabled Field:{0} Page:{1}")
//    public static void verifyInputDisabled(String field,String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_input",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_input",field));
//        BrowserGlobal.iMouseoverOn(loc.get(page,"d365_input",field));
//        BrowserGlobal.iWaitForSeconds("1");
//        BrowserGlobal.iClickOn(loc.get(page,"d365_input",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_input",field),"readonly");
//    }

    /**
     * @param date [Date to Verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Input-Date Text:{0} Field:{1} Page:{2}")
    @And("D365CRM: Verify-Input-Date Text:{string} Field:{string} Page:{string}")
    public static void verifyInputDate_D365CRM(String date,String field,String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputDate(pageName,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputDate(pageName,fieldLoc,field));
        BrowserGlobal.iAssertElementValue(d365Loc.inputDate(pageName,fieldLoc,field),date);
    }


//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365CRM: Verify-Input-Date-Disabled Field:{0} Page:{1}")
//    public static void verifyInputDateDisabled(String field,String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_date",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_date",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_date",field),"disabled");
//    }

    /**
     * @param time [Time to Verify]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Input-Time Text:{0} Field:{1} Page:{2}")
    @And("D365CRM: Verify-Input-Time Text:{string} Field:{string} Page:{string}")
    public static void verifyInputTime_D365CRM(String time,String field,String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputTime(page,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputTime(page,fieldLoc,field));
        BrowserGlobal.iAssertElementValue(d365Loc.inputTime(page,fieldLoc,field),time);
    }

//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365CRM: Verify-Input-Time-Disabled Text:{0} Field:{1} Page:{2}")
//    public static void verifyInputTimeDisabled(String field,String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_time",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_time",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_time",field),"disabled");
//    }

    /**
     * @param lookup_text [Lookup text to be verified]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Input-Lookup Text:{0} Field:{1} Page:{2}")
    @And("D365CRM: Verify-Input-Lookup Text:{string} Field:{string} Page:{string}")
    public static void verifyInputLookUp_D365CRM(String lookup_text, String field, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldDetails = field.contains("::") ? field.trim() + "::"+ lookup_text : field.trim() + ":: ::"+ lookup_text;
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.inputLookupValue(page,fieldLoc,fieldDetails));
        BrowserGlobal.iScrollToAnElement(d365Loc.inputLookupValue(page,fieldLoc,fieldDetails));
        BrowserGlobal.iAssertElementText(d365Loc.inputLookupValue(page,fieldLoc,fieldDetails),lookup_text);
    }

    /**
     * @param dropdown_Text [Text to be Verified]
     * @param field [Field name]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Select Text:{0} Field:{1} Page:{2}")
    @And("D365CRM: Verify-Select Text:{string} Field:{string} Page:{string}")
    public static void verifySelectText_D365CRM(String dropdown_Text, String field, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,field,"MAIN");
        String fieldDetails = fieldInstanceCheckAndAddVal_1(field,dropdown_Text);

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.select(pageName,fieldLoc,field));
        BrowserGlobal.iScrollToAnElement(d365Loc.select(pageName,fieldLoc,field));
        BrowserGlobal.iAssertElementPresent(d365Loc.selectValue(pageName,fieldLoc,fieldDetails));
    }

    /**
     * @param header_Text [Header Text to be verified present]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Section-Header-Present Text:{0} Page:{1}")
    @And("D365CRM: Verify-Section-Header-Present Text:{string} Page:{string}")
    public static void verifySectionHeaderPresent_D365CRM(String header_Text, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,header_Text,"MAIN");

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.sectionHeader(pageName,fieldLoc,header_Text));
        BrowserGlobal.iScrollToAnElement(d365Loc.sectionHeader(pageName,fieldLoc,header_Text));
        BrowserGlobal.iAssertElementPresent(d365Loc.sectionHeader(pageName,fieldLoc,header_Text));
    }

//    /**
//     * @param field [Field name]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365CRM: Verify-Select-Disabled Field:{0} Page:{1}")
//    public static void verifySelectDisabled(String field, String page) throws Exception {
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_select",field));
//        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_select",field));
//        BrowserGlobal.iAssertElementAttributePresent(loc.get(page,"d365_select",field),"disabled");
//    }

    /**
     * @param text [Text to be Verified]
     * @param page [Page name]
     */
    @QAFTestStep(description = "D365CRM: Verify-Text:{0} Page:{1}")
    @And("D365CRM: Verify-Text:{string} Page:{string}")
    public static void verifyText_D365CRM(String text, String page) throws Exception {
        page = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,text,"OTHER");
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.text(page,fieldLoc,text));
        BrowserGlobal.iAssertElementPresent(d365Loc.text(page,fieldLoc,text));
    }

//    /**
//     * @param error_Text [error_Text to be Verified]
//     * @param page [Page name]
//     */
//    @QAFTestStep(description = "D365CRM: Verify-Error-Text-Under-Input-Field Error-Text:{0} Field:{1} Page:{2}")
//    public static void verifyErrorTextUnderInputField(String error_Text, String field, String page) throws Exception {
//        BrowserGlobal.iAssertElementPresent("xpath=//input[@aria-label='"+field.trim()+"']/../../../descendant::span[text()='"+error_Text.trim()+"']");
//        // [For Quick Create] //div[contains(@aria-label,'Quick Create:')]/descendant::input[@aria-label='Account Name']/../../../descendant::span[text()='Account Name: Required fields must be filled in.']
//    }



    /**
     * @param header_control_list_text [Header Control List Test (Top Right) to be Verified]
     */
    @QAFTestStep(description = "D365CRM: Verify-Header-Control-List Text:{0} Page:{1}")
    @And("D365CRM: Verify-Header-Control-List Text:{string} Page:{string}")
    public static void verifyHeaderControlList_D365CRM(String header_control_list_text, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,header_control_list_text,"MAIN")+"::HEADER_CONTROL_LIST";
        String fieldName = fieldNameCheck(header_control_list_text);

        BrowserGlobal.iScrollToAnElement(d365Loc.text(pageName,fieldLoc,fieldName));
        BrowserGlobal.iAssertElementPresent(d365Loc.text(pageName,fieldLoc,fieldName));
    }

    /**
     * @param header_text [Header text to be Verified]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Header Text:{0} Column:{1} Page:{2}")
    @And("D365CRM: Verify-Table-Header Text:{string} Column:{string} Page:{string}")
    public static void verifyTableHeaderText_D365CRM(String header_text, String column_number, String page) throws Exception, InterruptedException{
        int tempColNum = Integer.parseInt(column_number) + 1;
        tableHeaderScrollRight(tempColNum, page);
        BrowserGlobal.iAssertElementPresent(d365Loc.tableHeader(page,"NONE",header_text+"::none::"+tempColNum));
        tableHeaderScrollLeft(tempColNum);
    }

    /**
     * @param header_text_all [Header text delimited by comma to be Verified Eg. "Id,Status,Address"]
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Header-All Text:{0} Page:{1}")
    @And("D365CRM: Verify-Table-Header-All Text:{string} Page:{string}")
    public static void verifyTableHeaderAll_D365CRM(String header_text_all, String page) throws Exception {
        String[] splitHeaderNames = header_text_all.split(";");
        int colNum = 1;
//        Below command has visibility issue in v9.1
//        BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::1::1"),"2");
        BrowserGlobal.iDoubleClickOn(d365Loc.tableCell(page,"TABLE","cell::none::1::1"));
        for ( String tableHeaderName : splitHeaderNames ) {
            colNum = colNum + 1;
            BrowserGlobal.iPressKey("ARROW_RIGHT");
            BrowserGlobal.iWaitForMilliseconds("150");
            BrowserGlobal.iAssertElementPresent(d365Loc.tableHeader(page,"NONE",tableHeaderName+"::none::"+colNum));
//            BrowserGlobal.iAssertInnerHtmlIs(d365Loc.tableCellValue(page,"TABLE","cell::none::1::"+colNum),tableHeaderName);
        }
        tableHeaderScrollLeft(colNum);
    }

//    /**
//     *
//     * @param header_column_text [header column number of the Table to be clicked]
//     * @param header_column_number [header column number of the Table to be clicked]
//     * @param dropdown_text [dropdown /button text  to be clicked]
//     * @param page [Page name]
//     *
//     */
//    @QAFTestStep(description = "D365CRM: Verify-Table-Column-Sort Header-Text:{0} Header-Column:{1} Then-Check-Sort-Dropdown-Button Text:{2} Page:{3}")
//    public static void verifyTableColumnSort(String header_column_text,String header_column_number,String dropdown_text, String page) throws Exception {
//        int colNum = Integer.parseInt(header_column_number) + 1;
//        for (int i = 0; i < 10; i++) {
//            try {
//                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum),"3");
//                break;
//            } catch (Exception e) {
//                BrowserGlobal.iScrollHorizontalUsingScrollLocator("50",d365Loc.scrollHorizontal(page));
////                BrowserGlobal.iScrollHorizontalUsingScrollLocator("25",loc.get(page,"d365_table_horizontal_scroll","scrollHorizontal"));
//            }
//        }
//        BrowserGlobal.iClickOn(loc.get(page,"d365_table_header_column",header_column_text+"::"+colNum));
////        BrowserGlobal.iWaitUntilElementPresentWithTimeout(loc.get(page,"d365_table_header_dropdown_sort",dropdown_text),"15");
//        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_table_header_dropdown_sort",dropdown_text));
//
//    }

    /**
     *
     * @param header_column_text [header column number of the Table to be clicked]
     * @param header_column_number [header column number of the Table to be clicked]
     * @param page [Page name]
     *
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Header-Column-Ascending Header-Text:{0} Header-Column:{1} Page:{2}")
    @And("D365CRM: Verify-Table-Header-Column-Ascending Header-Text:{string} Header-Column:{string} Page:{string}")
    public static void verifyTableColumnAscending_D365CRM(String header_column_text,String header_column_number, String page) throws Exception {
        int tempColNum = Integer.parseInt(header_column_number) + 1;
        tableHeaderScrollRight(tempColNum, page);
        BrowserGlobal.iAssertInnerHtmlIs(d365Loc.tableCellValue(page,"TABLE","cell::none::1::"+tempColNum),header_column_text);
        BrowserGlobal.iAssertElementPresent(d365Loc.tableColumnSort(page,"OTHER","ascending::none::"+tempColNum));
        tableHeaderScrollLeft(tempColNum);
    }

    /**
     *
     * @param header_column_text [header column number of the Table to be clicked]
     * @param header_column_number [header column number of the Table to be clicked]
     * @param page [Page name]
     *
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Header-Column-Descending Header-Text:{0} Header-Column:{1} Page:{2}")
    @And("D365CRM: Verify-Table-Header-Column-Descending Header-Text:{string} Header-Column:{string} Page:{string}")
    public static void verifyTableColumnDescending_D365CRM(String header_column_text,String header_column_number, String page) throws Exception {
        int tempColNum = Integer.parseInt(header_column_number) + 1;
        tableHeaderScrollRight(tempColNum, page);
        BrowserGlobal.iAssertInnerHtmlIs(d365Loc.tableCellValue(page,"TABLE","cell::none::1::"+tempColNum),header_column_text);
        BrowserGlobal.iAssertElementPresent(d365Loc.tableColumnSort(page,"OTHER","descending::none::"+tempColNum));
        tableHeaderScrollLeft(tempColNum);
    }
    /**
     * @param header_text [Header text to be Verified]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Header-By-Edit-Column Text:{0} Column:{1} Page:{2}")
    @And("D365CRM: Verify-Table-Header-By-Edit-Column Text:{string} Column:{string} Page:{string}")
    public static void verifyTableHeaderByEditColumn_D365CRM(String header_text, String column_number, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_button","Add columns"));
        BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_edit_column",header_text+"::"+column_number));
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Close"));
    }

    /**
     * @param header_text_all [Header text delimited by comma to be Verified E.g. "id,status,address"]
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Header-All-By-Edit-Column Text:{0} Page:{1}")
    @And("D365CRM: Verify-Table-Header-All-By-Edit-Column Text:{string} Page:{string}")
    public static void verifyTableHeaderAllByEditColumn_D365CRM(String header_text_all, String page) throws Exception {
        BrowserGlobal.iScrollToAnElement(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Edit columns"));
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"d365_button","Add columns"));

        String[] splitHeaderNames = header_text_all.split(",");
        int colNum = 0;
        for ( String tableHeaderName : splitHeaderNames )
        {
            colNum = colNum + 1;
            BrowserGlobal.iAssertElementPresent(loc.get(page,"d365_table_header_edit_column",tableHeaderName+"::"+colNum));
        }
        BrowserGlobal.iClickOn(loc.get(page,"d365_button","Close"));
    }

    /**
     * @param cell_value [cell value to be Verified]
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Cell-Value-Is Text:{0} Row:{1} Column:{2} Page:{3}")
    @And("D365CRM: Verify-Table-Cell-Value-Is Text:{string} Row:{string} Column:{string} Page:{string}")
    public static void verifyTableCellValueIs_D365CRM(String cell_value, String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;

        tableScrollRight(tempRowNum, tempColNum, page);
        BrowserGlobal.iAssertInnerHtmlIs(d365Loc.tableCellValue(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),cell_value);
        tableScrollLeft(tempRowNum, tempColNum, page);
    }

    /**
     * @param cell_value [cell value to be Verified]
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     */
    @QAFTestStep(description = "D365CRM: Verify-Table-Cell-Value-Contains Text:{0} Row:{1} Column:{2} Page:{3}")
    @And("D365CRM: Verify-Table-Cell-Value-Contains Text:{string} Row:{string} Column:{string} Page:{string}")
    public static void verifyTableCellValueContains_D365CRM(String cell_value, String row_number, String column_number, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;

        tableScrollRight(tempRowNum, tempColNum, page);
        BrowserGlobal.iAssertInnerHtmlContains(d365Loc.tableCellValue(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum),cell_value);
        tableScrollLeft(tempRowNum, tempColNum, page);
    }

    // Get Values

    /**
     * @param row_number [Table row number after header from top to bottom starting from 1]
     * @param column_number [Table column number from left to right starting from 1]
     * @param to_variable [Variable Name to store the value]
     */
    @QAFTestStep(description = "D365CRM: Assign-Table-Cell-Value-To-Variable Row:{0} Column:{1} To-Variable:{2} Page:{3}")
    @And("D365CRM: Assign-Table-Cell-Value-To-Variable Row:{string} Column:{string} To-Variable:{string} Page:{string}")
    public static void storeTableCellValueToVariable_D365CRM(String row_number, String column_number, String to_variable, String page) throws Exception {
        int tempRowNum = Integer.parseInt(row_number) + 1;
        int tempColNum = Integer.parseInt(column_number) + 1;
//        scrollFromVisibleField("100", String field, String page)
//        BrowserGlobal.iScrollToAnElement(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::1"));
        tableScrollDown(tempRowNum, page);
        tableScrollRight(tempRowNum, tempColNum, page);
        BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+tempRowNum+"::1"),"2");
        BrowserGlobal.iStoreValueIntoVariable(BrowserGlobal.iGetTextFromInnerHtml(d365Loc.tableCellValue(page,"TABLE","cell::none::"+tempRowNum+"::"+tempColNum)),to_variable);
        tableScrollLeft(tempRowNum, tempColNum, page);
        tableScrollUp(tempRowNum, page);
    }

//    /**
//     * @param cell_value [cell value to be Verified]
//     * @param row_number [Table row number after header from top to bottom starting from 1]
//     * @param to_variable [Table column number from left to right starting from 1]
//     */
//    @QAFTestStep(description = "D365CRM: Assign-Table-Row-Count To-Variable:{0} Page:{1}")
    /**
     * @param to_variable [Variable Name to store the value]
     * @param page [Page name]
     */
    @QAFTestStep(description="D365CRM: Store-Table-Row-Count To-Variable:{0} Page:{1}")
    @And("D365CRM: Store-Table-Row-Count To-Variable:{string} Page:{string}")
    public static void storeTableRowCountToVar_D365CRM(String to_variable, String page) throws Exception {
        BrowserGlobal.iWaitForSeconds("3");
        BrowserGlobal.iWaitForPageToLoad();
        BrowserGlobal.iWaitUntilElementVisible("xpath=(//div[contains(@class,'statusContainer')] | //span[contains(@class,'statusContainer')])");
        String output = null;
//        String output = BrowserGlobal.iGetTextFromInnerHtml("xpath=(//div[contains(@class,'statusContainer')] | //span[contains(@class,'statusContainer')])");
        if ((BrowserGlobal.iGetTextFromInnerHtml("xpath=(//div[contains(@class,'statusContainer')] | //span[contains(@class,'statusContainer')])")).contains(" of ")) {
            output = BrowserGlobal.iGetText("xpath=//span[contains(@class,'statusContainer')]/div/div");
            BrowserGlobal.iStoreValueIntoVariable(output.substring(output.indexOf("f") + 1).trim(),to_variable);
        } else {
            output = BrowserGlobal.iGetText("xpath=//span[contains(@class,'statusTextContainer')]");
            BrowserGlobal.iStoreValueIntoVariable(output.substring(output.indexOf(":") + 1).trim(),to_variable);
        }
    }

    /**
     * @param column_number [Table column number from left to right starting from 1]
     * @param to_variable [Variable Name to store the value]
     * [Note: No instance feature available]
     */
    @QAFTestStep(description="D365CRM: Store-Header-Control-List-Column-Value Column:{0} To-Variable:{1} Page:{2}")
    @And("D365CRM: Store-Header-Control-List-Column-Value Column:{string} To-Variable:{string} Page:{string}")
    public static void storeHeaderControlListColValueToVar_D365CRM(String column_number, String to_variable, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"","MAIN");

        BrowserGlobal.iScrollToAnElement(d365Loc.headerControlListValue(pageName,fieldLoc,"column:: ::"+column_number));
        BrowserGlobal.iWaitUntilElementVisible(d365Loc.headerControlListValue(pageName,fieldLoc,"column:: ::"+column_number));
        BrowserGlobal.iStoreValueIntoVariable(BrowserGlobal.iGetText(d365Loc.headerControlListValue(pageName,fieldLoc,"column:: ::"+column_number)),to_variable);
    }

    /**
     * @param to_variable [Variable Name to store the value]
     * [Note: No instance feature available, Location available]
     */
    @QAFTestStep(description="D365CRM: Store-Header-Title-In-Form-Page To-Variable:{0} Page:{1}")
    @And("D365CRM: Store-Header-Title-In-Form-Page To-Variable:{string} Page:{string}")
    public static void storeHeaderTitleToVar_D365CRM(String to_variable, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"","MAIN");

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.headerTitleFormPage(pageName,fieldLoc, "header_title"));
        BrowserGlobal.iScrollToAnElement(d365Loc.headerTitleFormPage(pageName,fieldLoc, "header_title"));
        BrowserGlobal.iStoreValueIntoVariable(BrowserGlobal.iGetAttributeValueFrom("title", d365Loc.headerTitleFormPage(pageName,fieldLoc, "header_title")),to_variable);
    }

    /**
     * @param from_app [App you have presently logged in]
     * @param to_app [App you want to switch to]
     * [Check top left next to Dynamics logo]
     */
    @QAFTestStep(description = "D365CRM: Switch-App From:{0} To:{1}")
    @And("D365CRM: Switch-App From:{string} To:{string}")
    public static void switchApp_D365CRM(String from_app, String to_app) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.link("Switching App","TOP_BAR",from_app));
        BrowserGlobal.iScrollToAnElement(d365Loc.link("Switching App","TOP_BAR",from_app));
        BrowserGlobal.iClickOn(d365Loc.link("Switching App","TOP_BAR",from_app));

        BrowserGlobal.iWaitUntilElementPresent("xpath=//iframe[@title='AppLandingPage']");
        BrowserGlobal.iSwitchToIFrameByIdOrName("AppLandingPage");
        BrowserGlobal.iClickOn(d365Loc.link("Switching App","SWITCH_APP",to_app));
    }

    /**
     * @param fileName [File Name in Uploads Folder]
     * [Note: No instance feature available, Location available]
     */
    @QAFTestStep(description="D365CRM: Upload-File Filename:{0} Page:{1}")
    @And("D365CRM: Upload-File Filename:{string} Page:{string}")
    public static void uploadFile_D365CRM(String fileName, String page) throws Exception {
        String pageName = pageNameCheck(page);
        String fieldLoc = fieldLocCheck(page,"","MAIN");

        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button(pageName,fieldLoc, "Add an attachment"));
        BrowserGlobal.iScrollToAnElement(d365Loc.button(pageName,fieldLoc, "Add an attachment"));
//        BrowserGlobal.iClickOn(d365Loc.button(pageName,fieldLoc, "Add an attachment"));
        BrowserGlobal.iUploadFileOnFileUploader("/Users/renishk/RENISH/_AUTOMATION/_FRAMEWORK/NCS_Java_Framework/NCS Java Framework/resources/uploads/Sample_PDF_File.pdf",d365Loc.button(pageName,fieldLoc, "Add an attachment"));
//        BrowserGlobal.iPressReturnOrEnterKey();
//        new WebDriverTestBase().getDriver().switchTo().activeElement();
//        WebDriver driver = new WebDriverTestBase().getDriver();
//        driver.switchTo().activeElement();
//        SendKeys.SendWait(@$"{rootDirectory}\MyFile.pdf");
//        SendKeys.SendWait(@"{Enter}");


    }

    /**
     *
     * @param scroll_value [Scroll Value from the Visible Field]
     * @param field [Field name]
     * @param page [Page name]
     * [Note: No instance feature available]
     */
    @QAFTestStep(description = "D365CRM: Scroll Value:{0} From-Visible Field:{1} Page:{2}")
    @And("D365CRM: Scroll Value:{string} From-Visible Field:{string} Page:{string}")
    public static void scrollFromVisibleField_D365CRM(String scroll_value, String field, String page) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(loc.get(page,"general",field));
        BrowserGlobal.iScrollToAnElement(loc.get(page,"general",field));
        QAFWebDriver driver = new WebDriverTestBase().getDriver();
        QAFWebElement point = new QAFExtendedWebElement(loc.get(page,"general",field));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(point);
        new Actions(driver).scrollFromOrigin(scrollOrigin,0 , Integer.parseInt(scroll_value)).perform();
    }

    /**
     *
      */
    @QAFTestStep(description = "D365CRM: Logout from Dynamics")
    @And("D365CRM: Logout from Dynamics")
    public static void logoutFrom_D365CRM() throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.signOutButton());
        BrowserGlobal.iScrollToAnElement(d365Loc.signOutButton());
        BrowserGlobal.iClickOn(d365Loc.signOutButton());
        BrowserGlobal.iWaitUntilElementPresent(d365Loc.button("Sign Out","OTHER","Sign out"));
        BrowserGlobal.iMouseoverOn(d365Loc.button("Sign Out","OTHER","Sign out"));
        BrowserGlobal.iWaitUntilElementEnabled(d365Loc.button("Sign Out","OTHER","Sign out"));
        BrowserGlobal.iClickOn(d365Loc.button("Sign Out","OTHER","Sign out"));
        BrowserGlobal.iWaitForSeconds("5");
        BrowserGlobal.iCloseWebBrowser();
    }

    @QAFTestStep(description="D365CRM: Login to {0} with following details {1}, {2} and {3}")
    @And("D365CRM: Login to {string} with following details {string}, {string} and {string}")
    public void loginTo_D365CRM(String name, String urlToOpen, String username, String password) throws Exception{

        BrowserGlobal.iOpenWebBrowserAndMaximize(urlToOpen);
        BrowserGlobal.iInputInTo(username,d365Loc.inputText("Login","NONE","Email"));
        BrowserGlobal.iClickOn(d365Loc.button("Login","NONE","Next"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iInputInTo(password,d365Loc.inputText("Login","NONE","Password"));
        BrowserGlobal.iClickOn(d365Loc.button("Login","NONE","Sign in"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iClickOn(d365Loc.button("Login","NONE","Yes"));
        BrowserGlobal.iWaitForSeconds("2");
        BrowserGlobal.iWaitForPageToLoad();
//        BrowserGlobal.iWaitForSeconds("5");
//        getBundle().setProperty("loc.temp.signin","{\"locator\":[\"xpath=//button[contains(@title,'Sign ')]\",\"xpath=//button[contains(@aria-label,'Sign ')]\"],\"desc\":\"Temp Sign in\"}");
        System.out.println("==signin TRIGGER=> ");
        if (BrowserGlobal.isElementVisibleWithTimeout(d365Loc.signInButton(),"15000")) {
           System.out.println("==signin ENTERED=> ");
            BrowserGlobal.iExecuteJavascript("var buttons=document.querySelectorAll('button[title^=\"Sign In\"]');buttons.forEach((t=>{t.click()}));");
            BrowserGlobal.iExecuteJavascript("var buttons=document.querySelectorAll('button[aria-label^=\"Sign In\"]');buttons.forEach((t=>{t.click()}));");
            BrowserGlobal.iExecuteJavascript("var buttons=document.querySelectorAll('button[title^=\"Sign in\"]');buttons.forEach((t=>{t.click()}));");
            BrowserGlobal.iExecuteJavascript("var buttons=document.querySelectorAll('button[aria-label^=\"Sign in\"]');buttons.forEach((t=>{t.click()}));");
        } else {
            System.out.println("==signin NOT ENTERED=> ");
        }
//        BrowserGlobal.iExecuteJavascript("var buttons=document.querySelectorAll('button[title^=\"Sign \"]');buttons.forEach((t=>{t.click()}));");
////<button type="button" title="Sign In" data-id="okButton" id="okButton_1" class="fui-Button r1alrhcs ___1akj6hk ffp7eso f1p3nwhy f11589ue f1q5o8ev f1pdflbu f1phragk f15wkkf3 f1s2uweq fr80ssc f1ukrpxl fecsdlb f1rq72xc fnp9lpt f1h0usnq fs4ktlq f16h9ulv fx2bmrt f1d6v5y2 f1rirnrt f1uu00uk fkvaka8 f1ux7til f9a0qzu f1lkg8j3 fkc42ay fq7113v ff1wgvm fiob0tu f1j6scgf f1x4h75k f4xjyn1 fbgcvur f1ks1yx8 f1o6qegi fcnxywj fmxjhhp f9ddjv3 f17t0x8g f194v5ow f1qgg65p fk7jm04 fhgccpy f32wu9k fu5nqqq f13prjl2 f1czftr5 f1nl83rv f12k37oa fr96u23"><div role="presentation" class="pa-go pa-er pa-aq pa-e ">Sign In</div></button>
////        BrowserGlobal.iInputInTo(username, loc.get("Login","input","Enter your email address, phone number or Skype."));
////        BrowserGlobal.iInputInTo(username, "xpath=//input[contains(@placeholder,'Email') or contains(@aria-label,'Email')]");
////        BrowserGlobal.iClickOn(loc.get("Login","button","Next"));
////        BrowserGlobal.iWaitForSeconds("2");
////        BrowserGlobal.iInputInTo(password, loc.get("Login","input","Password"));
////        BrowserGlobal.iClickOn(loc.get("Login","button","Sign in"));
////        BrowserGlobal.iWaitForSeconds("2");
////        BrowserGlobal.iClickOn(loc.get("Login","button","Yes"));
////        BrowserGlobal.iWaitForSeconds("5");
////        BrowserGlobal.iWaitForPageToLoad();
//
//
//        int signinCount = 0;
//        for (int i = 0; i < 10; i++) {
//            getBundle().setProperty("exec.email.report.fail","OFF");
//            signinCount = signinCount + 1;
//            if (BrowserGlobal.isElementVisibleWithTimeout(loc.get("ReLogin","button","Sign In"),"1500")) {
//                BrowserGlobal.iClickOn(loc.get("ReLogin","button","Sign In"));
//                BrowserGlobal.iWaitForPageToLoad();
//                BrowserGlobal.iWaitForMilliseconds("1500");
//            } else {
//                getBundle().setProperty("exec.email.report.fail","ON");
//                break;
//            }
//            getBundle().setProperty("exec.email.report.fail","ON");
////            try {
////                getBundle().setProperty("exec.email.report.fail","OFF");
////                BrowserGlobal.iWaitUntilElementVisibleWithTimeout(loc.get("ReLogin","button","Sign In"),"15");
////                BrowserGlobal.iClickOn(loc.get("ReLogin","button","Sign In"));
////                BrowserGlobal.iWaitForPageToLoad();
////            } catch (Exception e) {
////                getBundle().setProperty("exec.email.report.fail","ON");
////                break;
////            }
////            getBundle().setProperty("exec.email.report.fail","ON");
//        }
////        System.out.println("==signinCount=> "+signinCount);
//        if (signinCount > 2) {
//            int count = signinCount;
//            for (int j = 0; j < signinCount; j++) {
//                try {
//                    getBundle().setProperty("exec.email.report.fail","OFF");
//                    count = count - 1;
//                    BrowserGlobal.iWaitUntilElementVisibleWithTimeout("xpath=(//button[@aria-label='Sign in'])["+count+"]","3");
//                    BrowserGlobal.iClickOn("xpath=(//button[@aria-label='Sign in'])["+count+"]");
//                    BrowserGlobal.iWaitForPageToLoad();
//                } catch (Exception e) {
//                    getBundle().setProperty("exec.email.report.fail","ON");
//                }
//                getBundle().setProperty("exec.email.report.fail","ON");
//            }
//        }

    }

    private static String[] fieldValueCheck(String argFieldVal){
        String[] fVal = new String[2];
        if (argFieldVal.contains("::")) {
            String[] elementSplit = argFieldVal.trim().split("::");
            fVal[0] = elementSplit[0];
            fVal[1] = "::"+elementSplit[1];
        } else {
            fVal[0] = argFieldVal;
            fVal[1] = "";
        }
        return fVal;
    }

    private static String pageNameCheck(String argPage){
        if (argPage.contains("::")) {
            String[] pageSplit = argPage.trim().split("::");
            return pageSplit[0];
        } else {
            return argPage;
        }
    }
    private static String fieldLocCheck(String argPage, String argFieldName, String argDefaultLoc){
        String fLoc ="";
        if (argPage.contains("::")) {
            String[] pageSplit = argPage.trim().split("::");
            fLoc = pageSplit[1];
        } else {
            fLoc = argDefaultLoc;
        }

        if (argFieldName.startsWith("[") && argFieldName.contains("]")) {
            fLoc = fLoc + "::" + argFieldName.substring(1, argFieldName.indexOf("]"));
            System.out.println("==fLoc==> " + fLoc);
        }
        return fLoc.trim();
    }

    private static String fieldNameCheck(String argFieldName){
        if (argFieldName.startsWith("[") && argFieldName.contains("]")) {
            String[] fName = argFieldName.trim().split("]");
            return fName[1];
        } else {
            return argFieldName.trim();
        }
    }

    private static String fieldInstanceCheckAndAddVal_1(String argFieldName, String argAdditionalVal_1){
        return argFieldName.contains("::") ? argFieldName.trim() + "::"+ argAdditionalVal_1 : argFieldName.trim() + ":: ::"+ argAdditionalVal_1;
    }

    private static String getD365CrmVersion(){
        return getBundle().getPropertyValue("d365.crm.version").equalsIgnoreCase("d365.crm.version") ? "v9.1" : "v"+getBundle().getPropertyValue("d365.crm.version").toLowerCase();
    }
    //    tableColumnScrollForward
    private static void tableScrollRight(int rowNumber, int colNumber, String page) throws Exception{
        BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+rowNumber+"::1"),"2");
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+rowNumber+"::1"));
        for (int i = 1; i < colNumber; i++) {
            BrowserGlobal.iPressKey("ARROW_RIGHT");
            BrowserGlobal.iWaitForMilliseconds("150");
        }
    }
    //    tableHeaderColumnScrollForward
    private static void tableHeaderScrollRight(int colNumber, String page) throws Exception{
        //        Below command has visibility issue in v9.1
//        BrowserGlobal.iWaitUntilElementVisibleWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::1::2"),"2");
        BrowserGlobal.iDoubleClickOn(d365Loc.tableCell(page,"TABLE","cell::none::1::2"));
        BrowserGlobal.iPressKey("ARROW_RIGHT");
        for (int i = 1; i < (colNumber - 1); i++) {
            BrowserGlobal.iPressKey("ARROW_RIGHT");
            BrowserGlobal.iWaitForMilliseconds("150");
        }
    }
    //    tableColumnScrollBack
    private static void tableScrollLeft(int rowNumber, int colNumber, String page) throws Exception {
        for (int i = 1; i < colNumber; i++) {
            BrowserGlobal.iPressKey("ARROW_LEFT");
            BrowserGlobal.iWaitForMilliseconds("150");
        }
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::"+rowNumber+"::1"));
    }
    //    tableHeaderColumnScrollBack
    private static void tableHeaderScrollLeft(int colNumber) throws Exception {
        for (int i = 1; i < colNumber; i++) {
            BrowserGlobal.iPressKey("ARROW_LEFT");
            BrowserGlobal.iWaitForMilliseconds("150");
        }
    }

    private static void tableScrollDown(int rowNumber, String page) throws Exception{
        BrowserGlobal.iScrollToAnElement(d365Loc.tableCell(page,"TABLE","cell::none::1::1"));
        BrowserGlobal.iWaitUntilElementPresentWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::1::1"),"5");
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::2::1"));
        BrowserGlobal.iWaitForSeconds("1");
        BrowserGlobal.iClickOn(d365Loc.tableCell(page,"TABLE","cell::none::2::1"));
        for (int i = 1; i < (rowNumber - 1); i++) {
            BrowserGlobal.iPressKey("ARROW_DOWN");
            BrowserGlobal.iWaitForMilliseconds("100");
        }
    }

    private static void tableScrollUp(int rowNumber, String page) throws Exception{
        BrowserGlobal.iWaitUntilElementPresentWithTimeout(d365Loc.tableCell(page,"TABLE","cell::none::"+rowNumber+"::1"),"5");
        for (int i = 1; i < (rowNumber - 1); i++) {
            BrowserGlobal.iPressKey("ARROW_UP");
            BrowserGlobal.iWaitForMilliseconds("100");
        }
    }

    private static void waitFieldToBePresentScrollVisibleAndEnabled(String locName) throws Exception {
        BrowserGlobal.iWaitUntilElementPresent(locName);
        BrowserGlobal.iScrollToAnElement(locName);
        BrowserGlobal.iWaitUntilElementVisible(locName);
        BrowserGlobal.iWaitUntilElementEnabled(locName);
    }

}
