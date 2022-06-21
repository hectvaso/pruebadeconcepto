package com.vanegas.retry.SpringRetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vanegas.retry.SpringRetry.service.RetryExampleService;

@RestController
public class RetryExampleController {

	@Autowired
	private RetryExampleService service;
	
	@GetMapping(value="/retry/{texto}")
	public ResponseEntity<?> result (@PathVariable String  texto){
		
		return ResponseEntity.ok(service.retryTemplateExample(texto));
		
	}
}
