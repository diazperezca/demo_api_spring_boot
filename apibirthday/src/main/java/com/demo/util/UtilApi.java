package com.demo.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Zentagroup, Cristian Diaz (cristian.diaz@zentagroup.com)
 * @version 1.0 
 * @Created 18/06/2020 14:30
 */

@Slf4j
@Component
public final class UtilApi {
    
    /**
     * Method that calculates if today is your birthday
     */
    public boolean isBirthDay(String dateBirth){
    
        LocalDate myBirthDate = getDateFromString(dateBirth);
        LocalDate dateNow = LocalDate.now();
        
        if (dateNow.getMonthValue() == myBirthDate.getMonthValue() && 
                dateNow.getDayOfMonth() == (myBirthDate.getDayOfMonth())  ){
            log.info("Today is your birthday!!");
            return true;
        }
      
        log.info("It's not your birthday today");
        
        return false; 
    }
    
    /**
     * Method that calculates the days between two dates
     */
    public int getDaysBetweenDates(String date){
    
        LocalDate today = LocalDate.now();

        LocalDate birthday = getDateFromString(date);
        LocalDate nextBDay = birthday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        long totalDias = ChronoUnit.DAYS.between(today, nextBDay);
         
        log.info("Days missing for your birthday: " + totalDias);

        return (int)totalDias;
    }
    
    /**
     * Method that calculates age
     */
    public int getAge(String date) throws DateTimeParseException{
    
        LocalDate currentTime = LocalDate.now();
        LocalDate myBirthDate = getDateFromString(date);
 
        Period period = Period.between(myBirthDate, currentTime);

        log.info("Your age is: " + period.getYears());
        
        return period.getYears();
    }

    /**
     * Method that converts a date in string format to LocalDate
     */    
    public LocalDate getDateFromString(String date) throws DateTimeParseException{
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(ConstantApi.FORMAT_DATE_SH);
        LocalDate localDate = LocalDate.parse(date, fmt);
        return localDate;
    }
}