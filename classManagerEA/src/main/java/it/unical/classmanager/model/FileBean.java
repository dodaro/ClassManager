package it.unical.classmanager.model;

import java.io.File;

public class FileBean extends AbstractFileBean{

	private long size;
	public static final String FILE_TYPE = "file";
	
	public FileBean() {
		
	}
	
	public FileBean(String name, String type, String path, long l){
		this.name = name;
		this.type = type;
		this.path = path;
		this.size = l;		
	}
	
	
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
	public static FileBean toFileBean(File file){
		return new FileBean(file.getName(),AbstractFileBean.FILE_TYPE, file.getPath(), file.length());
	}
}
