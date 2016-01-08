package it.unical.classmanager.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LectureControllerWrapper {

	@Size(min=4,max=4)
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String path;
	private int parentId;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}