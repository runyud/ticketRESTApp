package com.ticket.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicketRestExceptionHandler {

	// an exception for Ticket Not Found exception
	@ExceptionHandler
	public ResponseEntity<TicketErrorResponse> handleException(TicketNotFoundException e) {
		TicketErrorResponse err = new TicketErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<TicketErrorResponse>(err, HttpStatus.NOT_FOUND);
	}
	
	// generic exception handler
	@ExceptionHandler
	public ResponseEntity<TicketErrorResponse> handleException(Exception e) {
		TicketErrorResponse err = new TicketErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<TicketErrorResponse>(err, HttpStatus.BAD_REQUEST);
	}
}
