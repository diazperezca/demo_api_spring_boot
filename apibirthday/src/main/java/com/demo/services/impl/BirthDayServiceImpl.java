package com.demo.services.impl;

import com.demo.domain.Person;
import com.demo.domain.Poema;
import com.demo.exception.UnavailableConnectionException;
import com.demo.services.service.BirthDayService;
import com.demo.util.ConstantApi;
import com.demo.util.UtilApi;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Cristian Diaz
 * 
 */

@Slf4j
@Service
public class BirthDayServiceImpl implements BirthDayService{

    
    private static final String template = ConstantApi.TEXT_DEFAULT;
    
    @Autowired
    private UtilApi util;
    
    @Override
    public Poema[] getPoems() throws UnavailableConnectionException{
        
        RestTemplate rest = new RestTemplate();
        Poema[] poema;
        try{
             poema = rest.getForObject(ConstantApi.URI_POEMS, Poema[].class);
        }catch(Exception ex){
            log.error(ex.getMessage());
            throw new UnavailableConnectionException(ex.getMessage());
        }
        
        return poema;
    }

    @Override
    public Person validBirthDay(Person person) throws UnavailableConnectionException {
        
        person.setAge(util.getAge(person.getDateBirthday()));
        
        //validar si esta de cumpleanos > poema
        if(util.isBirthDay(person.getDateBirthday())){
            Poema[] poemas = this.getPoems();
            int numero = (int) (Math.random() * poemas.length);
            
            person.setBirthDay(true);
            person.setMessage(poemas[numero].getContent());
        }else{
            //de lo contrario mensaje de que faltan x dias
            person.setBirthDay(false);
            person.setMessage(String.format(template, util.getDaysBetweenDates(person.getDateBirthday())));
        }
               
        return person;
    }
    
}
