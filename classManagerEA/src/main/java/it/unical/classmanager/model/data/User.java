package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import it.unical.classmanager.model.FieldMatch;
import it.unical.classmanager.model.PasswordHashing;

@Entity
@Table(name ="user")
@Inheritance(strategy = InheritanceType.JOINED)
@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword",message="ciao"),
}) 
public class User implements Serializable {
	private static final long serialVersionUID = 7720914354560371125L;

	/*
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	*/
	@Id
	@Column(name="username", nullable=false, length=20)
	@Size(min=4,max=20)
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String username;
	
	@Transient
	@Size(min=6,max=50)
	private String password;
	
	@Transient
	@Size(min=6,max=50)
	private String confirmPassword;
	
	@Column(name="password",nullable=false, length=129)
	private String hash;
	
	@Column(name="role", nullable=true, length=32)
	private String role;
	
	@Column(name="firstName", nullable=false, length=20)
	@Size(min=3, max=20)
	private String firstName;

	@Column(name="lastName", nullable=false, length=20)
	@Size(min=3, max=20)
	private String lastName;
	
	@Column(name="email", nullable=false, length=128)
	@Size(max=200)
	@Email()
	@NotEmpty()
	private String email;
	
	@Column(name="birthDate", nullable=false)
	@NotNull(message="La data di nascita non è stata inserita.")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past()	
	private Date birthDate;
	
	@Column(name="address", nullable=true, length=256)
	private String address;
	
	//	Foreign key section
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Event> events;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Question> questions;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Answer> answers;
		
	public User(){
		this.username = "";
		this.password = "";
		this.confirmPassword = "";
		this.hash = "";
		this.role = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.birthDate = null;
		this.address = null;
		this.events = new ArrayList<Event>();
		this.questions = new ArrayList<Question>();
		this.answers = new ArrayList<Answer>();
	}	
	
	public User(int id, String username, String password, String role, String firstName, String lastName, String email,
			Date birthDate, String address, List<Event> events, List<Question> questions, List<Answer> answers) {
		this.username = username;
		this.password = password;
		this.hash = PasswordHashing.getInstance().getHashAndSalt(this.password);
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
		this.events = events;
		this.questions = questions;
		this.answers = answers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setHash(String hash) {
		this.hash = PasswordHashing.getInstance().getHashAndSalt(hash);
	}
	
	public String getHash() {
		return hash;
	}

}
