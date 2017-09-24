package com.jamal.jsf.basicTags;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "basicTagsBean", eager = true)
@SessionScoped
public class BasicTags {

	public String[] data = {"1","2","3"};
	public String data2 = "1";
	
	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	public String showResult(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		data2 =  params.get("username"); 
		return "result2";
	}
	
	public void attributeListener(ActionEvent event){
	    data2 = (String)event.getComponent().getAttributes().get("username");	
	}
}
