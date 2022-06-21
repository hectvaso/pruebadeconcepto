package com.vanegas.reintentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanegas.reintentos.service.ReintentosService;

@RestController
public class ReintentosControler {

	 @Autowired
	    private ReintentosService service;

	    @GetMapping("/")
	    public String getValues() {
	        return service.fetchData();
	    }
	    
	    @GetMapping("/circuite")
	    public String getValuesDo() {
	        return service.fetchDataDos();
	    }
}
