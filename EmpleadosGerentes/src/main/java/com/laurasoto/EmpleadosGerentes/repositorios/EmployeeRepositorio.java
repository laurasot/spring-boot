package com.laurasoto.EmpleadosGerentes.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.EmpleadosGerentes.modelos.Employee;

@Repository
public interface EmployeeRepositorio extends CrudRepository<Employee, Long> {
	//obtiene todos los empleados por medio de gerente que lo contengan, el parametro  empleado es gerente????
	//List<Employee> findByManagerContaining(Employee manager);
	//buscar empleado por gerente
	//Employee findByManager(Employee manager);
	
	List<Employee> findAll();
	//implementar un método getter que permitirá a un Empleado obtener su Gerente
//	@Query("SELECT e.manager_id FROM Employee e")
//    Employee getManager();
	
}
