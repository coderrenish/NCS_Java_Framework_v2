package com.ahq.globals;

import com.ahq.addons.d365Loc;
import com.ahq.addons.loc;
import com.ahq.addons.patternLoc;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import io.cucumber.java.en.And;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.util.Objects;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class Ivalua {

    @QAFTestStep(description="Ivalua: Login to {0} with following details Url:{1}, Username:{2} and Password:{3}")
    @And("Ivalua: Login to {string} with following details Url:{string}, Username:{string} and Password:{string}")
    public static void loginTo_Ivalua(String name, String urlToOpen, String username, String password) throws Exception{
        web.openBrowserAndMaximise_Web(urlToOpen);
        web.verifyPageTitle_Web("Homepage","Extranet Homepage");
//        BrowserGlobal.iWaitForPageToLoad();
        web.inputTextWithPlaceholderOrNoLabel_Web(username,"Login");
        web.inputTextWithPlaceholderOrNoLabel_Web(password,"Password");
        web.clickButton_Web("Sign in");
//        web.verifyPageHeader_Web("Homepage", "Homepage");
        BrowserGlobal.iWaitForMilliseconds("5000");
        BrowserGlobal.iGetAllCookies();
        web.openBrowserAndMaximise_Web(getBundle().getPropertyValue("env.url_2"));
        BrowserGlobal.iWaitForMilliseconds("5000");
        BrowserGlobal.iGetAllCookies();
        BrowserGlobal.iWaitForMilliseconds("5000");

    }


//    Ivalua: Log-Out-Signed-In-User

    /**
     *
     */
    @And("Ivalua: Log-Out-Signed-In-User")
    @QAFTestStep(description = "Ivalua: Log-Out-Signed-In-User")
    public static void logOutSignedInUser_Ivalua() throws Exception {
        web.setFieldLocation_Web("top_menu_bar");
        web.clickButton_Web("Profile Menu");
        web.waitForSecs_Web("1");
        web.clickButton_Web("Logout");
        web.removeFieldLocation_Web();
        BrowserGlobal.iWaitForPageToLoad();
    }

    /**
     *
     */
    @And("Ivalua: Comment:{string}")
    @QAFTestStep(description = "Ivalua: Comment:{0}")
    public static void comment_Ivalua(String comment) throws Exception {
        BrowserGlobal.iComment(comment);
    }

    /**
     * @param sub_menu_text [Sub Menu Text under Profile Menu]
     */
    @And("Ivalua: Click-Top-Profile-Menu-Then-Sub-Menu Text:{string}")
    @QAFTestStep(description = "Ivalua: Click-Top-Profile-Menu-Then-Sub-Menu Text:{0}")
    public static void clickTopProfileMenuThenSubMenu_Ivalua(String sub_menu_text) throws Exception {
        web.setFieldLocation_Web("top_menu_bar");
        web.clickButton_Web("Profile Menu");
        web.waitForSecs_Web("1");
        web.clickButton_Web(sub_menu_text);
        web.removeFieldLocation_Web();
        BrowserGlobal.iWaitForPageToLoad();
    }

    /**
     * @param sub_menu_text [Sub Menu Text under Profile Menu]
     */
    @And("Ivalua: Click-Top-Notifications-Menu-Then-Sub-Menu Text:{string}")
    @QAFTestStep(description = "Ivalua: Click-Top-Notifications-Menu-Then-Sub-Menu Text:{0}")
    public static void clickTopNotificationsMenuThenSubMenu_Ivalua(String sub_menu_text) throws Exception {
        web.clickButton_Web("Notification Menu::top_menu_bar");
        web.waitForSecs_Web("1");
        web.clickLink_Web(sub_menu_text+"::top_notifications_dropdown");
        BrowserGlobal.iWaitForPageToLoad();
    }


    /**
     * @param sub_menu_text [Sub Menu Text under Profile Menu]
     */
    @And("Ivalua: Display-Left-Menu")
    @QAFTestStep(description = "Ivalua: Display-Left-Menu")
    public static void displayLeftMenu_Ivalua(String sub_menu_text) throws Exception {

    }



    @QAFTestStep(description = "Ivalua: Verify-Page-Header Text:{0} Page:{1}")
    @And("Ivalua: Verify-Page-Header Text:{string} Page:{string}")
    public static void verifyPageHeader_Ivalua(String header,String page) throws Exception {
        web.verifyPageHeader_Web(header,page+"::header_bar");
        web.removeFieldLocation_Web();
    }

    @QAFTestStep(description = "Ivalua: Verify-Page-Header-Contains Text:{0} Page:{1}")
    @And("Ivalua: Verify-Page-Header-Contains Text:{string} Page:{string}")
    public static void verifyPageHeaderContains_Ivalua(String header,String page) throws Exception {
        web.verifyPageHeaderTextContains_Web(header,page+"::header_bar");
        web.removeFieldLocation_Web();
    }

    /**
     * @param main_menu_text [Main Menu Text/Name]
     * @param sub_menu_text [Sub Menu Text/Name]
     */
    @And("Ivalua: Click-Top-Main-Menu Text:{string} Then-Sub-Menu Text:{string}")
    @QAFTestStep(description = "Ivalua: Click-Top-Main-Menu Text:{0} Then-Sub-Menu Text:{1}")
    public static void clickTopMainMenuAndSubMenu_Ivalua(String main_menu_text,String sub_menu_text) throws Exception {
        web.setFieldLocation_Web("top_menu");
        web.clickButton_Web(main_menu_text);
        web.waitForSecs_Web("2");
        web.setFieldLocation_Web("top_menu_dropdown");
        web.clickLink_Web(sub_menu_text);
        web.removeFieldLocation_Web();
    }

    /**
     *
     */
    @And("Ivalua: Go back to previous page")
    @QAFTestStep(description = "Ivalua: Go back to previous page")
    public static void goBackToPreviousPage_Ivalua() throws Exception {
        web.mouseoverOnLink_Web("Go back to the previous page::main_actions");
        web.waitForSecs_Web("2");
        web.clickLink_Web("Go back to the previous page::main_actions");
    }

    /**
     * @param text [text to fill]
     * @param field [Field name]
     */
    @And("Ivalua: Input Text:{string} Field:{string}")
    @QAFTestStep(description = "Ivalua: Input Text:{0} Field:{1}")
    public static void inputText_Ivalua(String text,String field) throws Exception {
        web.inputText_Web(text,field);
    }

    /**
     * @param field [Field name]
     */
    @And("Ivalua: Click-Checkbox Field:{string}")
    @QAFTestStep(description = "Ivalua: Click-Checkbox Field:{0}")
    public static void clickCheckbox_Ivalua(String field) throws Exception {
        web.clickCheckbox_Web(field);
    }

    /**
     * @param field [Field name]
     */
    @And("Ivalua: Click-Button Field:{string}")
    @QAFTestStep(description = "Ivalua: Click-Button Field:{0}")
    public static void clickButton_Ivalua(String field) throws Exception {
        web.clickButton_Web(field);
    }

    /**
     * @param field [Field name]
     */
    @And("Ivalua: Toggle-Section-Or-Segment Field:{string}")
    @QAFTestStep(description = "Ivalua: Toggle-Section-Or-Segment Field:{0}")
    public static void toggleSectionOrSegment_Ivalua(String field) throws Exception {
        web.clickButton_Web("Show / Hide : " +field);
    }

    /**
     * @param text [text to fill]
     * @param field [Field name]
     */
    @And("Ivalua: Select Text:{string} Field:{string}")
    @QAFTestStep(description = "Ivalua: Select Text:{0} Field:{1}")
    public static void selectText_Ivalua(String text,String field) throws Exception {
        web.clickAndInputText_Web(text,field);
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iPressReturnOrEnterKey();
        BrowserGlobal.iWaitForMilliseconds("500");
        BrowserGlobal.iWaitUntilElementNotVisibleWithTimeout("xpath=//i[@aria-label='Loading']",5);
    }

    /**
     * @param text [text to fill]
     * @param field [Field name]
     */
    @And("Ivalua: Multi-Select Text:{string} Field:{string}")
    @QAFTestStep(description = "Ivalua: Multi-Select Text:{0} Field:{1}")
    public static void multiSelectText_Ivalua(String text,String field) throws Exception {
        String[] dropdownValues = text.split(",");
        web.waitFieldToBePresentScrollAndEnabled(patternLoc.input(web.getPageName_Web(),field)); // TO GENERATE forValue from Label
        String forValue = getBundle().getPropertyValue("loc.auto.forValue");
        BrowserGlobal.iClickOn("xpath=//INPUT[@id='"+forValue+"']//following-sibling::div[@class='text default']");
        for (String select_text : dropdownValues) {
            web.inputText_Web(select_text,field);
            BrowserGlobal.iWaitForMilliseconds("500");
            BrowserGlobal.iPressReturnOrEnterKey();
            BrowserGlobal.iWaitForMilliseconds("500");
        }
        BrowserGlobal.iWaitUntilElementNotVisibleWithTimeout("xpath=//i[@aria-label='Loading']",5);
        BrowserGlobal.iPressTabKeyTimes("1");
    }

}


// Ivalua: Click-On-Profile-Menu-And-Select Text:{string}
// Ivalua: Click-Top-Profile-Menu-Then-Sub-Menu Text:{string}
//Ivalua: Click-Top-Main-Menu Text:{string} Then-Sub-Menu Text:{string}
//Ivalua: Display-Left-Menu     => Use Suppliers -> Answers
//Ivalua: Hide-Left-Menu        => Use Suppliers -> Answers

// https://academy-emea.ivalua.com/buyer/academy-emea/sandbox47/p3twt/page.aspx/en/cam/category_manage/11

//