package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name ="courseClass")
public class CourseClass implements Serializable  {
	private static final long serialVersionUID = 8980414938557627568L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	private int id;
	
	@Column(name="name", nullable=false, length=64)
	private String name;
	
	@Column(name="cfu", nullable=false)
	private int cfu;

	@Column(name="activationDate", nullable=false)
	private Date activationDate;

	@Column(name="endDate", nullable=true)
	private Date endDate;

	@Column(name="referenceYear", nullable=false)
	private short referenceYear;
	
	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name = "degreeCourse")
	private DegreeCourse degreeCourse;
	
	@OneToMany(mappedBy = "courseClass", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Exam> exams;
	
	@OneToMany(mappedBy = "courseClass", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<RegistrationStudentClass> registrationStudentClasses;
	
	@OneToMany(mappedBy = "courseClass", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Lecture> lectures;
	
	public CourseClass() {
		this.id = 0;
		this.name = "";
		this.cfu = 0;
		this.activationDate = null;
		this.endDate = null;
		this.referenceYear = 0;
		this.professor = null;
		this.degreeCourse = null;
		this.exams = new ArrayList<Exam>();
		this.registrationStudentClasses = new ArrayList<RegistrationStudentClass>();
		this.lectures = new ArrayList<Lecture>();
	}

	public CourseClass(int id, String name, int cfu, Date activationDate, Date endDate, short referenceYear,
			Professor professor, DegreeCourse degreeCourse, List<Exam> exams,
			List<RegistrationStudentClass> registrationStudentClasses, List<Lecture> lectures) {
		this.id = id;
		this.name = name;
		this.cfu = cfu;
		this.activationDate = activationDate;
		this.endDate = endDate;
		this.referenceYear = referenceYear;
		this.professor = professor;
		this.degreeCourse = degreeCourse;
		this.exams = exams;
		this.registrationStudentClasses = registrationStudentClasses;
		this.lectures = lectures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public short getReferenceYear() {
		return referenceYear;
	}

	public void setReferenceYear(short referenceYear) {
		this.referenceYear = referenceYear;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public DegreeCourse getDegreeCourse() {
		return degreeCourse;
	}

	public void setDegreeCourse(DegreeCourse degreeCourse) {
		this.degreeCourse = degreeCourse;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<RegistrationStudentClass> getRegistrationStudentClasses() {
		return registrationStudentClasses;
	}

	public void setRegistrationStudentClasses(List<RegistrationStudentClass> registrationStudentClasses) {
		this.registrationStudentClasses = registrationStudentClasses;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	@Override
	public String toString()
	{
		return "CourseClass [id=" + id + ", name=" + name + ", cfu=" + cfu + ", activationDate=" + activationDate
				+ ", endDate=" + endDate + ", referenceYear=" + referenceYear + ", professor=" + professor
				+ ", degreeCourse=" + degreeCourse + ", exams=" + exams + ", registrationStudentClasses="
				+ registrationStudentClasses + ", lectures=" + lectures + "]";
	}
	
	
}