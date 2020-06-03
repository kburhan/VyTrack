package com.vytrack.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {


    public static String getCurrentDate(String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }


    public static String getCurrentTime(String format) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(format));
    }


//format h:mm a
    public static long getTimeDifference(String start, String end,String format) {
        LocalTime startTime=LocalTime.parse(start,DateTimeFormatter.ofPattern(format));
        LocalTime endTime=LocalTime.parse(end,DateTimeFormatter.ofPattern(format));
      return ChronoUnit.HOURS.between(startTime,endTime);

    }
}






