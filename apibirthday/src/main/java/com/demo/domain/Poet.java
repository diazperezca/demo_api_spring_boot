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
 * @author Cristian Diaz
 * 
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Poet implements Serializable {
 
    private String name;
    private String url;
}