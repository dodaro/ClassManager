package it.unical.classmanager.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Viewer3DController {    
    @RequestMapping(value = "/viewer3D", method = RequestMethod.GET)
    public String viewer(Model model,HttpServletRequest request) {	
	return "viewer3D";
    }    
}
