package it.unical.classmanager;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.data.EditorStatus;
import it.unical.classmanager.data.Environment;
import it.unical.classmanager.data.concrete.CPPEnvironment;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		EditorStatus status = initEditorStatus();
		model.addAttribute("status", status);
			
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String compileSnippet(Locale locale, Model model, @ModelAttribute("status") EditorStatus status) {
		logger.info("compiling...", locale);

		Environment env = new CPPEnvironment();
		status.setConsoleContent(env.compile(status.getCode()));
		env.destroyEnvironment();
		
		System.out.println(status);
		
		model.addAttribute("status", status);
		
		return "home";
	}
	
	
	
	
	private EditorStatus initEditorStatus() {
		
		EditorStatus status = new EditorStatus();
		String fileContent = "#include <iostream>\n"
				+ "using namespace std;\n"
				+ "\n"
				+ "int main(){\n\n"
				+ "    cout<<\"hello!!!\"<<endl;\n"
				+ "    cout << \"ahahhahahah\" << endl; \n"
				+ "    return 0;\n"
				+ "}";
		status.setCode(fileContent);
		
		return status;
	}
	
}
