package it.unical.classmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="users")
public class User {
	
	@Id
	@Column(name="id", nullable=false, length=20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	
	@Column(name="name", nullable=false, length=20)
	String name;
	
	@Column(name="lastName", nullable=false, length=20)
	String lastName;
	
	public User() {
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

}
