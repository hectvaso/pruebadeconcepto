package com.hola.uno.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hola.uno.model.Dog;

@Service
public class DogService {

	
	
	public Dog getDogById(Long id){
      
       
Dog dog = new Dog();
Dog dog1 = new Dog();
Dog dog2= new Dog();
Dog dog3 = new Dog();
Dog resul = new Dog();

List <Dog> list = new ArrayList<>();

dog.setId(1L);
dog.setNombre("perro");
dog.setRaza("Pastor Aleman");
dog.setServicio("seis");
dog.setClase("perro");

dog1.setId(2L);
dog1.setNombre("perro");
dog1.setRaza("Chacahu");
dog1.setServicio("seis");
dog.setClase("perro");


dog2.setId(3L);
dog2.setNombre("perro");
dog2.setRaza("DobermANT");
dog2.setServicio("seis");
dog.setClase("perro");


dog3.setId(4L);
dog3.setNombre("perro");
dog3.setRaza("chancodso");
dog3.setServicio("seis");
dog.setClase("perro");


list.add(dog);
list.add(dog1);
list.add(dog2);
list.add(dog3);

	for(Dog doa : list)
	{
	       if(doa.getId() == id) {
	    	   resul = doa;
	       }
	
	    }
	return resul;
	}
}
