package it.unical.classmanager;

import it.unical.classmanager.data.Environment;
import it.unical.classmanager.data.concrete.CPPEnvironment;
import it.unical.classmanager.util.Terminal;

public class Main {

	public static void main(String[] args) {
		
		Environment env = new CPPEnvironment();
		
		for (int i = 0; i < 10; i++) {
			String fileContent = "#include <iostream>\n"
					+ "using namespace std;\n"
					+ "\n"
					+ "int main(){\n"
					+ "cout<<\"hello!!!\"<<endl;\n"
					+ "cout << \"ahahhahahah\" << endl; \n"
					+ "return 0;\n"
					+ "}";
			System.out.println(env.compile(fileContent));
		}

		
		env.destroyEnvironment();
		Terminal.getTerminal().shutdownTerminalService();
	}

	
}
