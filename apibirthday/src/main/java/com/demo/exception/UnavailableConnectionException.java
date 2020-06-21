package com.demo.exception;

/**
 *
 * @author Cristian Diaz
 */
public class UnavailableConnectionException extends Exception {
   
    public UnavailableConnectionException() {
        super();
    }
    
    public UnavailableConnectionException(String message) {
        super(message);
    }
    
}