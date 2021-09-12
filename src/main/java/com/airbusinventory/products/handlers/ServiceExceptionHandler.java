package com.airbusinventory.products.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.airbusinventory.products.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ProductNotFoundException.class)
	protected ResponseEntity<Object> handleProductNotFound(RuntimeException exception, WebRequest request) {
		return handleExceptionInternal(exception, "Product not found", new HttpHeaders(), HttpStatus.NOT_FOUND,
				request);
	}

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Object> handleUndefinedExceptions(RuntimeException exception, WebRequest request) {
		return handleExceptionInternal(exception, "Some internal error", new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
