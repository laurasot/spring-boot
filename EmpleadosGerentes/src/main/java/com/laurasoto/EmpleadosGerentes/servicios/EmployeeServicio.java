package com.laurasoto.EmpleadosGerentes.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurasoto.EmpleadosGerentes.modelos.Employee;
import com.laurasoto.EmpleadosGerentes.repositorios.EmployeeRepositorio;

@Service
public class EmployeeServicio {
	private final EmployeeRepositorio employeeRepositorio;
	
	public EmployeeServicio(EmployeeRepositorio employeeRepositorio){
		this.employeeRepositorio = employeeRepositorio;
	}
	//antes de buscar empleados, hay que hacer empleados
	public Employee crearEmployee(Employee employee) {
		return employeeRepositorio.save(employee);
	}
	//muestra una lista de todos los empleados
	public List<Employee> todosEmpleados(){
        List<Employee> empleados = employeeRepositorio.findAll();
        return empleados;
    }
	
	
	//retorna un empleado, retorna un gerente?
	//se busca empleado opcional, si existe se obtiene, sino retorna nulo
	public Employee encuentraGerentEmploye(Long id) {
		 Optional<Employee> optionalEmployee = employeeRepositorio.findById(id);
		 if(optionalEmployee.isPresent()) {
	         return optionalEmployee.get();
	     } else {
	         return null;
	     }
	}
	
}
