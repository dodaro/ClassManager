package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.QuestionAttachedContent;


public interface QuestionAttachedContentDAO {
	public void create(QuestionAttachedContent questionAttachedContent);

	public void update(QuestionAttachedContent questionAttachedContent);

	public void delete(QuestionAttachedContent questionAttachedContent);

	public QuestionAttachedContent get(Integer id);

	public void deleteAllQuestionAttachedContents();

	public int numberOfQuestionAttachedContents();

	public List<QuestionAttachedContent> getAllQuestionAttachedContents();
}