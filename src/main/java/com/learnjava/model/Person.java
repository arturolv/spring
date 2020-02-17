package com.learnjava.model;

public class Person {
	
	private int id;
	private String hora;
	private String matricula;
	private String fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Person(){
		
	}
	
	public Person(int id, String hora,String matricula, String fecha) {
		super();
		this.id=id;
		this.hora=hora;
		this.matricula = matricula;
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getfecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
