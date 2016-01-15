package it.unical.classmanager.utils;

import org.springframework.ui.Model;

public class CustomHeaderAndBody {
    
    public static void setCustomHead(Model model, String head){
	model.addAttribute("customHeader", head);
    }
    
    public static void setCustomBody(Model model, String body){
	model.addAttribute("customBody", body);
    }
    
    public static void setCustomHeadAndBody(Model model, String head, String body){
	setCustomHead(model, head);
	setCustomBody(model, body);
	
    }
}
