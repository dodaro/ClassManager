package it.unical.classmanager.model.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="answerAttachedContent")
public class AnswerAttachedContent implements Serializable  {
	private static final long serialVersionUID = -8328352865095740480L;
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

	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "answer")
	private Answer answer;
	
	public AnswerAttachedContent(){
		this.id = 0;
		this.name = "";
		this.type = "";
		this.filePath = "";
		this.answer = null;
	}

	public AnswerAttachedContent(int id, String name, String type, String filePath, Answer answer) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.filePath = filePath;
		this.answer = answer;
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}