package com.laurasoto.EmpleadosGerentes.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laurasoto.EmpleadosGerentes.modelos.Employee;
import com.laurasoto.EmpleadosGerentes.servicios.EmployeeServicio;

@Controller
public class EmployeeControlador {
	private final EmployeeServicio employeeServicio;
	
	public EmployeeControlador(EmployeeServicio employeeServicio){
		this.employeeServicio = employeeServicio;
	}
    @GetMapping("/managers/nuevo")
    public String creaGerente(@ModelAttribute("gerente") Employee gerente){
        return "creaGerente";
    }

    @PostMapping("managers/nuevo")
    public String addGerentito(@Valid @ModelAttribute("gerente") Employee gerente, BindingResult result){
        if(result.hasErrors()){
            return "creaGerente";
        } else {
            employeeServicio.crearEmployee(gerente);
            return "redirect:/";
        }
    }
    
    @GetMapping("/managers/{idmanager}/new")
    public String setManagerAEmpleado(@ModelAttribute("employee") Employee empleado, @PathVariable("idmanager") Long idmanager, Model model){
        Employee manager = employeeServicio.encuentraGerentEmploye(idmanager);
        model.addAttribute("manager", manager);
        return "seteaEmpleado";
    }

    @PostMapping("/managers/{idmanager}/new")
    public String setmanagerAEmpleado(@PathVariable("idmanager") Long idmanager, @Valid @ModelAttribute("employee") Employee empleado,
    		BindingResult result){
        if(result.hasErrors()){
            return "seteaEmpleado";
        } else{
            Employee gerente = employeeServicio.encuentraGerentEmploye(idmanager);
            empleado.setManager(gerente);
            employeeServicio.crearEmployee(empleado);
            return "redirect:/";
        }
    }
    
    @GetMapping("/gerentes/{idmanager}/new")
    public String setGerente( @ModelAttribute("employee") Employee employee,@PathVariable("idmanager") Long idmanager,
    		Model model){
        Employee empleado2 = employeeServicio.encuentraGerentEmploye(idmanager);
        model.addAttribute("empleado2", empleado2);
        return "seteaGerente";
    }
   //se agrega un  gerente a un empleado, 
    @PostMapping("/gerentes/{idmanager}/new")
    public String seteGerente(@PathVariable("idmanager") Long idmanager, @ModelAttribute("employee") Employee empleado,
            BindingResult result){
        if(result.hasErrors()){
            return "seteaGerente";
        } else{
        	//busco el gerente por id
            Employee gerente = employeeServicio.encuentraGerentEmploye(idmanager);
            //se setea al empleado, el gerente encontrado
            empleado.setManager(gerente);
            employeeServicio.crearEmployee(empleado);
            return "redirect:/";
        }
    }
	//muestra todos los empleados de un gerente
	@GetMapping("/gerente/{idGerente}")
    public String muestraEmpleados(@PathVariable("idGerente") Long idGerente, Model model){
		//obtengo un gerente, lo envio con un model al jsp, ahi, muestro la lista de empleados que le pertenece
		//al gerente
        Employee gerente = employeeServicio.encuentraGerentEmploye(idGerente);
        model.addAttribute("gerente", gerente);
        return "muestraE";
    }
	
	//muestra un gerente de un empleado
    @GetMapping("/empleado/{id}")
    public String muestraGerente(@ModelAttribute("employee") Employee empleado, 
    		@PathVariable("id") Long id, Model model){
    	//encuentro un empleado a traves del pathvariable, lo envio al jsp con el model,
    	//en el model a ese empleado, busco el gerente que le corresponda
        Employee employee = employeeServicio.encuentraGerentEmploye(id);
        model.addAttribute("employee", employee);
        return "muestraG";
    }
    

}
