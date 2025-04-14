package com.ahq.globals.utilities;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class UtilDateTime {
    
    /**
     * Returns Current Data with default Format
     */
    public static String currentDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }
    
    /**
     * Returns Current Data plus an additional number of days, with default Format
     *
     * @param numberOfAdditionalDays [int] [Additional number of Days to the current date]
     */
    public static String currentDatePlusAdditionalDays(int numberOfAdditionalDays) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDatePlusAdditionalDays = localDate.plusDays(numberOfAdditionalDays);
        return localDatePlusAdditionalDays.toString();
    }
    
    /**
     * Returns Current Data plus an additional number of days, with given Format
     *
     * @param format                 [String] [Date Format: dd/MM/yyyy, M/dd/yyyy, yy/MM/dd]
     * @param numberOfAdditionalDays [int] [Additional number of Days to the current date]
     */
    public static String currentTimeWithFormatPlusAdditionalDays(String format, int numberOfAdditionalDays) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTimePlusAdditionalDays = localDateTime.plusDays(numberOfAdditionalDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(localDateTimePlusAdditionalDays);
    }

    public static String currentTimeWithFormatPlusAdditionalYears(String format, int numberOfAdditionalYears) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTimePlusAdditionalDays = localDateTime.plusYears(numberOfAdditionalYears);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(localDateTimePlusAdditionalDays);
    }
    
    public static String dateWithFormatAndBusinessDaysFromCurrent(String format, int numberOfAdditionalDays) {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        // Skip weekends (Saturday and Sunday)
        for (int i = 0; i < Math.abs(numberOfAdditionalDays); i++) {
            do {
                if (numberOfAdditionalDays < 0)
                    currentDate = currentDate.minusDays(1);
                else if (numberOfAdditionalDays > 0)
                    currentDate = currentDate.plusDays(1);
            } while (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY);
        }
        return currentDate.format(formatter);
    }


    /**
     * Returns the first day of the current month in the given format.
     * @param format The date format pattern (e.g., "dd/MM/yyyy").
     */
    public static String firstDayOfCurrentMonth(String format) {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return firstDay.format(formatter);
    }

    /**
     * Returns the last day of the current month in the given format.
     * @param format The date format pattern (e.g., "dd/MM/yyyy").
     */
    public static String lastDayOfCurrentMonth(String format) {
        LocalDate today = LocalDate.now();
        LocalDate lastDay = today.withDayOfMonth(today.lengthOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return lastDay.format(formatter);
    }

    /**
     * Returns the first day of the next month in the given format.
     * @param format The date format pattern (e.g., "dd/MM/yyyy").
     */
    public static String firstDayOfNextMonth(String format) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayNext = today.plusMonths(1).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return firstDayNext.format(formatter);
    }

    /**
     * Returns the last day of the next month in the given format.
     * @param format The date format pattern (e.g., "dd/MM/yyyy").
     */
    public static String lastDayOfNextMonth(String format) {
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate lastDayNext = nextMonth.withDayOfMonth(nextMonth.lengthOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return lastDayNext.format(formatter);
    }

    /**
     * Returns Current Data & Time with default Format
     */
    public static String currentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.toString();
    }
    
    /**
     * Returns Current Data with Format
     *
     * @param format [Format: dd/MM/yyyy, yy/MM/dd]
     */
    public static String currentDateWithFormat(String format) {
        // Eg: format: dd/MM/yyyy, yy/MM/dd
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
    
    /**
     * Returns Current Time with Format
     *
     * @param format [Format: hh:mm:ss , hh:mm]
     */
    public static String currentTimeWithFormat(String format) {
        // Eg: format: hh:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
