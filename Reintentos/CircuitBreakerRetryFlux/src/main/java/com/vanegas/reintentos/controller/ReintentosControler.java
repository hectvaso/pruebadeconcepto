package com.vanegas.reintentos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanegas.reintentos.model.Dog;
import com.vanegas.reintentos.service.ReintentosService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orquestadorcinco")
public class ReintentosControler {

	 @Autowired
	    private ReintentosService service;
	
	 
	 Logger logger = Logger.getLogger(ReintentosControler.class.getName());
		
	    
	    @GetMapping(value = "/saludo")
		public Mono<Dog> getById()
		    {
		
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			
			
			System.out.println ("arranca la peticion" ); // El formato de fecha se convierte en String
			Date date = new Date(System.currentTimeMillis());
			System.out.println(formatter.format(date));
			return service.fetchDataDos();
		    }
	    @GetMapping(value = "/saludo/merge")
		public Flux<Object>   mergeFlux()
		    {
	    	 logger.info("antes de llamar a los servicios");
			Flux<Object> resul = service.fetchUserAndOtherUser();
			 logger.info("despues de llamar al servicio");
			
			
			return resul;
			
		    }
/*
	    @GetMapping(value = "/saludodos/{id}")
		public Mono<Dog> getByIdDos(@PathVariable Long id)
		    {
			Long iddos = 2L;
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			
			
			System.out.println ("arranca la peticion" ); // El formato de fecha se convierte en String
			Date date = new Date(System.currentTimeMillis());
			System.out.println(formatter.format(date));
			return service.fetchData(id);
		    }
*/
}
