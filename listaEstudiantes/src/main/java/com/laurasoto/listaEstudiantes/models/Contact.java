package com.laurasoto.listaEstudiantes.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contacts")
@Getter
@Setter
@NoArgsConstructor
public class Contact {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull @Size(min=1, max=100)
	private String address;
	@NotNull @Size(min=1, max=100)
	public String city;
	@NotNull @Size(min=1, max=100)
	public String state;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;
	
	 @PrePersist
		protected void onCreate(){
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate(){
			this.updatedAt = new Date();
		}
		
		public Contact(Student student, String address, String city, String state) {
		this.student = student;
		this.address = address;
		this.city = city;
		this.state = state;
	}
		
}
