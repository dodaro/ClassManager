package it.unical.classmanager.util.enumative;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import it.unical.classmanager.util.Terminal;

/**
 * An enumerative class that represent the exit code of a {@link Terminal} execution
 * 
 * @author sera
 *
 */
public enum ExitCode {
	
	EXIT_OK(0), EXIT_ERROR(1);
	
	@SuppressWarnings("unused")
	private final int value;
	
	private ExitCode(int value) {
		this.value = value;
	}
	
}
