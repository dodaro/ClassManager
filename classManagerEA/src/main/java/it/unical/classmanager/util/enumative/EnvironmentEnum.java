package it.unical.classmanager.util.enumative;


/**
 * An enumerative class that represent the language available for the editor
 * 
 * 
 * @author sera
 *
 */
public enum EnvironmentEnum {

	C_CPP, JAVA, HTML, PYTHON, PERL;

	public String getValue() {
		return this.toString().toLowerCase();
	}
	
	public static EnvironmentEnum getEnumFromString(String name) {
		return valueOf(name.toUpperCase());
	}
}
