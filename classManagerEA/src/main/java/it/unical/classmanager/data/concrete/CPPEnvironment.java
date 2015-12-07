package it.unical.classmanager.data.concrete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import it.unical.classmanager.data.Environment;
import it.unical.classmanager.data.other.CompilingFile;
import it.unical.classmanager.util.ExecutionResult;
import it.unical.classmanager.util.Terminal;
import it.unical.classmanager.util.enumative.ExitCode;
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
	protected void createEnvironment() {
		super.createEnvironment();
		
		/*
		//TODO Aggiungere un lazy load e non creare tutti i file a na volta
		//create tot file tanti quanti sono i terminali aperti
		int terminalsCount = Terminal.getTerminal().getThreadPullNumber();
		for (int i = 0; i < terminalsCount; i++) {
			try {
			
				String tmpFile = this.directoryPath+this.fileName+i+this.extension;
				new File(tmpFile).createNewFile();
				
				this.compilationFiles.add(i, new CompilingFile(tmpFile));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
	}

	
	
	@Override
	public String compile(String content) {
		
		cleanMainDirectory();
		
		int tmpIndex = new Random().nextInt(10000);
		String tmpfileName = this.fileName+tmpIndex;
		
		
		File file = new File(this.directoryPath+tmpfileName+this.extension);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			
			writer.print(content);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			writer.close();
		}
		
		
		ExecutionResult result = this.terminal.executeCommand(this.directoryPath, "g++", tmpfileName+this.extension, "-o", tmpfileName);

		if(result.getExitCode() != ExitCode.EXIT_OK.ordinal()) {
			
			System.out.println("error during the compilation");
			return result.getConsoleResult();
		}

		result = this.terminal.executeCommand(this.directoryPath, "./"+tmpfileName);
		return result.getConsoleResult();
	}
	

}
