package it.unical.classmanager.invitations;

import java.util.ArrayList;
import java.util.List;

public class InvitationBeanList {
    private List<InvitationBean> list;
    
    public InvitationBeanList() {
	setList(new ArrayList<InvitationBean>());
    }

    public List<InvitationBean> getList() {
	    return list;
    }

    public void setList( List<InvitationBean> list) {
	    this.list = list;
    }
    
    public void addToList(InvitationBean invitationBean){
	list.add(invitationBean);
    }   
    
    public int size(){
	return list.size();
    }
    
    public InvitationBean get(int index){
	return list.get(index);
    }
}
