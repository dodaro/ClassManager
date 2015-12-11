package it.unical.classmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


@Entity
@Table(name ="users")
public class User {
	
	
	@Id
	@Column(name="id", nullable=false, length=20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column(name="username", nullable=false, length=20)
	String username;
	
	@Column(name="password", nullable=false, length=129)
	String password;
	
	@Column(name="role", nullable=true, length=20)
	String role;
	
	@Column(name="firstName", nullable=false, length=20)
	String firstName;

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
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * here I hash the password
	 * @param password to hash
	 */
	public void setPassword(String password) {
		this.password = PasswordHashing.getInstance().getHashAndSalt(password);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

}
