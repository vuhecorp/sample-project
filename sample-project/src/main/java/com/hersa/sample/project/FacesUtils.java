package com.hersa.sample.project;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {
	
	protected FacesUtils() {
		
	}
	public static void addErrorMessage(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
	}
}
