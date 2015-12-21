package it.unical.classmanager.controllers;

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
import it.unical.classmanager.utils.enumative.EnvironmentEnum;

/**
 * Handles requests for the forum page.
 */
@Controller
public class ForumController {
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping(value = "/forum", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		String content = initQuestion();
		model.addAttribute("content", content);
			
		return "forum";
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
