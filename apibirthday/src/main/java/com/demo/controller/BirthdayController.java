/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.domain.Person;
import com.demo.exception.UnavailableConnectionException;
import com.demo.services.impl.BirthDayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristian Diaz
 * Zentagroup.com
 */

@Slf4j
@RestController
@CrossOrigin
public class BirthdayController {

    @Autowired
    private BirthDayServiceImpl birthDayServiceImpl;
    
    //@PostMapping("/api/validBirthday")
    @RequestMapping(value="/api/validBirthday", method=RequestMethod.POST)
    public ResponseEntity<?> validBirthday(@RequestBody Person person){
      
        log.info("Initial rest!!");
        log.info(person.toString());
        
        try{
            birthDayServiceImpl.validBirthDay(person);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        }catch(UnavailableConnectionException ex){
            log.error(ex.getMessage());
            return new ResponseEntity<Person>(person, HttpStatus.BAD_GATEWAY);
        }

    }
       
}