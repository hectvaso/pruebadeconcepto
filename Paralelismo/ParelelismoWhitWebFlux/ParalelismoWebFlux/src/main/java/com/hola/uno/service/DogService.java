package com.hola.uno.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.hola.uno.model.Dog;
import com.hola.uno.model.DogUno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DogService {

	WebClient webClient = WebClient.create("http://localhost:8087");
	WebClient webClient1 = WebClient.create("http://localhost:8086");

	RestTemplate restTemplate = new RestTemplate();
	 public Mono<Dog> getOtherDog(Long id) {
		 SimpleDateFormat sdf = new SimpleDateFormat ("aaaa-MM-dd HH: mm: ss SSS"); // Formato de fecha
	        System.out.println ("Va a llamar al servicio seis" + sdf.format (new Date ())); // El formato de fecha se convierte en String
		
		    return webClient.get()
		        .uri("/controladorseis/dogs/"+ id)
		        .retrieve()
		        .bodyToMono(Dog.class);
		}
	
	 public Mono<DogUno> getDog(Long id) {
		 SimpleDateFormat sdf = new SimpleDateFormat ("aaaa-MM-dd HH: mm: ss SSS"); // Formato de fecha
	        System.out.println ("Va a llamar al servicio cinco" + sdf.format (new Date ())); // El formato de fecha se convierte en String
		
		    return webClient1.get()
		        .uri("/controladorcinco/dogs/"+ id)
		        .retrieve()
		        .bodyToMono(DogUno.class);
		}
	 
	 public Flux<Object> fetchUserAndOtherUser(Long id, Long iddos) {
		 SimpleDateFormat sdf = new SimpleDateFormat ("aaaa-MM-dd HH: mm: ss SSS"); // Formato de fecha
	        System.out.println ("tiempo transcurrido despues de llamar a los servicios" + sdf.format (new Date ())); // El formato de fecha se convierte en String
		
		    return Flux.merge(getOtherDog(id), getDog(iddos));
		}
	
}
