package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.Question;

public interface QuestionDAO {
	public void create(Question question);

	public void update(Question question);

	public void delete(Question question);

	public Question get(Integer id);

	public void deleteAllQuestions();

	public int numberOfQuestions();

	public List<Question> getAllQuestions();
}