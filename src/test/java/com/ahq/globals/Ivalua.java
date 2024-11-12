package com.ahq.globals;

import com.ahq.addons.d365Loc;
import com.ahq.addons.loc;
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
        web.verifyPageTitle_Web("Homepage");
//        BrowserGlobal.iWaitForPageToLoad();
        web.inputTextWithPlaceholderOrNoLabel_Web(username,"Login");
        web.inputTextWithPlaceholderOrNoLabel_Web(password,"Password");
        web.clickButton_Web("Sign in");
        web.verifyPageHeaderText_Web("Homepage");
        web.openBrowserAndMaximise_Web(getBundle().getPropertyValue("env.url_2"));
    }

    @QAFTestStep(description = "Ivalua: Verify-Page-Header Text:{0} Page:{1}")
    @And("Ivalua: Verify-Page-Header Text:{string} Page:{string}")
    public static void verifyPageHeader_Ivalua(String header,String page) throws Exception {
        web.VerifyPageHeaderTextWithPageName_Web(header,page);
    }

    /**
     * @param main_menu_text [Main Menu Text/Name]
     * @param sub_menu_text [Sub Menu Text/Name]
     */
    @And("Ivalua: Click-Top-Main-Menu Text:{string} Then-Sub-Menu Text:{string}")
    @QAFTestStep(description = "Ivalua: Click-Top-Main-Menu Text:{0} Then-Sub-Menu Text:{1}")
    public static void clickTopMainMenuAndSubMenu_Ivalua(String main_menu_text,String sub_menu_text) throws Exception {
        web.clickButton_Web(main_menu_text+"::top_menu");
//        web.mouseoverOnButton_Web(main_menu_text+"::top_menu");
        web.waitForSecs_Web("2");
        web.clickLink_Web(sub_menu_text+"::top_menu_dropdown");
    }

}
