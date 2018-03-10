package com.hersa.sample.project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AccessBO {
	private String header;
	private String message;
	
	public AccessBO() {
		this.header = "Unauthorized Acess";
		this.message = "You are not allowed to access this resource.";
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
