package com.ahq.globals.utilities;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilNricSingapore {
    public static String generateByYearAndPrefix(String prefix, Integer year, Boolean isForeigner) {
        Random random = new Random();
        // Generate a random year between 1960 and 2019 if year is not provided
        int randomYear = random.nextInt(60) + 1960;
        int resolvedYear = (year != null) ? year : randomYear;
        boolean resolvedIsForeigner = (isForeigner != null) ? isForeigner : false;

        // Determine the prefix if not provided
        String resolvedPrefix = prefix;
        if (resolvedPrefix == null || resolvedPrefix.isEmpty()) {
            if (resolvedIsForeigner) {
                resolvedPrefix = (resolvedYear >= 2000) ? "G" : "F";
            } else {
                resolvedPrefix = (resolvedYear >= 2000) ? "T" : "S";
            }
        }

        // Validate prefix based on isForeigner flag
        boolean validPrefix = false;
        if (!resolvedIsForeigner && (resolvedPrefix.equals("S") || resolvedPrefix.equals("T"))) {
            validPrefix = true;
        } else if (resolvedIsForeigner && (resolvedPrefix.equals("F") || resolvedPrefix.equals("G"))) {
            validPrefix = true;
        }
        if (!validPrefix) {
            throw new IllegalArgumentException("❌ Invalid prefix \"" + resolvedPrefix + "\" for isForeigner=" + resolvedIsForeigner +
                    ". Use S/T for citizens and F/G for foreigners.");
        }

        // Get the last two digits of the year and pad with a zero if necessary
        String yearDigits = String.format("%02d", resolvedYear % 100);

        // Generate 5 random digits (each between 0-9)
        StringBuilder sb = new StringBuilder();
        sb.append(yearDigits);
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        // The full numeric part of the NRIC is 7 digits (2 from the year + 5 random digits)
        String fullDigitsStr = sb.toString();
        int[] fullDigits = new int[7];
        for (int i = 0; i < 7; i++) {
            fullDigits[i] = Character.getNumericValue(fullDigitsStr.charAt(i));
        }

        // Weights for checksum calculation
        int[] weights = {2, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += fullDigits[i] * weights[i];
        }

        // If the prefix indicates a person born in or after 2000, add an offset of 4
        if (resolvedPrefix.equals("T") || resolvedPrefix.equals("G")) {
            sum += 4;
        }

        int remainder = sum % 11;
        // Checksum lookup tables for Singapore citizens/PR and foreigners respectively
        String[] checksumST = {"J", "Z", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        String[] checksumFG = {"X", "W", "U", "T", "R", "Q", "P", "N", "M", "L", "K"};

        String checksum;
        if (resolvedPrefix.equals("S") || resolvedPrefix.equals("T")) {
            checksum = checksumST[remainder];
        } else {
            checksum = checksumFG[remainder];
        }

        return resolvedPrefix + fullDigitsStr + checksum;
    }

    public static Integer getYearFromNRIC(String nric) {
        // Define the expected NRIC pattern: starts with one of S, T, F, or G, followed by 7 digits and one letter.
        Pattern pattern = Pattern.compile("^[STFG]\\d{7}[A-Z]$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nric);

        if (!matcher.matches()) {
            System.err.println("❌ Invalid NRIC format: " + nric);
            return null;
        }

        // Get the prefix and extract the two-digit year part
        char prefix = Character.toUpperCase(nric.charAt(0));
        String yearPart = nric.substring(1, 3);

        int yearDigits;
        try {
            yearDigits = Integer.parseInt(yearPart);
        } catch (NumberFormatException e) {
            return null;
        }

        switch (prefix) {
            case 'S': // Born before 2000 (Singaporean)
            case 'F': // Foreigner before 2000
                return 1900 + yearDigits;

            case 'T': // Born in or after 2000 (Singaporean)
            case 'G': // Foreigner in or after 2000
                return 2000 + yearDigits;

            default:
                return null;
        }
    }

    public static String generate(String prefix, String ageStr) {
//        String prefix = "G";
//        String ageStr = "1990-2000";
        int total = 0, offset = 0;
        String alpha = "";

        // Parse age to an integer
        int age = parseAge(ageStr);

        // Validate age
        if (!(age >= -1 && age <= 9)) {
            age = -1;
        }

        // Validate prefix
        if (!prefix.equals("S") && !prefix.equals("T") && !prefix.equals("F") && !prefix.equals("G")) {
            System.out.println("[ERROR] => NRIC => Prefix should start with S, T, F or G");
            return null; // Exit early as the prefix is invalid
        }

        // NRIC generator algorithm
        String[] nricArray = pad((int) (Math.random() * 9999999), 7).split("");
        if (age != -1) nricArray[0] = String.valueOf(age);

        String numberOutput = prefix + String.join("", nricArray);

        // Calculating weights for the NRIC digits
        nricArray[0] = String.valueOf(Integer.parseInt(nricArray[0]) * 2);
        nricArray[1] = String.valueOf(Integer.parseInt(nricArray[1]) * 7);
        nricArray[2] = String.valueOf(Integer.parseInt(nricArray[2]) * 6);
        nricArray[3] = String.valueOf(Integer.parseInt(nricArray[3]) * 5);
        nricArray[4] = String.valueOf(Integer.parseInt(nricArray[4]) * 4);
        nricArray[5] = String.valueOf(Integer.parseInt(nricArray[5]) * 3);
        nricArray[6] = String.valueOf(Integer.parseInt(nricArray[6]) * 2);

        // Calculate total sum
        for (int i = 0; i <= 6; i++) {
            total += Integer.parseInt(nricArray[i]);
        }

        // Set offset based on prefix
        if (prefix.equals("G") || prefix.equals("T")) {
            offset = 4;
        } else {
            offset = 0;
        }

        int remainderMod = (total + offset) % 11;

        String[] foreigner = {"X", "W", "U", "T", "R", "Q", "P", "N", "M", "L", "K"};
        String[] singaporean = {"J", "Z", "I", "H", "G", "F", "E", "D", "C", "B", "A"};

        if (prefix.equals("T") || prefix.equals("S")) {
            alpha = singaporean[remainderMod];
        } else if (prefix.equals("G") || prefix.equals("F")) {
            alpha = foreigner[remainderMod];
        } else {
            alpha = null;
        }

        if (alpha == null) {
            return null;
//            System.out.println("NULL");
        } else {
            return numberOutput + alpha;
//            System.out.println(numberOutput + alpha);
        }
    }

    // Helper method to pad numbers with zeros to a specified size
    private static String pad(int num, int size) {
        String temp = "0000000" + num;
        return temp.substring(temp.length() - size);
    }

    // Helper method to parse the age from a string
    private static int parseAge(String age) {
        try {
            return Integer.parseInt(age.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            return -1; // Return -1 if parsing fails
        }
    }

    public static Boolean validate(String nric_code) {
        // TO BE DEVELOPED
        return true;
    }

}
