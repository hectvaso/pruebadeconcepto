package com.hola.uno.controller;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hola.uno.model.Dog;
import com.hola.uno.service.DogService;

@RestController
@RequestMapping("/controladorcinco")
public class Controller {
	
	@Autowired
	private DogService service;
	
	@GetMapping(value = "/saludo")
    public ResponseEntity<?>  saludar(){

        return new ResponseEntity("hola servicio cinco", HttpStatus.OK);
    }
	@GetMapping(value = "/dogs/{id}")
	public Dog getById(@PathVariable Long id)
	    throws InterruptedException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		
		System.out.println ("arranca entra al servicio cinco" ); // El formato de fecha se convierte en String
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
	  TimeUnit.of(ChronoUnit.SECONDS).sleep(5);
	  return service.getDogById(id);
	}


}
