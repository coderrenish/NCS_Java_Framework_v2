package com.ahq.globals.utilities;

public class UtilNricSingapore {
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
