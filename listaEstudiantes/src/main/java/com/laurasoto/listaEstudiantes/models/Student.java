package com.laurasoto.listaEstudiantes.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @NotNull
	 private String firstName;
	 @NotNull
	 private String lastName;
	 @NotNull
	 private int age;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private Contact contact;
	 @PrePersist
		protected void onCreate(){
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate(){
			this.updatedAt = new Date();
		}
		
	public Student(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
}
