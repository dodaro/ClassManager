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
@Table(name ="question")
public class Question implements Serializable  {
	private static final long serialVersionUID = -4199532379941166226L;
	
	@Id
	@Column(name="id", nullable=false, length=20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	@Column(name="title", nullable=false, length=100)
	private String title;
	
	@Column(name="description", nullable=false, length=1000)	
	private String description;

	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "lecture")
	private Lecture lecture;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Answer> answers;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<QuestionAttachedContent> questionAttachedContents;
	
	public Question(){
		this.id = 0;
		this.title = "";
		this.description = "";
		this.user = null;
		this.lecture = null;
		this.answers = new ArrayList<Answer>();
		this.questionAttachedContents = new ArrayList<QuestionAttachedContent>();
	}

	public Question(int id, String title, String description, User user, Lecture lecture, List<Answer> answers,
			List<QuestionAttachedContent> questionAttachedContents) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;
		this.lecture = lecture;
		this.answers = answers;
		this.questionAttachedContents = questionAttachedContents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<QuestionAttachedContent> getQuestionAttachedContents() {
		return questionAttachedContents;
	}

	public void setQuestionAttachedContents(List<QuestionAttachedContent> questionAttachedContents) {
		this.questionAttachedContents = questionAttachedContents;
	}
	
}