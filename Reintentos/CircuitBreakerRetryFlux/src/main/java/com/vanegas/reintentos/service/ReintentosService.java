package com.vanegas.reintentos.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.vanegas.reintentos.model.Dog;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReintentosService {

	@Value("http://localhost:8086/controladorcinco/dogs")
    String serviceUrl;
	
	@Value("${http://localhost:8087/controladorseis/dogs}")
    String serviceUrlDos;

	WebClient webClient1 = WebClient.create("http://localhost:8086");
	WebClient webClient = WebClient.create("http://localhost:8087");
	
	
	
	/*metodo uno : usando circuite braker y retry a traves de archivo yaml */
	 @CircuitBreaker(name = "mockService", fallbackMethod = "fallback")
	 @Retry(name = "myRetry")
	 public Mono<Dog> fetchData() {
        System.out.println(" Making a request to " + serviceUrl + " at :" + LocalDateTime.now());

        return webClient1.get()
		        .uri("/controladorcinco/dogs")
		        .retrieve()
		        .bodyToMono(Dog.class)
        .doOnError(ex -> {
            throw new RuntimeException("the exception message is - "+ex.getMessage());
        });
       
    }
	 
	 /*metodo uno : usando circuite braker y retry a traves de archivo yaml */
	 @CircuitBreaker(name = "mockServiceDos", fallbackMethod = "fallback")
    public Mono<Dog> fetchDataDos() {
        System.out.println(" Making a request to " + serviceUrlDos + " at :" + LocalDateTime.now());

        return webClient.get()
                .uri("/controladorseis/dogs")
                .retrieve()
                .bodyToMono(Dog.class)
                .doOnError(ex -> {
                    throw new RuntimeException("the exception message is - "+ex.getMessage());
                });
    }
	 
	 public Flux<Object> fetchUserAndOtherUser() {
		 SimpleDateFormat sdf = new SimpleDateFormat ("aaaa-MM-dd HH: mm: ss SSS"); // Formato de fecha
	        System.out.println ("tiempo transcurrido despues de llamar a los servicios" + sdf.format (new Date ())); // El formato de fecha se convierte en String
	        Flux<Object> result = Flux.merge(fetchData(), fetchDataDos());
	      
		    return result;
		    
		}
	 
    public Mono<Dog> fallback(Throwable ex) {
        //Arrays.stream(ex.getStackTrace()).forEach(System.out::println);
        System.out.println("---> " + ex.getMessage());
        Dog mockServiceResponse = new Dog();
        mockServiceResponse.setServicio(ex.getMessage());
       
        return Mono.just(mockServiceResponse);
    }
}
