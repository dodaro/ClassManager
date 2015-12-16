package it.unical.classmanager.model;

public abstract class AbstractFileBean {
	
	public static final String FOLDER_TYPE = "folder";
	public static final String FILE_TYPE = "file";
	
	protected String name;
	protected String type;
	protected String path;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
