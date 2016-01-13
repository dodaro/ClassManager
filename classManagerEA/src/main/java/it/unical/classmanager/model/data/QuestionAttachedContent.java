package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="questionAttachedContent")
public class QuestionAttachedContent implements Serializable  {
	private static final long serialVersionUID = -4543693514900654515L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=false, length=256)
	private String name;
	
	@Column(name="type", nullable=false, length=256)
	private String type;
	
	@Column(name="filePath", nullable=false, length=1000)
	private String filePath;
	
	@Column(name="creationDate")
	private Date creationDate;
	
	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "question")
	private Question question;
	
	public QuestionAttachedContent(){
		this.id = 0;
		this.name = "";
		this.type = "";
		this.filePath = "";
		this.question = null;
		this.creationDate = null;
	}

	public QuestionAttachedContent(int id, String name, String type, String filePath, Question question, Date creationDate) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.filePath = filePath;
		this.question = question;
		this.creationDate = creationDate;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
	

}