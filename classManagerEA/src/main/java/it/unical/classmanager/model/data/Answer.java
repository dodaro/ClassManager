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
@Table(name ="answer")
public class Answer implements Serializable  {
	private static final long serialVersionUID = 1969728579950297116L;
	
	@Id
	@Column(name="id", nullable=false, length=20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="description", nullable=false, length=10000)
	private String description;
	
	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "question")
	private Question question;
	
	@OneToMany(mappedBy = "answer", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<AnswerAttachedContent> answerAttachedContents;
	
	public Answer(){
		this.id = 0;
		this.description = "";
		this.user = null;
		this.question = null;
		this.answerAttachedContents = new ArrayList<AnswerAttachedContent>();
	}

	public Answer(int id, String description, User user, Question question,
			List<AnswerAttachedContent> answerAttachedContents) {
		this.id = id;
		this.description = description;
		this.user = user;
		this.question = question;
		this.answerAttachedContents = answerAttachedContents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<AnswerAttachedContent> getAnswerAttachedContents() {
		return answerAttachedContents;
	}

	public void setAnswerAttachedContents(List<AnswerAttachedContent> answerAttachedContents) {
		this.answerAttachedContents = answerAttachedContents;
	}
	
}