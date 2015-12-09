package it.unical.classmanager;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.unical.classmanager.data.Environment;
import it.unical.classmanager.data.concrete.CPPEnvironment;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Snippet snippet = new Snippet();
		String fileContent = "#include <iostream>\n"
				+ "using namespace std;\n"
				+ "\n"
				+ "int main(){\n\n"
				+ "    cout<<\"hello!!!\"<<endl;\n"
				+ "    cout << \"ahahhahahah\" << endl; \n"
				+ "    return 0;\n"
				+ "}";
		snippet.setCode(fileContent);

		model.addAttribute("snippet", snippet);
			
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String compileSnippet(Locale locale, Model model, @ModelAttribute("snippet") Snippet snippet) {
		logger.info("initiate compile", locale);

		Environment env = new CPPEnvironment();
		String compileResult = env.compile(snippet.getCode());
		env.destroyEnvironment();
		
		snippet.setConsole(compileResult);
		
		model.addAttribute("snippet", snippet);
		
		return "home";
	}
	
}
