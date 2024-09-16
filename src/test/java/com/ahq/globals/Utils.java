package com.ahq.globals;

import com.ahq.addons.utilsExcel;
import com.ahq.globals.utilities.*;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.cucumber.java.en.And;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    /**
     * Switches the webdriver context to the parent frame
     * : I switch to parent window
     * [Note: Returns value]
     */
    @QAFTestStep(description = "Utils: Generate Singapore NRIC with type {0} and age {1} into variable {2}")
    @And("Utils: Generate Singapore NRIC with type {string} and age {string} into variable {string}")
    public static void generateSingaporeNricToVar_Utils(String type, String age, String varName) {
        String NRIC = Utils.nric_singapore_generate(type, age);
        BrowserGlobal.iStoreValueIntoVariable(NRIC, varName);
    }

    @QAFTestStep(description = "Utils: Encrypt password {0} and print")
    @And("Utils: Encrypt password {string} and print")
    public static void encryptPasswordAndPrint_Utils(String password) throws Exception {
        BrowserGlobal.iComment("== Encrypted Password is: " + password_encrypt(password));
    }

    @QAFTestStep(description = "Utils: Generate date from current date by plus or minus days {0} into variable {1}")
    @And("Utils: Generate date from current date by plus or minus days {string} into variable {string}")
    public static void generateDateFromCurrentDateByPlusOrMinusDays_Utils(String days, String varName) throws Exception {
        String dateGenerated = dateTime_currentTimeWithFormatPlusAdditionalDays("dd/mm/yyyy",Integer.parseInt(days));
        BrowserGlobal.iStoreValueIntoVariable(dateGenerated, varName);
    }

    @QAFTestStep(description = "Utils: Generate date from current date by plus or minus years {0} into variable {1}")
    @And("Utils: Generate date from current date by plus or minus years {string} into variable {string}")
    public static void generateDateFromCurrentDateByPlusOrMinusYears_Utils(String years, String varName) throws Exception {
        String dateGenerated = dateTime_currentTimeWithFormatPlusAdditionalYears("d/m/yyyy",Integer.parseInt(years));
        BrowserGlobal.iStoreValueIntoVariable(dateGenerated, varName);
    }

    @QAFTestStep(description = "Utils: Write to Excel File:{0} Sheet:{1} CellData:{2}")
    @And("Utils: Write to Excel File:{string} Sheet:{string} CellData:{string}")
    public static void writeToExcel_Utils(String file, String sheet, String cellData) throws Exception {
        utilsExcel.writeToExcel(file,sheet,cellData);
    }

    public static String nric_singapore_generate(String prefix, String ageStr) { return UtilNricSingapore.generate(prefix, ageStr); }
    //    public static String nric_singapore_validate(String nric) { return UtilNricSingapore.validate(nric); } // TO BE DEVELOPED

    public static String passport_generate(String country) { return UtilPassport.generate(country); }

    public static String password_encrypt(String encryptedPassword) { return UtilPassword.encrypt(encryptedPassword);}
    public static String password_decrypt(String password) { return UtilPassword.decrypt(password);}
    public static String password_check(String password) { return UtilPassword.check(password);}
    public static String base64_decrypt(String base64String) { return UtilBase64.decrypt(base64String);}

    //Date & Time Utils
    public static String dateTime_currentDate() { return UtilDateTime.currentDate();}
    public static String dateTime_currentDatePlusAdditionalDays(int numberOfAdditionalDays) { return UtilDateTime.currentDatePlusAdditionalDays(numberOfAdditionalDays);}
    public static String dateTime_currentTimeWithFormatPlusAdditionalDays(String timeFormat, int numberOfAdditionalDays) { return UtilDateTime.currentTimeWithFormatPlusAdditionalDays(timeFormat,numberOfAdditionalDays);}
    public static String dateTime_currentTimeWithFormatPlusAdditionalYears(String timeFormat, int numberOfAdditionalYears) { return UtilDateTime.currentTimeWithFormatPlusAdditionalYears(timeFormat,numberOfAdditionalYears);}

    public static String dateTime_currentDateTime() { return UtilDateTime.currentDateTime();}
    public static String dateTime_currentDateWithFormat(String dateFormat) { return UtilDateTime.currentDateWithFormat(dateFormat);}
    public static String dateTime_currentTimeWithFormat(String timeFormat) { return UtilDateTime.currentTimeWithFormat(timeFormat);}

    public static String dataChecker(String data) throws Exception {
        if (data.contains("~{") && data.contains("}")) {
            List<String> genEntries = extractBetweenDelimiters("GEN",data);
            for (String genEntry : genEntries) {
                String tempEntry = genEntry;
                String[] generator = genEntry.trim().split("::");
                String genType = generator[0].trim();
                String genVal1 = (generator.length > 1) ? generator[1].trim() : "";
                String genVal2 = (generator.length > 2) ? generator[2].trim() : "";
                String genVal3 = (generator.length > 3) ? generator[3].trim() : "";
                String genVal4 = (generator.length > 4) ? generator[4].trim() : "";

                if (genType.toUpperCase().equalsIgnoreCase("NRIC")) {
                    data = data.replaceFirst("~\\{" + tempEntry + "}", nric_singapore_generate(genVal1,genVal2)) ;
                } else if (genType.toUpperCase().equalsIgnoreCase("PASSPORT")) {
                    data = data.replaceFirst("~\\{" + tempEntry + "}", passport_generate(genVal1)) ;
                } else if (genType.toUpperCase().equalsIgnoreCase("PWD.ENCRYPT")) {
                    return "GENERATED ENCRYPTED PASSWORD";
                } else if (data.toUpperCase().startsWith("~.PWD.DECRYPT")) {
                    return "GENERATED DECRYPTED PASSWORD";
                }
            }
        }
        return data;
    }

    public static int[] excelCellToIndexConverter(String cell) {
        // Separate letters and numbers
        String columnPart = cell.replaceAll("[^A-Z]", ""); // Extracts column letters (e.g., "A")
        String rowPart = cell.replaceAll("[^0-9]", "");    // Extracts row number (e.g., "2")

        int result = 0;
        int colLength = columnPart.length();

        for (int i = 0; i < colLength; i++) {
            result *= 26; // Move to the next base-26 place value
            result += (columnPart.charAt(i) - 'A' + 1); // Calculate value for this letter
        }
        int columnIndex = result - 1;
        int rowIndex = Integer.parseInt(rowPart) - 1; // Convert to 0-based index

        return new int[]{rowIndex, columnIndex};
    }



    public static List<String> extractBetweenDelimiters(String type,String input) {
        List<String> results = new ArrayList<>();
        // Define the regular expression pattern to match content between "~{" and "}"
        String regex = "~\\{(.*?)}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find all matches and add them to the results list
        while (matcher.find()) {
            results.add(matcher.group(1));  // Add the extracted text (group 1) to the list
        }

        return results;
    }

}
