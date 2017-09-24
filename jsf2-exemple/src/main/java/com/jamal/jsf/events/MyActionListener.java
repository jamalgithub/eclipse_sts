package com.jamal.jsf.events;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class MyActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		EventsBen eventsBen = (EventsBen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eventsBen"); 
		eventsBen.setData("Hello World");

	}

}
