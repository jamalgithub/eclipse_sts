package com.jamal.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped
public class ValidatorBean {
	private String name;
	private int age;
	private double salary;
	private String password;
	public String urlData;
	
	public void validatePassword(ComponentSystemEvent event) {		 
		FacesContext fc = FacesContext.getCurrentInstance();	 
		UIComponent components = event.getComponent();
		
		// get password
		UIInput uiInputPassword = (UIInput) components.findComponent("password");
		String password = uiInputPassword.getLocalValue() == null ? "" : uiInputPassword.getLocalValue().toString();
		String passwordId = uiInputPassword.getClientId();
 
		// get confirm password
		UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmPassword");
		String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? "" : uiInputConfirmPassword.getLocalValue().toString();
 
		// Let required="true" do its job.
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			return;
		}
 
		if (!password.equals(confirmPassword)) {	 
			FacesMessage msg = new FacesMessage("Password must match confirm password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(passwordId, msg);
			fc.renderResponse();	 
		}	 
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlData() {
		return urlData;
	}

	public void setUrlData(String urlData) {
		this.urlData = urlData;
	}
	
}
