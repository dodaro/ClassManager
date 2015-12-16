package it.unical.classmanager.model;

import java.util.List;


public class FolderBean extends AbstractFileBean{

	private List<AbstractFileBean> items;
	
	public FolderBean() {
		
	}
	
	public FolderBean(String name, String type, String path, List<AbstractFileBean> files){
		this.name = name;
		this.type = type;
		this.path = path;
		this.items = files;		
	}

	public List<AbstractFileBean> getItems() {
		return items;
	}
	public void setItems(List<AbstractFileBean> items) {
		this.items = items;
	}
	
	
}

