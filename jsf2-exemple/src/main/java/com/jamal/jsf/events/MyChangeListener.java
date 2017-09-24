package com.jamal.jsf.events;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class MyChangeListener implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		//access country bean directly
	     EventsBen  eventsBen = (EventsBen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eventsBen");
	     eventsBen.setSelectedCountry(event.getNewValue().toString());

	}

}
