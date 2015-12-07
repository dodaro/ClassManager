package it.unical.classmanager.data.other;


/**
 * Class for know if a file is locked or not
 * 
 * @author sera
 *
 */
public class CompilingFile {

	
	private boolean locked;
	private String filePath;
	
	public CompilingFile() {
		
		this.locked = false;
		this.filePath = "";
	}

	public CompilingFile(String filePath) {
		
		this.locked = false;
		this.filePath = filePath;
	}
	
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
