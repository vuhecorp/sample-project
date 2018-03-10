package com.hersa.sample.project.test;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TestAdminPage extends AdminFacesPage{
	
	private String welcome = "welcome user";
	public TestAdminPage() {
		
	}
	
	@Override
	@PostConstruct
	public void onPageLoad(){
		super.onPageLoad();
	}
	
	public String getWelcome() {
		return welcome;
	}
	
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
}

