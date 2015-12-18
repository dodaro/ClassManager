package it.unical.classmanager.managers;

import java.util.HashMap;
import java.util.Map;

import it.unical.classmanager.data.Environment;
import it.unical.classmanager.data.concrete.CPPEnvironment;
import it.unical.classmanager.data.concrete.JavaEnvironment;
import it.unical.classmanager.util.enumative.EnvironmentEnum;


/**
 * A singleton manager for manage the environment started on the system
 * 
 * @author sera
 *
 */
public class EnvironmentManger {

	/**
	 * Singleton private instance
	 */
	private static EnvironmentManger instance;
	
	/**
	 * List of the environment created
	 */
	private Map<EnvironmentEnum, Environment> environments;
	
	
	/**
	 * private default constructor that intialize the map of the environments
	 */
	private EnvironmentManger() {

		this.environments = new HashMap<EnvironmentEnum, Environment>();
	}
	

	/**
	 * Get the private instance of the singleton
	 * 
	 * @return An {@link EnvironmentManger} private instance
	 */
	public static EnvironmentManger getInstance() {
		
		if(instance == null){
			instance = new EnvironmentManger();
		}
		return instance;
	}
	
	
	/**
	 * Initialize an environment and add it to the internal map
	 * 
	 * @param environmentEnum The enumerative that represent the environment to create
	 */
	private void initEnvironment(EnvironmentEnum environmentEnum) {
		
		switch (environmentEnum) {
		case C_CPP:
			this.environments.put(environmentEnum, new CPPEnvironment());
			break;
			
		case JAVA:
			this.environments.put(environmentEnum, new JavaEnvironment());
			 break;
			 
		case HTML:
			break;
			
		case PYTHON:
			break;
			
		case PERL:
			break;

		default:
			break;
		}
	}
	
	
	
	/**
	 * Permit to destroy and remove from the internal map the environment created 
	 * 
	 * @param environmentEnum The enumerative of the {@link Environment} to delete
	 */
	public void destroyEnvronment(EnvironmentEnum environmentEnum) {
		
		this.environments.get(environmentEnum).destroyEnvironment();
		this.environments.remove(environmentEnum);
	}
	
	
	
	/**
	 * Get the {@link Environment} from the internal map
	 * 
	 * @param environmentEnum The name of the environment to get
	 * @return An {@link Environment} instance if it is present although it initialize it before return it
	 */
	public Environment getEnvironment(EnvironmentEnum environmentEnum) {
		
		if(this.environments.get(environmentEnum) == null) {
			initEnvironment(environmentEnum);
		}
		return this.environments.get(environmentEnum);
	}

}
