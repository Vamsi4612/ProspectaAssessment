package com.prospecta.exceptions;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(ProjectsException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(ProjectsException userExp, WebRequest req ){
		
		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(), userExp.getMessage(), req.getDescription(false) ) ;
		
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST) ;
	
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
	
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
					
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me)  {
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception ae,WebRequest req){
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ae.getMessage());
		error.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.NOT_FOUND);
	}

	
}
