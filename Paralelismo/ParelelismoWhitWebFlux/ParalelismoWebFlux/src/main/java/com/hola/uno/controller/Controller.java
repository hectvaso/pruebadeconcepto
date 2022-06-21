package com.hola.uno.controller;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hola.uno.model.Dog;
import com.hola.uno.service.DogService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/orquestadorcuatro")
public class Controller {
	
	
    @Autowired
    private DogService service;
	
	
	@GetMapping(value = "/saludo")
    public ResponseEntity<?>  saludar(){

        return new ResponseEntity("hola servicio uno", HttpStatus.OK);
    }
	@GetMapping(value = "/saludo/{id}")
	public Flux<Object> getById(@PathVariable Long id)
	    {
		Long iddos = 2L;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		
		
		System.out.println ("arranca la peticion" ); // El formato de fecha se convierte en String
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		return service.fetchUserAndOtherUser(id, iddos);
	    }

}
