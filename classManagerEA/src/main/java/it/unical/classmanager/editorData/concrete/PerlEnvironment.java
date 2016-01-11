package it.unical.classmanager.editorData.concrete;


import it.unical.classmanager.editorData.Environment;
import it.unical.classmanager.utils.ExecutionResult;
import it.unical.classmanager.utils.enumative.ExitCode;
import it.unical.classmanager.utils.enumative.TerminalErrorSignal;
import it.unical.classmanager.utils.general.Paths;


/**
 * Represent a concrete c++ {@link Environment} that contain a terminal to execute operation
 * 
 * @author sera
 *
 */
public class PerlEnvironment extends Environment{

	/**
	 * Default constructor that create the environment
	 */
	public PerlEnvironment() {
		this.directoryPath = Paths.perlEnvironment;
		this.fileName = "main";
		this.extension = ".pl";
		
		createEnvironment();
	}
	
	
	@Override
	public String compile(String content) {

		String tmpfileName = generateRandomFileName();
		try{
			String tmpDir = this.directoryPath + tmpfileName + "/";
			createSandbox(tmpfileName, content);
			
			
			ExecutionResult result = this.terminal.executeCommand(tmpDir, "docker", "run", "-v",
					tmpDir + ":/home/docker"+ tmpDir +":ro",
					"ubuntu_editor/sera", "timeout", "--signal=5", "20", "perl", "/home/docker" + tmpDir + tmpfileName + this.extension);
			
			
			//ExecutionResult result = this.terminal.executeCommand(tmpDir, "perl", "./"+tmpfileName+this.extension);
			
			if(result.getExitCode() != ExitCode.EXIT_OK.ordinal()) {
				
				System.out.println("error during the execution");
				
				return result.getConsoleResult();
			}
	
			return result.getConsoleResult();
		}
		finally{
			destroySandBox(tmpfileName);
		}
		
	}
	

}
