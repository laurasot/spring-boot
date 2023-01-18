package com.laurasoto.licenciaManejo.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laurasoto.licenciaManejo.modelos.Person;
import com.laurasoto.licenciaManejo.servicios.PersonServicio;

@Controller
public class PersonControlador {
	private final PersonServicio personServicio;
	public PersonControlador(PersonServicio personServicio) {
		this.personServicio = personServicio;	
	}
	@GetMapping("")
	public String homeString() {
		return"/cero";
	}
	
	@RequestMapping("/new")
    public String nuevoP(@ModelAttribute("person") Person person){
        return "/home";
    }

    @PostMapping("/new")
    public String creaP(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if(result.hasErrors()){
            return "/home";
        } else{
            personServicio.creaPerson(person);
            return "redirect:/";
        }
    }
    
    @GetMapping("persons/{id}")
    public String mostrarPerson(@PathVariable Long id,Model model) {
    	Person person= personServicio.mostrarPersona(id);
    	model.addAttribute("person", person);
    	return("/mostrar");
    }
    
    
}
