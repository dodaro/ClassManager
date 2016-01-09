package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.Answer;

public interface AnswerDAO {
	public Object create(Answer answer);

	public Object update(Answer answer);

	public Object delete(Answer answer);

	public Answer get(Integer id);

	public void deleteAllAnswers();

	public int numberOfAnswers();

	public List<Answer> getAllAnswers();
}