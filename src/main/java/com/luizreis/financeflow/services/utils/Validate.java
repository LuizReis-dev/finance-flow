package com.luizreis.financeflow.services.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

public class Validate {

    private static final LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    public static LocalDate validateMaxDate(String maxDate) {
        LocalDate max;
        try{
            max = LocalDate.parse(maxDate);
        }catch(DateTimeParseException e){
            max = today;
        }
        return max;
    }

    public static LocalDate validateMinDate(String minDate){
        LocalDate min;
        try{
            min = LocalDate.parse(minDate);
        }catch(DateTimeParseException e){
            min = today.minusMonths(1L);
        }
        return min;
    }
}
