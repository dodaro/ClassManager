package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="professor")
@PrimaryKeyJoinColumn(name="username")
public class Professor extends User implements Serializable  {
	private static final long serialVersionUID = -8604798186579488323L;
	
//	@Column(name="identificationNumber", unique=true, nullable=false, length=32)
//	private int identificationNumber;

	//	Foreign key section
	@OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Communications>  communications;
	
	@OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CourseClass> courseClasses;
	
	public Professor(){
		super();
//		this.identificationNumber = 0;
		this.communications = new ArrayList<Communications>();
		this.courseClasses = new ArrayList<CourseClass>();
	}

	public Professor(int id, String username, String password, String confirmPassword, String role, String firstName, String lastName,
			String email, Date birthDate, String address, List<Event> events, List<Question> questions,
			List<Answer> answers) {
		super(username, password, confirmPassword, role, firstName, lastName, email, birthDate, address, events, questions, answers);
//		this.identificationNumber = 0;
		this.communications = new ArrayList<Communications>();
		this.courseClasses = new ArrayList<CourseClass>();
	}

	public Professor(int id, String username, String password, String confirmPassword, String role, String firstName, String lastName,
			String email, Date birthDate, String address, List<Event> events, List<Question> questions,
			List<Answer> answers, int identificationNumber, List<Communications> communications, List<CourseClass> courseClasses) {
		super(username, password, confirmPassword, role, firstName, lastName, email, birthDate, address, events, questions, answers);
//		this.identificationNumber = identificationNumber;
		this.communications = communications;
		this.courseClasses = courseClasses;
	}
	
	public Professor(User user){
		super(user);
//		this.identificationNumber = 0;
		this.communications = new ArrayList<Communications>();
		this.courseClasses = new ArrayList<CourseClass>();
	}
	
	public Professor(User user, int identificationNumber, List<Communications> communications, List<CourseClass> courseClasses){
		super(user);
//		this.identificationNumber = identificationNumber;
		this.communications = communications;
		this.courseClasses = courseClasses;
	}

//	public int getIdentificationNumber() {
//		return identificationNumber;
//	}

//	public void setIdentificationNumber(int identificationNumber) {
//		this.identificationNumber = identificationNumber;
//	}

	public List<Communications> getCommunications() {
		return communications;
	}

	public void setCommunications(List<Communications> communications) {
		this.communications = communications;
	}

	public List<CourseClass> getCourseClasses() {
		return courseClasses;
	}

	public void setCourseClasses(List<CourseClass> courseClasses) {
		this.courseClasses = courseClasses;
	}
	
}