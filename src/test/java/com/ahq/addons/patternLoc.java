package com.ahq.addons;

import com.ahq.globals.BrowserGlobal;
import org.apache.commons.text.CaseUtils;

import java.util.Arrays;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

// fieldType [“input”, “link”, “text”, “radio_button”, “checkbox”, “select”, “button”, "tab" - Should match with last part of pattern entry Eg: loc.XXXX.pattern.radio_button]
public class patternLoc {
    //    private static String patternCode = getBundle().getPropertyValue("loc.pattern.code");
    private static String varPageName;
    private static String varFieldName;
    private static String varFieldInst;
    private static String varFieldSec;
    private static String varFieldLoc;
    private static String varFieldType;
    private static String varLocName;
    private static String varLocValue;

    private static Boolean varFieldInstFlag;
    private static String lastLocPrintVal = "";

    private static String varPatternCode = getPatternCode().trim();


    /**
     * @param fieldType [Type of the locator - link,input,select,button,switchButton,checkbox,radioButton]
     * @param pageName [Page name in which field is located]
     * @param fieldName [Field Name]
     *
     **/
    public static String getLocator(String pageName, String fieldType, String fieldName, String fieldValue, Boolean ignoreLabel) throws Exception{
        String loc = "";
        switch(fieldType.toUpperCase().trim()){
            case "INPUT":
                return input(pageName,fieldName);

            default:
                return "";
        }

    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String input(String page, String fieldName) throws Exception{
        String fieldType = "input";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            setForValue();
            generateLoc();
        }
        return locator;
    }
    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     * @param ByLabelCheck [Mention "False" for not checking label or "True" to check label]
     **/
    public static String input(String page, String fieldName, Boolean ByLabelCheck) throws Exception{
        String fieldType = "input";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            if (ByLabelCheck) {
                setForValue();
            }
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String checkbox(String page, String fieldName) throws Exception{
        String fieldType = "checkbox";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String select(String page, String fieldName) throws Exception{
        String fieldType = "select";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            setForValue();
            generateLoc();
        }
        return locator;
    }
    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String radioButton(String page, String fieldName, String fieldValue) throws Exception{
        String fieldType = "radioButton";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            setForValue();
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Link Name]
     *
     **/
    public static String link(String page, String fieldName) throws Exception{
        String fieldType = "link";
        String locatorName = checkLoc(page, fieldType, fieldName);
        if (locatorName.contains("auto.")) {
            generateLoc();
        }
        return locatorName;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Link Name]
     *
     **/
    public static String link(String page, String fieldName, String custom) throws Exception{

        String fieldType = custom.trim().toLowerCase() + ".link";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }
//    /**
//     * @param page [Page of the locator]
//     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
//     * @param fieldInstance [Field Instance: Only mention if multiple instance of the same field exists]
//     * @param ByLabelCheck [ByLabelCheck: Only mention if multiple instance of the same field exists]
//     **/
//    public static String input(String page, String fieldName, Boolean ByLabelCheck) throws Exception{
//        String fieldType = "input";
//        String locator = checkLoc(page, fieldType, fieldName);
//        if (locator.contains("auto.")) {
//            forValue(fieldName, fieldType);
//            if (!fieldInstance.isBlank() || !fieldInstance.isEmpty()) { getBundle().setProperty("loc.auto.fieldInstance",fieldInstance.trim()); }
//        }
//        return locator;
//    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String button(String page, String fieldName) throws Exception{
        String fieldType = "button";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String switchButton(String page, String fieldName) throws Exception{
        String fieldType = "switchButton";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String buttonLookupLaunch(String page, String fieldName) throws Exception{
        String fieldType = "lookupLaunch";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String buttonLookupClear(String page, String fieldName) throws Exception{
        String fieldType = "lookupClear";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }


    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String checkboxWithFieldSet(String page, String fieldName, String fieldValue) throws Exception{
        String fieldType = "checkbox.fieldSet";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            getBundle().setProperty("loc.auto.fieldValue",fieldNameCheck(fieldValue));
            if (fieldInstanceCheck(fieldValue).equalsIgnoreCase("1")) {
                generateLoc();
            }

//            else {
//                generateLoc(locator,fieldName+"["+fieldInstanceCheck(fieldValue)+"]",fieldType);
//            }

        }
        return locator;
    }



    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String actionMenu(String page, String fieldName) throws Exception{
        String fieldType = "actionMenu";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     *
     **/
    public static String actionMenuDropdown(String page, String fieldName) throws Exception{
        String fieldType = "actionMenu.dropdown";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {
            generateLoc();
        }
        return locator;
    }
    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     **/
    public static String header(String page, String fieldName) throws Exception{
        String fieldType = "header";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {  generateLoc(); }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     **/
    public static String subHeader(String page, String fieldName) throws Exception{
        String fieldType = "subHeader";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {  generateLoc(); }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     **/
    public static String listHeader(String page, String fieldName) throws Exception{
        String fieldType = "listHeader";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) { generateLoc(); }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     **/
    public static String errorText(String page, String fieldName) throws Exception{
        String fieldType = "errorText";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {  generateLoc(); }
        return locator;
    }

    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     **/
    public static String text(String page, String fieldName) throws Exception{
        String fieldType = "text";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) {  generateLoc(); }
        return locator;
    }
    /**
     * @param page [Page of the locator]
     * @param fieldName [Field Name: Eg: First Name - Note for Radio button use ":" tell the value Eg: Choose Payment Type:Cash]
     **/
    public static String breadcrumb(String page, String fieldName) throws Exception{
        String fieldType = "breadcrumb";
        String locator = checkLoc(page, fieldType, fieldName);
        if (locator.contains("auto.")) { generateLoc(); }
        return locator;
    }


    private static void setForValue() throws Exception {
        String locLabelPatternName = getPatternCode()+".pattern.label";
        String locLabelPatternVal = getBundle().getPropertyValue(locLabelPatternName);
        String forValue;
        if (locLabelPatternVal.equals(locLabelPatternName) || locLabelPatternVal.length() < 5) {
            System.out.println("=====>[ERROR] => [Locator Pattern '"+ locLabelPatternName + "' not available]");
        } else {
            String locLabelValue = "{\"locator\":"+locLabelPatternVal+",\"desc\":\""+fieldNameCheck(varFieldName)+" : [LABEL] Field \"}";
            getBundle().setProperty("loc.auto.label",locLabelValue);
            try {
                BrowserGlobal.iWaitUntilElementPresent("loc.auto.label");
                BrowserGlobal.iScrollToAnElement("loc.auto.label");
                getBundle().setProperty("loc.auto.forValue",BrowserGlobal.iGetAttributeValueFrom("for","loc.auto.label"));
                logAutoLocatorEntry("label");
            } catch (Exception e) {
                System.out.println("\033[1;31m" + "=====>[ERROR] => [Extract \"For\" value failed]" + "\033[0m");

            }
        }
    }

    private static String checkLoc(String argPageName, String argFieldType, String argFieldName) {
//        String projCode = getBundle().getPropertyValue("project.code");
        varFieldInstFlag = false;
        varPageName = pageNameCheck(argPageName).trim();
        varFieldLoc = fieldLocationCheck(argPageName).trim();
        varFieldName = fieldNameCheck(argFieldName).trim();
        varFieldInst = fieldInstanceCheck(argFieldName).trim();
        varFieldSec = fieldSectionCheck(argFieldName).trim();
        varFieldType = argFieldType.trim();
        varLocName = "";
        varLocValue = "";

//        String [] locTypes = {"loc.","id", "name", "xpath", "css", "link", "partialLink", "className", "tagName" };
//
//        System.out.println("==== varPageName ====> " +varPageName);
//        System.out.println("==== varFieldLoc ====> " +varFieldLoc);
//        System.out.println("==== varFieldName ====> " +varFieldName);
//        System.out.println("==== varFieldInst ====> " +varFieldInst);
//        System.out.println("==== varFieldSec ====> " +varFieldSec);

        getBundle().setProperty("loc.auto.pageName",varPageName);
        getBundle().setProperty("loc.auto.fieldLocation",varFieldLoc);
        getBundle().setProperty("loc.auto.fieldName",varFieldName);
        getBundle().setProperty("loc.auto.fieldInstance",varFieldInst);
        getBundle().setProperty("loc.auto.fieldSection",varFieldSec);
        getBundle().setProperty("loc.auto.forValue","");
        getBundle().setProperty("loc.auto.fieldValue","");

        String patternCode = getPatternCode();
        if (!varFieldLoc.isEmpty()) {
            varLocName = patternCode +"."+ genCamelCase(varFieldLoc) + "." + genCamelCase(varFieldType) + "." + genCamelCase(varFieldName);
        } else {
            varLocName = patternCode +"."+ genCamelCase(varPageName) + "." + genCamelCase(varFieldType) + "." + genCamelCase(varFieldName);
        }
        String locVal = getBundle().getPropertyValue(varLocName);

        String locFieldName = argFieldName.toLowerCase().trim();
//        String locName = patternCode +"."+ CaseUtils.toCamelCase(argPageName.replaceAll("[^a-zA-Z0-9]", " "), false, ' ') + "." + CaseUtils.toCamelCase(argFieldType.replaceAll("d365_", "").replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim() + "." + CaseUtils.toCamelCase(argFieldName.replaceAll("[^a-zA-Z0-9]", " "), false, ' ').trim();
        if (locFieldName.startsWith("loc.") || locFieldName.startsWith("xpath=") || locFieldName.startsWith("id=") || locFieldName.startsWith("css=") || locFieldName.startsWith("name=") || locFieldName.startsWith("link=") || locFieldName.startsWith("partiallink=") || locFieldName.startsWith("classname=") || locFieldName.startsWith("tagname=") ) {
            varLocName = argFieldName;
        } else if (locVal.equals(varLocName) || locVal.length() < 5) {
            varLocName = "auto." + varLocName;
        }
        return varLocName;
    }

    private static void generateLoc() {
        String locPattern = varPatternCode+".pattern."+varFieldType;        // Generating locator pattern code
        String locPatternVal = getBundle().getPropertyValue(locPattern);    // Getting locator pattern value
        if (locPatternVal.equals(locPattern) || locPatternVal.length() < 5) {
            System.out.println("=====>[ERROR] => [Locator Pattern '"+ locPattern + "' not available]");
        } else {
            varLocValue = locPatternVal;
//            findAndReplaceXpath(locPatternVal,"XPATH=1234","----");
//            varLocValue = "{\"locator\":"+locPatternVal+",\"desc\":\""+varFieldName + " : ["+varFieldType+"] Field \"}";
            if (!varFieldSec.isEmpty()) {
//                String getLocatorSecName = varPatternCode+".pattern.section."+varFieldSec;
                String getLocatorSecName = varPatternCode+".pattern.section";
                getBundle().setProperty("loc.auto.section.name",varFieldSec);
                String getLocatorSecVal = getBundle().getPropertyValue(getLocatorSecName.trim());
//                System.out.println("=====>[getLocatorSecName] : "+getLocatorSecName);
//                System.out.println("=====>[getLocatorSecVal] : "+getLocatorSecVal);
                if (getLocatorSecVal.equals(getLocatorSecName) || getLocatorSecVal.length() < 5) {
                    System.out.println("=====>[ERROR] => [Locator Section Pattern '"+ getLocatorSecName + "' not available]");
                } else {
                    varLocValue = findAndReplaceXpath(varLocValue,getLocatorSecVal,"");
//                    varLocValue = varLocValue.replaceAll("xpath=",getLocatorSecVal.replaceAll("\"",""));
                }
            }
            if (!varFieldLoc.isEmpty()) {
                String getLocatorLocName = varPatternCode+".pattern.location."+genCamelCase(varFieldLoc);
                String getLocatorLocVal = getBundle().getPropertyValue(getLocatorLocName.trim());
//                System.out.println("=====>[getLocatorLocName] : "+getLocatorLocName);
//                System.out.println("=====>[getLocatorLocVal] : "+getLocatorLocVal);
                if (getLocatorLocVal.equals(getLocatorLocName) || getLocatorLocVal.length() < 5) {
                    System.out.println("=====>[ERROR] => [Locator Location Pattern '"+ getLocatorLocName + "' not available]");
                } else {
                    varLocValue = findAndReplaceXpath(varLocValue,getLocatorLocVal,"");
//                    varLocValue = varLocValue.replaceAll("xpath=",getLocatorLocVal.replaceAll("\"",""));
                }
            }

            if (varFieldInstFlag){
                varLocValue = findAndReplaceXpath(varLocValue,"XPATH=(",")["+varFieldInst+"]");
            }
            varLocValue = "{\"locator\":"+varLocValue+",\"desc\":\""+varFieldName + " : ["+varFieldType+"] Field \"}";
            getBundle().setProperty(varLocName,varLocValue);
            logAutoLocatorEntry("other");
        }
    }

//    private static void generateLoc(String argLocator, String argFieldName, String argFieldType) {
////      Checking and assigning pattern code
//        String patternCodeVal = getPatternCode();
//
//        // Assigning field name
////        getBundle().setProperty("loc.auto.fieldName",fieldNameCheck(argFieldName));
////        getBundle().setProperty("loc.auto.fieldInstance",fieldInstanceCheck(argFieldName));
////        getBundle().setProperty("loc.auto.fieldSection",fieldSectionCheck(argFieldName));
////        System.out.println("=====>[loc.auto.fieldName] => " + getBundle().getPropertyValue("loc.auto.fieldName"));
////        System.out.println("=====>[loc.auto.fieldInstance] => " + getBundle().getPropertyValue("loc.auto.fieldInstance"));
////        System.out.println("=====>[loc.auto.fieldSection] => " + getBundle().getPropertyValue("loc.auto.fieldSection"));
//
//        String locPattern = patternCodeVal+".pattern."+argFieldType;        // Generating locator pattern code
//        String locPatternVal = getBundle().getPropertyValue(locPattern);    // Getting locator pattern value
//        if (locPatternVal.equals(locPattern) || locPatternVal.length() < 5) {
//            System.out.println("=====>[ERROR] => [Locator Pattern '"+ locPattern + "' not available]");
//        } else {
//            varLocValue = "{\"locator\":"+locPatternVal+",\"desc\":\""+argFieldName + " : ["+argFieldType+"] Field \"}";
//            getBundle().setProperty(argLocator,varLocValue);
////            getBundle().setProperty(argLocator,"{\"locator\":["+locPatternVal+"],\"desc\":\""+argFieldName + " : ["+argFieldType+"] Field \"}");
//            logAutoLocatorEntry("other");
//        }
//    }

    private static String getPatternCode() {
        String patternCodeVal = getBundle().getPropertyValue("loc.pattern.code");
        if (patternCodeVal.equals("loc.pattern.code")) {
            System.out.println("=====>[ERROR] => [Locator Pattern Code missing in project config or not assigned during execution]");
        }
        return patternCodeVal;
    }

    private static String fieldNameCheck(String argFieldName){
        String fldName = argFieldName;
        if (fldName.startsWith("[") && fldName.contains("]") ) {
            String[] fldSection = fldName.split("]");
            fldName = fldSection[1].trim();
        }
        if (fldName.contains("::")) {
            String[] fldInstSplit = fldName.trim().split("::");
            fldName = fldInstSplit[0].trim();
        }
//        System.out.println("=====>[fldName] => " + fldName);
        return fldName;
    }

    private static String fieldInstanceCheck(String argFieldName){
        if (argFieldName.contains("::")) {
            String[] fldInstSplit = argFieldName.trim().split("::");
            if (isNumeric(fldInstSplit[1].trim())) {
                varFieldInstFlag = true;
                return fldInstSplit[1].trim();
            } else {
                varFieldInstFlag = true;
                return "1";
            }
        } else {
            return "1";
        }
    }

    private static String fieldSectionCheck(String argFieldName){
        if (argFieldName.startsWith("[") && argFieldName.contains("]")) {
            String[] fSection = argFieldName.split("]");
            return fSection[0].replace("[","");
        } else {
            return "";
        }
    }
    private static String fieldLocationCheck(String argPageName){
        if (argPageName.contains("::")) {
            String[] fldLocSplit = argPageName.trim().split("::");
            return fldLocSplit[1].trim();
        } else {
            return "";
        }
    }

    private static String pageNameCheck(String argPage){
        if (argPage.contains("::")) {
            String[] pageSplit = argPage.trim().split("::");
            return pageSplit[0];
        } else {
            return argPage;
        }
    }

    private static String genCamelCase(String varCamelCase){
        return CaseUtils.toCamelCase(varCamelCase.replaceAll("[^a-zA-Z0-9_]", " "), false, ' ').trim();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static void logAutoLocatorEntry(String logType){
        if (logType.equalsIgnoreCase("label")) {
            if (getBundle().getPropertyValue("loc.pattern.log").trim().equalsIgnoreCase("true")) {
                if (!lastLocPrintVal.equals(varLocName)) {
                    System.out.println("==== AUTO GENERATED: LOCATOR (Pattern) ====> " + "loc.auto.label" + "=" + getBundle().getPropertyValue("loc.auto.label"));
                    lastLocPrintVal = varLocName;
                }
            }
        } else {
            if (getBundle().getPropertyValue("loc.pattern.log").trim().equalsIgnoreCase("true")) {
                if (!lastLocPrintVal.equals(varLocName)) {
                    System.out.println("==== AUTO GENERATED: LOCATOR (Pattern) ====> " + varLocName + "=" + getBundle().getPropertyValue(varLocName));
                    lastLocPrintVal = varLocName;
                }

            }
        }
    }


    private static String findAndReplaceXpath(String locEntries, String leftEntry, String rightEntry ){
        String replacedLocator = "[";

        if (locEntries.trim().startsWith("[") && locEntries.trim().endsWith("]")) {
            leftEntry = leftEntry.replaceAll("\"","");
            locEntries = locEntries.substring(1);
            locEntries = locEntries.substring(0, locEntries.length() - 1);
            String[] arrLoc = locEntries.split(",");
            int loopCount = 0;
            for (String loc: arrLoc) {
                loopCount++;
                if (loc.contains("xpath=//")) {
                    loc = loc.replace("xpath=",leftEntry);
                    loc = loc.substring(0, loc.length() - 1).trim() + rightEntry + "\"";
                    replacedLocator = (loopCount > 1) ? replacedLocator + "," + loc : replacedLocator + loc;
                } else {
                    replacedLocator = (loopCount > 1) ? replacedLocator + "," + loc : replacedLocator + loc;
                }
            }
            replacedLocator = replacedLocator + "]";
        } else {
            replacedLocator = locEntries;
        }
        return replacedLocator;
    }


}