package it.unical.classmanager.model.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="communications")
public class Communications implements Serializable  {
	private static final long serialVersionUID = 3020678895004265567L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	private int id;
	
	@Column(name="name", nullable=false, length=32)
	private String name;
	
	@Column(name="description", nullable=false, length=32)
	private String description;	

	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "professor")
	private Professor professor;
	
	public Communications(){
		this.id = 0;
		this.name = "";
		this.description = "";
		this.professor = null;		
	}

	public Communications(int id, String name, String description, Professor professor) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.professor = professor;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}