package it.unical.classmanager.data.concrete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import it.unical.classmanager.data.Environment;
import it.unical.classmanager.util.ExecutionResult;
import it.unical.classmanager.util.Terminal;
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
	protected void createEnvironment() {
		super.createEnvironment();
	}

	
	/**
	 * Method for generate random name of a temporary file
	 * 
	 * @return a random generated String 
	 */
	private String generateRandomFileName() {
		
		//TODO aggiungere session value per il valore random
		int tmpIndex = new Random().nextInt(10000);
		return this.fileName+tmpIndex;
	}
	
	
	/**
	 * Create the folder in which will be created and executed a cpp file
	 * 
	 * @param fileName the name of the folder and of the file
	 * @param content the content of the file
	 */
	private void createSandbox(String fileName, String content) {
		
		String tmpDir = this.directoryPath + fileName + "/";
		new File(tmpDir).mkdir();
		File file = new File(tmpDir + fileName + this.extension);
		
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
	}
	
	
	/**
	 * Simple utility function for force deleting a directory
	 * 
	 * @param dir the string path of the directory to delete
	 */
	private void removeDirectory(File dir) {
	    if (dir.isDirectory()) {
	        File[] files = dir.listFiles();
	        if (files != null && files.length > 0) {
	            for (File aFile : files) {
	                removeDirectory(aFile);
	            }
	        }
	        dir.delete();
	    } else {
	        dir.delete();
	    }
	}
	
	
	/**
	 * Destroy the temporary folder of a sandbox
	 * 
	 * @param fileName
	 */
	private void destroySandBox(String fileName) {
		
		String tmpDir = this.directoryPath + fileName + "/";
		removeDirectory(new File(tmpDir));
	}
	
	
	@Override
	public String compile(String content) {

		String tmpfileName = generateRandomFileName();
		String tmpDir = this.directoryPath + tmpfileName + "/";
		createSandbox(tmpfileName, content);
		
		
		ExecutionResult result = this.terminal.executeCommand(tmpDir, "g++", tmpfileName+this.extension, "-o", tmpfileName);

		if(result.getExitCode() != ExitCode.EXIT_OK.ordinal()) {
			
			System.out.println("error during the compilation");
			return result.getConsoleResult();
		}
		
		result = this.terminal.executeCommand(tmpDir, "./"+tmpfileName);
		
		destroySandBox(tmpfileName);
		
		
		
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
	

}
