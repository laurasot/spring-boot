package com.laurasoto.listaEstudiantes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.aspectj.apache.bcel.classfile.annotation.TypeAnnotationGen;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.listaEstudiantes.Services.ApiService;
import com.laurasoto.listaEstudiantes.models.Contact;
import com.laurasoto.listaEstudiantes.models.Student;

@Controller
public class ApiController {
	private final ApiService apiService;
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	@GetMapping("/")
	public String home() {
		return"home";
	}
	
	@GetMapping("/students")
	public String creaStudent(@ModelAttribute("student") Student student) {
		return"/creaEstudiante";
	}
	
	//los datos que envia usuario para crear nuevo estudiante
	//hay que crear los estudiantes en la ruta?
	 @RequestMapping(value="/students/create", method=RequestMethod.GET)
	 public String crearS(@Valid @ModelAttribute("student") Student student, 
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") int age,
			BindingResult result) {
		    //preguntar aqui que es lo que valida?
		 	 if(result.hasErrors()) {
		 		 return "/";
		 	 }
	    	 //si no hay error, crear variable estudiante, que crea un nuevo estudiante con 3 parametros (nombre, apellido, año)
	    	 //se guarda este nuevo estudiante con el metodo creaStudent
	         Student estudiante = new Student(firstName, lastName, age);
	         apiService.creaStudent(estudiante);
	         return"/creaEstudiante";
	     }
	 
	 @GetMapping("/contacts/")
		public String creaContact(@ModelAttribute("contact") Contact contact) {
			return"/creaContact";
		}
	 
	 @RequestMapping(value="/contacts/create", method=RequestMethod.GET)
	 public String crearC( 
			@RequestParam("student") Long id,
			@RequestParam("address") String address,
			@RequestParam("city") String city,
			@RequestParam("state") String state) {

		     Student student =	apiService.studentId(id);
	    	 //si no hay error, crear variable estudiante, que crea un nuevo estudiante con 3 parametros (nombre, apellido, año)
	    	 //se guarda este nuevo estudiante con el metodo creaStudent
	         Contact contacto = new Contact(student, address,city, state);
	         apiService.creaContact(contacto);
	         return"/creaEstudiante";
	     }
	//mostrar todos los estudiantes
	 @GetMapping("/estudiantes")
	 public String mostrar(Model model) {
		 List<Student> estudiantes = apiService.mostrarStudent();
		 model.addAttribute("estudiantes", estudiantes);
		 return"/todosEstudiantes";
	 } 
}
