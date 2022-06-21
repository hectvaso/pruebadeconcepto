package com.hola.uno.model;



public class Dog {
	
	
	 private Long id;

	   
	    private String nombre;

	    
	    private String raza;
	    
	    private String servicio;

		public Long getId() {
			return id;
		}

		public String getServicio() {
			return servicio;
		}

		public void setServicio(String servicio) {
			this.servicio = servicio;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getRaza() {
			return raza;
		}

		public void setRaza(String raza) {
			this.raza = raza;
		}
	    
	    


	}
