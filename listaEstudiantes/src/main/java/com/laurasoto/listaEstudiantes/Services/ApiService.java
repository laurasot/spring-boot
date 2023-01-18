package com.laurasoto.listaEstudiantes.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.laurasoto.listaEstudiantes.models.Contact;
import com.laurasoto.listaEstudiantes.models.Student;
import com.laurasoto.listaEstudiantes.repositories.ContactRepository;
import com.laurasoto.listaEstudiantes.repositories.StudentRepository;

import lombok.Getter;
import lombok.Setter;

@Service
public class ApiService {
	private final StudentRepository studentRepository;
	private final ContactRepository contactRepository;
	
	public ApiService(StudentRepository studentRepository, ContactRepository contactRepository) {
		this.studentRepository = studentRepository;
		this.contactRepository = contactRepository;
	}
	//crea/guarda un student
	 public Student creaStudent(Student nuevoStudent) {
	     return studentRepository.save(nuevoStudent);
	 }
	//crea/guarda un contacto
	 public Contact creaContact(Contact nuevoContact) {
		  return contactRepository.save(nuevoContact); 
	 }
	 public Student studentId(Long id) {
		return studentRepository.findById(id).orElse(null);
	 }
	 
	 
	 public List<Contact> mostrarContact(){
		 return contactRepository.findAll();
	 }
	 public List<Student> mostrarStudent(){
		 return studentRepository.findAll();
	 }



}
