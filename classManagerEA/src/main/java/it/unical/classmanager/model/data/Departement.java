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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name ="departement")
public class Departement implements Serializable  {
	private static final long serialVersionUID = 2510501980555217109L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=false, length=32)
	private String name;
	
	@Column(name="address", nullable=false, length=128)
	private String address;
	
	@Column(name="region", nullable=false, length=64)
	private String region;
	
	@Column(name="state", nullable=false, length=128)
	private String state;
	
	//	Foreign key section	
	@OneToMany(mappedBy = "departement", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)	
	private List<DegreeCourse> degreeCourses;
	
	public Departement(){
		this.id = 0;
		this.name = "";
		this.address = "";
		this.region = "";
		this.state = "";
		this.degreeCourses = new ArrayList<DegreeCourse>();		
	}

	public Departement(int id, String name, String address, String region, String state,
			List<DegreeCourse> degreeCourses) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.region = region;
		this.state = state;
		this.degreeCourses = degreeCourses;
	}
	
}