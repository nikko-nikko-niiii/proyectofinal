package io.apiDevelopment.grupo2.proyectoFinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<String> handleBadRequest(BadRequestException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { NotFoundException.class })
	public ResponseEntity<String> handleNotFound(NotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = { UnauthorizedException.class })
	public ResponseEntity<String> handleUnauthorized(UnauthorizedException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}
}
