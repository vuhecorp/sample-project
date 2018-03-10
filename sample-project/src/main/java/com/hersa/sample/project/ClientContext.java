package com.hersa.sample.project;



import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hersa.sample.project.bom.client.ClientManager;
import com.hersa.sample.project.bom.setting.SettingManager;
import com.hersa.sample.project.dao.client.Client;
import com.hersa.sample.project.dao.setting.Setting;
import com.hersa.sample.project.utils.Constants;

@ManagedBean
@ApplicationScoped
public class ClientContext implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	private static ClientContext instance = null;
	private Client client;
	private Setting displayWelcomePage;
	
	public ClientContext() {
		initializeClientContext();
	}

	private void initializeClientContext() {
		ClientManager cm = new ClientManager();
		SettingManager sm = new SettingManager();
		String clientId = null;
			
		try {
			Context context = new InitialContext();
			clientId = (String) context.lookup(Constants.APPLICATON_CLIENT);
			this.client = cm.retrieveClientByClientId(clientId);
			this.displayWelcomePage = sm.getSettingById(clientId, 1);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static ClientContext getInstance() {
		if (instance == null) {
			instance = new ClientContext();
		}
		return instance;
	}

	public Setting getDisplayWelcomePage() {
		return displayWelcomePage;
	}

	public void setDisplayWelcomePage(Setting displayWelcomePage) {
		this.displayWelcomePage = displayWelcomePage;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
