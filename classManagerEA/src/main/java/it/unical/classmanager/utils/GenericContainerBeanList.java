package it.unical.classmanager.utils;

import java.util.ArrayList;
import java.util.List;

public class GenericContainerBeanList {
    private List<GenericContainerBean> list;
    
    public GenericContainerBeanList() {
	setList(new ArrayList<GenericContainerBean>());
    }

    public List<GenericContainerBean> getList() {
	    return list;
    }

    public void setList( List<GenericContainerBean> list) {
	    this.list = list;
    }
    
    public void addToList(GenericContainerBean invitationBean){
	list.add(invitationBean);
    }   
    
    public int size(){
	return list.size();
    }
    
    public GenericContainerBean get(int index){
	return list.get(index);
    }
}
