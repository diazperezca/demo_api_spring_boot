package com.demo.services.service;

import com.demo.domain.Person;
import com.demo.domain.Poema;
import com.demo.exception.UnavailableConnectionException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cristian Diaz
 * 
 */

@Component
public interface BirthDayService {
    
   public Poema[] getPoems() throws UnavailableConnectionException;
   
   public Person validBirthDay(Person person) throws UnavailableConnectionException;
   
   
}