/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cristian diaz
 * zentagroup
 */

@Data @AllArgsConstructor @NoArgsConstructor
public class Person implements Serializable{
    
    private String name;
    
    private String lastName;
    private String dateBirthday;
    private int age;
    private String message;
    private boolean birthDay;
    
}