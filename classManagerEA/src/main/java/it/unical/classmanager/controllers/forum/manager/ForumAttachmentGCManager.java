package it.unical.classmanager.controllers.forum.manager;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import it.unical.classmanager.model.dao.AnswerAttachedContentDAOImpl;
import it.unical.classmanager.model.dao.QuestionAttachedContentDAOImpl;
import it.unical.classmanager.model.data.AnswerAttachedContent;
import it.unical.classmanager.model.data.QuestionAttachedContent;

public class ForumAttachmentGCManager {

	private QuestionAttachedContentDAOImpl questionDAO;
	private AnswerAttachedContentDAOImpl answerDAO;
	
	private final long DAY_TIMEOUT = 10;
	
	
	public ForumAttachmentGCManager() {
		
		this.questionDAO = new QuestionAttachedContentDAOImpl();
		this.answerDAO = new AnswerAttachedContentDAOImpl();
	}
	
	
	public void garbageCollect() {
		

		List<QuestionAttachedContent> questionAttachment = questionDAO.getAllQuestionAttachedContents();
		List<AnswerAttachedContent> answerAttachemnt = answerDAO.getAllAnswerAttachedContents();
		
		//check for question
		for(QuestionAttachedContent tmpAttachment : questionAttachment) {
			
			if(tmpAttachment.getQuestion() == null) {
				
				long millisDiff = tmpAttachment.getCreationDate().getTime() - new Date().getTime();
				//long daysDiff = TimeUnit.MILLISECONDS.toDays(millisDiff);
				
				long daysDiff = TimeUnit.MILLISECONDS.toSeconds(millisDiff);
				
				if(daysDiff >= DAY_TIMEOUT) {
					
					System.out.println("da cancellare");
				}
			}
			
		}
		
		//check for answer
				
				
		
		
	}
	
	
	
}
