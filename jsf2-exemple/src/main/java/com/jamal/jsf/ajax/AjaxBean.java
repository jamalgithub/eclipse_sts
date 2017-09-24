package com.jamal.jsf.ajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AjaxBean {
	private String name;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getWelcomeMessage(){
		return "Hello " + name;
	}
	
	public String getChAjax(){
		return name;
	}	
}
