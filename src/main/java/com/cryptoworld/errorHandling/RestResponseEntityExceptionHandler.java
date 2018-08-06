package com.cryptoworld.errorHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cryptoworld.model.RestError;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, Exception.class })
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Error reading your request. Please make valid request";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
   
    @ExceptionHandler({ NullPointerException.class })
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        return new ResponseEntity<Object>("Null Pointer Exception", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<RestError> handleAccessDeniedException(AccessDeniedException ex) {
    	
    	RestError errorError = new RestError();
    	errorError.setStatusCode(HttpStatus.FORBIDDEN.value());
    	errorError.setMessage("Access denied - message from controller advice");    	
        return new ResponseEntity<RestError>(errorError, new HttpHeaders(), HttpStatus.FORBIDDEN);
        
    }
    
    
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<RestError> handleException(RuntimeException ex) {
    	
    	RestError errorError = new RestError();
    	errorError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    	errorError.setMessage("Runtime Exception");    	
        return new ResponseEntity<RestError>(errorError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
}