package com.hersa.sample.project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AccessBO {
	private String header;
	private String message;
	
	public AccessBO() {
		
	}

	public String getHeader() {
		if (message.isEmpty()) {
			return "Please log in";
		}
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getMessage() {
		if (header.isEmpty()) {
			return "Unauthorized Access";
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
