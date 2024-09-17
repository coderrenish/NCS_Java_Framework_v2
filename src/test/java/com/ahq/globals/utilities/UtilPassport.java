package com.ahq.globals.utilities;
import java.util.Random;

public class UtilPassport {
    public static String generate(String country) {

        switch(country.toUpperCase()) {
            case "SINGAPORE":
            case "SGP":
                Random randomSgp = new Random();

                // Prefix for Singapore passport
                char prefix = 'E';

                // Generate a random 7-digit number
                int[] digitsSgp = new int[7];
                for (int i = 0; i < 7; i++) {
                    digitsSgp[i] = randomSgp.nextInt(10);  // Random digit between 0 and 9
                }

                // Weights for the calculation of the check digit
                int[] weightsSgp = {2, 7, 6, 5, 4, 3, 2};
                int totalSgp = 0;

                // Calculate the weighted sum of the digits
                for (int i = 0; i < digitsSgp.length; i++) {
                    totalSgp += digitsSgp[i] * weightsSgp[i];
                }

                // Find the remainder when total is divided by 11
                int remainder = totalSgp % 11;

                // Lookup table for check digit
                char[] checkDigits = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'Z', 'J'};

                // Determine the check digit based on the remainder
                char checkDigit = checkDigits[remainder];

                // Build the passport number string
                StringBuilder passportNumberSgp = new StringBuilder();
                passportNumberSgp.append(prefix);
                for (int digitSgp : digitsSgp) {
                    passportNumberSgp.append(digitSgp);
                }

                passportNumberSgp.append(checkDigit);
                return passportNumberSgp.toString();

            case "AUSTRALIA":
            case "AUS":
                Random randomAus = new Random();

                // First character is a letter (A-Z)
                char firstChar = (char) ('A' + randomAus.nextInt(26));

                // The rest are alphanumeric characters (letters or digits)
                StringBuilder passportNumberAus = new StringBuilder();
                passportNumberAus.append(firstChar);

                int length = 8;  // Choose either 8 or 9 characters for Australian passport numbers

                for (int i = 1; i < length; i++) {
                    if (randomAus.nextBoolean()) {
                        // Add a digit (0-9)
                        passportNumberAus.append(randomAus.nextInt(10));
                    } else {
                        // Add a letter (A-Z)
                        passportNumberAus.append((char) ('A' + randomAus.nextInt(26)));
                    }
                }
                return passportNumberAus.toString();

            default:
                return "<country not supported>";
        }

    }

}
