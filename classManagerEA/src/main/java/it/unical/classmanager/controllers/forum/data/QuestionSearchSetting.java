package it.unical.classmanager.controllers.forum.data;

public class QuestionSearchSetting {

	private String questionName;
	private String questionDescription;
	private String username;
	private String lectureName;
	
	public QuestionSearchSetting() {

		this.questionName = null;
		this.questionDescription = null;
		this.username = null;
		this.lectureName = null;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	
}