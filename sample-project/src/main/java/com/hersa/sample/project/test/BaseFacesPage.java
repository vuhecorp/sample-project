package com.hersa.sample.project.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hersa.sample.project.AccessBO;
import com.hersa.sample.project.ClientContext;
import com.hersa.sample.project.Navigation;
import com.hersa.sample.project.bom.permissionview.PermissionViewManager;
import com.hersa.sample.project.dao.permissionview.PermissionView;
import com.hersa.sample.project.dao.user.User;
import com.hersa.sample.project.utils.SessionHelper;

public class BaseFacesPage implements AbstractFacesPage {
	
	protected int pageAccessLevel;
	protected User user;
	protected List<PermissionView> userPermissions;
	
	public BaseFacesPage() {
		
	}
	
	public void onPageLoad() {
		calcPageAccessLevel();
		try {
			loadUserPermissions();
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
			AccessBO accessBean = (AccessBO) applicationContext.getBean("accessBean");
			accessBean.setHeader("Unexpected Error");
			accessBean.setMessage("An error occurred please try again.");
			SessionHelper.getInstance().redirect(Navigation.ROOT + Navigation.ACCESS);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		user = SessionHelper.getInstance().getSessionUser();
	}
	
	private void loadUserPermissions() throws Exception {
		PermissionViewManager pvm = new PermissionViewManager();
		userPermissions = pvm.retrieveAllPermissionView();
	}

	public void calcPageAccessLevel() {
		pageAccessLevel = 101;
	}

	public int getPageAccessLevel() {
		return pageAccessLevel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PermissionView> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<PermissionView> userPermissions) {
		this.userPermissions = userPermissions;
	}
	
}
