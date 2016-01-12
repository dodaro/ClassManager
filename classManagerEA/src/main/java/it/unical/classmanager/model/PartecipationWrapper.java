package it.unical.classmanager.model;

public class PartecipationWrapper {

	private String studentId;
	private int parentId;
	private int score;
	private boolean praise;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean getPraise() {
		return praise;
	}
	public void setPraise(boolean praise) {
		this.praise = praise;
	}
}
