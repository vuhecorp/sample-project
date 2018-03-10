package com.hersa.sample.project.utils;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.hersa.sample.project.dao.user.User;

public class SessionHelper {
	
	private static SessionHelper instance = null;
	private HttpSession session;
	
	protected SessionHelper() {
		this.session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	
	public static SessionHelper getInstance() {
		if (instance == null) {
			return new SessionHelper();
		}
		return instance;
	}
	
	public HttpSession getSession() {
		if (session == null) {
			return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		}
		return session;
	}
	
	public User getSessionUser() {
		return (User) this.getSession().getAttribute("User");
	}
	
	public void invalidateSession() {
		this.getSession().invalidate();
	}

	public void removeSessionVariable(String variable) {
		this.getSession().removeAttribute(variable);
	}
	
	public void redirect(String location) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(location);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
