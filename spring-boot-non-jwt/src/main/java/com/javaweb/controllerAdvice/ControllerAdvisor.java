package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.errorResponseDTO;

import customException.FieldRequireException;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
    		ArithmeticException ex , WebRequest request) {

      errorResponseDTO errorResponseDTO = new errorResponseDTO();
      errorResponseDTO.setError(ex.getMessage());
      List<String> details = new ArrayList<String>();
      details.add("ko chia được cho số 0");
      errorResponseDTO.setDetail(details);
      
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
	 @ExceptionHandler(FieldRequireException.class)
	    public ResponseEntity<Object> handleArithmeticException(
	    		FieldRequireException ex , WebRequest request) {

	      errorResponseDTO errorResponseDTO = new errorResponseDTO();
	      errorResponseDTO.setError(ex.getMessage());
	      List<String> details = new ArrayList<String>();
	      details.add("name or numberofbasement");
	      errorResponseDTO.setDetail(details);
	      
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
		}

}