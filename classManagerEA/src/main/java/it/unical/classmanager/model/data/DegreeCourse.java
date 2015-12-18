package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name ="degreeCourse")
public class DegreeCourse implements Serializable  {
	private static final long serialVersionUID = -8632221306304768616L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="courseCode", nullable=false, length=32)
	private String courseCode;

	@Column(name="name", nullable=false, length=32)
	private String name;
	
	//	Foreign key section
	@OneToMany(mappedBy = "degreeCourse", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)	
	private List<CourseClass> courseClasses;
	
	@ManyToOne
	@JoinColumn(name = "departement")
	private Departement departement;	
	
	public DegreeCourse(){
		this.id = 0;
		this.courseCode = "";
		this.name = "";
		this.courseClasses = new ArrayList<CourseClass>();
		this.departement = null;
	}

	public DegreeCourse(int id, String courseCode, String name, List<CourseClass> courseClasses,
			Departement departement) {
		this.id = id;
		this.courseCode = courseCode;
		this.name = name;
		this.courseClasses = courseClasses;
		this.departement = departement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseClass> getCourseClasses() {
		return courseClasses;
	}

	public void setCourseClasses(List<CourseClass> courseClasses) {
		this.courseClasses = courseClasses;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}