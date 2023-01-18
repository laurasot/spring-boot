package com.laurasoto.licenciaManejo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laurasoto.licenciaManejo.modelos.License;
import com.laurasoto.licenciaManejo.modelos.Person;
import com.laurasoto.licenciaManejo.servicios.LicenseServicio;
import com.laurasoto.licenciaManejo.servicios.PersonServicio;

@Controller
public class LicenseControlador {
	private final LicenseServicio licenseServicio;
	private final PersonServicio personServicio;
	
	public LicenseControlador(LicenseServicio licenseServicio, PersonServicio personServicio) {
		this.licenseServicio = licenseServicio;
		this.personServicio = personServicio;
	}
	
//	@GetMapping("")
//	public String homeString() {
//		return"/cero";
//	}
	@RequestMapping("licenses/new")
    public String nuevoL(@ModelAttribute("license") License license, Model model){
		model.addAttribute("listaPersonas", personServicio.muestraPersonasSinLicencia());
        return "/nuevaLicencia";
    }
	
	@PostMapping("licenses/new")
    public String creaL(@Valid @ModelAttribute("license") License license, BindingResult result, Model model){
        if(result.hasErrors()){
			return "/nuevaLicencia";
        } else{
        	license.setNumber(license.numeroLicencia());
            licenseServicio.creaLicense(license);
            return "redirect:/persons/"+license.getPerson().getId();
        }
    }
}
