package com.atm.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.atm.exceptions.AuthenticationException;
import com.atm.exceptions.AuthorizationException;
import com.atm.exceptions.BankAccountNotFoundException;
import com.atm.exceptions.IdNotFoundException;
import com.atm.model.ErrorResponse;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ErrorResponse> authenticationExceptionHandler(AuthenticationException e){
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusText(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);
		
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ErrorResponse> authorizarionExceptionHandler(AuthorizationException e){
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusText(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);
		
	}
	
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ErrorResponse> missingRequestHeaderExceptionHandler(MissingRequestHeaderException e){
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusText(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);	
	}
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> bankAccountNotFoundExceptionHandler(BankAccountNotFoundException e){
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusText(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);	
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e){
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusText(HttpStatus.BAD_REQUEST.toString());
		response.setMessage("Bad Argument Type");
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);	
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorResponse> idNotFoundExceptionHandler(IdNotFoundException e){
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusText(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);	
	}
}
