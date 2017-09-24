package com.jamal.jsf.events;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class EventsBen {
	private static Map<String,String> countryMap;
	private String selectedCountry = "United Kingdom"; //default value 
	static{
		countryMap = new LinkedHashMap<String,String>();
		countryMap.put("en", "United Kingdom"); //locale, country name
		countryMap.put("fr", "French");
		countryMap.put("de", "German");	
	}
	private String data = "sample data";
	
	public void localeChanged(ValueChangeEvent e){
		selectedCountry = e.getNewValue().toString(); 
	}
	
	public String showResult(){
		return "result";
	}

	public void updateData(ActionEvent e){
		data="Hello World";
	}
	
	public void handleEvent(ComponentSystemEvent event){
	    data="Hello World";
	}
	
	public void isAdmin(ComponentSystemEvent event){		 
		FacesContext fc = FacesContext.getCurrentInstance();	 
		if (!"admin".equals(fc.getExternalContext().getSessionMap().get("role"))){	 
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();	 
			nav.performNavigation("access-denied");
		}		
	  }
	
	public Map<String, String> getCountries() {
		return countryMap;
	}
	
	public String getSelectedCountry() {
		return selectedCountry;
	}
	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public static Map<String, String> getCountryMap() {
		return countryMap;
	}

	public static void setCountryMap(Map<String, String> countryMap) {
		EventsBen.countryMap = countryMap;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
