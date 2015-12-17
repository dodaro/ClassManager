package it.unical.classmanager.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import it.unical.classmanager.data.concrete.CPPEnvironment;
import it.unical.classmanager.util.Terminal;

/**
 * Abstract class that represent an environment
 * 
 * @author sera
 *
 */
public abstract class Environment {

	/**
	 * Is the terminal on wich execute the operation
	 */
	protected Terminal terminal;
	
	/**
	 * Is the directory path of the root folder of the environment
	 */
	protected String directoryPath;
	
	/**
	 * The prefix of the name of the temporary file used by the environment 
	 */
	protected String fileName;
	
	/**
	 * The extension of the temporary file used by the environment
	 */
	protected String extension;
	
	
	public Environment() {

		this.terminal = Terminal.getTerminal();
	}
	
	
	/**
	 * Init function of the environment, it initialize the filesystem creating necessary folders
	 */
	protected void createEnvironment() {
		
		if(!new File(this.directoryPath).exists()) {
			new File(this.directoryPath).mkdirs();
		}
		
		cleanMainDirectory();
	}
	
	
	/**
	 * Destroies the environment and erase all the file contained in it
	 */
	public void destroyEnvironment() {

		cleanMainDirectory();
	}
	
	
	/**
	 * Clean the root directory of the environment from all the temporary files
	 */
	public void cleanMainDirectory() {
		
		if(new File(this.directoryPath).list().length != 0) {
			
			for(String tmpFileName : new File(this.directoryPath).list()) {
				new File(this.directoryPath+tmpFileName).delete();
			}
		}
	}
	
	
	/**
	 * Execute on a terminal the operation of compile a file for a specific environment
	 * 
	 * @param content is the content of the temporary file created for compiling
	 * @return the result of the {@link Terminal} console
	 */
	public abstract String compile(String content);
	
}
