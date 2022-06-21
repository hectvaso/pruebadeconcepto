package com.vanegas.reintentos.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ReintentosService {

	@Value("${service2.url:http://localhost:8086/controladorcinco/dogs/1}")
    String serviceUrl;
	
	@Value("${http://localhost:8087/controladorseis/dogs/2}")
    String serviceUrlDos;

	
	/*metodo uno : usando circuite braker y retry a traves de archivo yaml */
    @Retry(name = "myRetry")
    public String fetchData() {
        System.out.println(" Making a request to " + serviceUrl + " at :" + LocalDateTime.now());

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceUrl, String.class);
    }

 
    
    /*metodo dos : usando circuite solo retry y resilience a traves de archivo yaml */
    @Retry(name = "myRetry", fallbackMethod = "fallback")
    public String fetchDataDos() {
        System.out.println(" Making a request to " + serviceUrlDos + " at :" + LocalDateTime.now());

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceUrlDos, String.class);
    }

    public String fallback(Exception e) {
        return "fallback value";
    }
}
