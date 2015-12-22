package it.unical.classmanager.controllers.forum;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.editorData.EditorStatus;
import it.unical.classmanager.editorData.Environment;
import it.unical.classmanager.managers.EnvironmentManger;
import it.unical.classmanager.model.data.Answer;
import it.unical.classmanager.utils.enumative.EnvironmentEnum;

/**
 * Handles requests for the forum page.
 */
@Controller
public class InsertAnswerController {
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping(value = "/insertAnswer", method = RequestMethod.GET)
	public String getQuestion(Locale locale, Model model) {
		
		
		String question = initQuestion();
		model.addAttribute("question", question);
		
		//risposta a spregio
		Answer answer = new Answer();
		answer.setDescription("<p>scrivi please...</p>");
		model.addAttribute("answer", answer);
			
		return "forum/insertAnswer";
	}
	
	
	@RequestMapping(value = "/insertAnswer", method = RequestMethod.POST)
	public String getAnswer(Locale locale, Model model, @ModelAttribute("answer") Answer answer) {
		
		
		String question = initQuestion();
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		
		System.out.println(answer.getDescription());
			
		return "forum/insertAnswer";
	}
	
	
	private String initQuestion() {
		return "<h3><b>Java jdbc:mysql get client ( java.exe ) Port to Database in the source code</b></h3>\n"
				+ "\n"
				+ "<hr />\n"
				+ "<p>I have a Java Application where I connect to a mySQL Server with <code><span style=\"background-color:#D3D3D3\">&quot;com.mysql.jdbc.Driver&quot;</span></code>.<br />\n"
				+ "<br />\n"
				+ "After the connection is established, I need the Client <strong>Local</strong> Port. This means the port the java application receives data from the mySQL Server.</p>\n"
				+ "\n"
				+ "<p><img alt=\"\" src=\"http://i.stack.imgur.com/0hmzd.jpg\" style=\"height:118px; width:408px\" /><br />\n"
				+ "Is there a way to receive it in my own source code, after I established the connection ?<br />\n"
				+ "<br />\n"
				+ "I tried all the Information in <code><span style=\"background-color:#D3D3D3\">java.sql.DatabaseMetaData</span></code></p>\n";

	}
	
	
	
}
