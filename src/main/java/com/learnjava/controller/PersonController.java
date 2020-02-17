package com.learnjava.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnjava.model.Person;

@RestController
public class PersonController {
	List<Person> personList = new ArrayList<Person>();
	@PostConstruct
	public void initIt() throws Exception {
		personList.add(new Person(1,"18:45","5847BNF", "02/02/2020"));
		personList.add(new Person(2,"12:45","1475MLF", "03/02/2020"));
		personList.add(new Person(3,"17:45","9856CRR", "01/02/2020"));
		personList.add(new Person(4,"9:45","9614YDC", "05/02/2020"));
 		
	}
	@RequestMapping("/")
	String home() {
		return "Lista de matriculas";
		
	}
	//otros lo vereis de esta forma:
		// @GetMapping("/get")
		// @PostMapping("/post")
		// @PutMapping("/put/{personId}")
		// @DeleteMapping("/delete/{personId}")
		
		
		@GetMapping("/listar")
		public List<Person> getAllPersons(){
			//Returns hardcoded data, a real world application would return from the database
			
			return personList;
		} 
		//un poco de teoria
		//¿Cuál es la diferencia entre @RequestParam y @PathVariable?
		
		//con @RequestParam
		//http://localhost:8080/books?isbn=1234
		//@GetMapping("/books/")
	    //public Book getBookDetails(@RequestParam("isbn") String isbn) {
		
		
		//public String welcome(@RequestParam(name="name", required=false, defaultValue="null") String name, @RequestParam(required=false, defaultValue="0") int age)
		
		//public String procesar(@RequestParam("mes") int mes) {
		//De este modo Spring hace por nosotros el trabajo de extraer el parámetro y convertir el tipo de String a int.
		
		
		//en cambio @PathVariable
		//http://localhost:8080/books/1234
		//@GetMapping("/books/{isbn}")
		//public Book getBook(@PathVariable("isbn") String isbn) {
		
		
		@GetMapping("/listar/{personId}")
		public Person getPersonWithId(@PathVariable Integer personId){
			//Returns hardcoded data, a real world application would return from the database
			
			 for(Person p : personList) {
		            if(p.getId()==personId) {
		            	return p;
		            	
		            }
		        }
			return null;
		} 
		
		
		@PostMapping("/insertar")
		public void addPerson(@RequestBody Person persona){
			//Just has a Sysout stmt, a real world application would save this record to the database
			System.out.println("Saving person information");
			personList.add(persona);
			
		}
		
		//un poco de teoria
		// put es un método para modificar recursos donde el cliente envía datos que actualizan TODO el recurso.
		//A diferencia de PUT, PATCH aplica una actualización parcial al recurso.
		//Supongamos que tenemos un recurso que contiene el nombre y el apellido de una persona.

		//Si queremos cambiar el nombre, enviamos una solicitud de actualización.

		//{ "first": "Michael", "last": "Angelo" } 
		//Aquí, aunque solo estamos cambiando el nombre, con la solicitud PUT tenemos que enviar ambos parámetros primero y último .
		//En otras palabras, es obligatorio enviar todos los valores nuevamente, la carga útil completa.

		//Sin embargo, cuando enviamos una solicitud PATCH, solo enviamos los datos que queremos actualizar. En otras palabras, solo enviamos el nombre para actualizar, no es necesario enviar el apellido.
		
		@PutMapping("/modificar/{personId}")
		public void updatePerson(@PathVariable Integer personId){
			//Just has a Sysout stmt, a real world application would save this record to the database
			System.out.println("Update person information");
			
		}
		
		@PatchMapping("/patch")
		public void patch() {
		   
		    System.out.println("modificando una persona con el metodo patch");
		}
		@DeleteMapping("/borrar/{personId}")
		public void deletePerson(@PathVariable Integer personId){
			//Just has a Sysout stmt, a real world application would save this record to the database
			System.out.println("Delete person information");
			personList.remove(personId-1);
			 
			
		}

}
