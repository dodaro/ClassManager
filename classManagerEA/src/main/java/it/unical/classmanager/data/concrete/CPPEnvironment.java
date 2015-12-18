package it.unical.classmanager.data.concrete;


import it.unical.classmanager.data.Environment;
import it.unical.classmanager.util.ExecutionResult;
import it.unical.classmanager.util.enumative.ExitCode;
import it.unical.classmanager.util.enumative.TerminalErrorSignal;
import it.unical.classmanager.util.general.Paths;


/**
 * Represent a concrete c++ {@link Environment} that contain a terminal to execute operation
 * 
 * @author sera
 *
 */
public class CPPEnvironment extends Environment{

	/**
	 * Default constructor that create the environment
	 */
	public CPPEnvironment() {
		this.directoryPath = Paths.cppEnvironment;
		this.fileName = "main";
		this.extension = ".cpp";
		
		createEnvironment();
	}
	
	
	@Override
	public String compile(String content) {

		String tmpfileName = generateRandomFileName();
		try{
			String tmpDir = this.directoryPath + tmpfileName + "/";
			createSandbox(tmpfileName, content);
			
			
			ExecutionResult result = this.terminal.executeCommand(tmpDir, "g++", tmpfileName+this.extension, "-o", tmpfileName);
	
			if(result.getExitCode() != ExitCode.EXIT_OK.ordinal()) {
				
				System.out.println("error during the compilation");
				return result.getConsoleResult();
			}
			
			result = this.terminal.executeCommand(tmpDir, "./"+tmpfileName);
			
			if(result.getExitCode() != ExitCode.EXIT_OK.ordinal()) {
				
				System.out.println("error during the execution");
				
				//if the error is > 128 is a signal of the system
				if(result.getExitCode() > 128) {
					return TerminalErrorSignal.getEnumFromCode(result.getExitCode()-128).toString();
				}
				
				return result.getConsoleResult();
			}
	
			return result.getConsoleResult();
		}
		finally{
			destroySandBox(tmpfileName);
		}
		
	}
	

}
