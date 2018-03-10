package com.hersa.sample.project.web.faces.settings;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hersa.sample.project.ClientContext;
import com.hersa.sample.project.FacesUtils;
import com.hersa.sample.project.bom.basesetting.BaseSettingManager;
import com.hersa.sample.project.bom.clientsettingsview.ClientSettingsViewManager;
import com.hersa.sample.project.bom.setting.SettingManager;
import com.hersa.sample.project.dao.basesetting.BaseSetting;
import com.hersa.sample.project.dao.clientsettingsview.ClientSettingsView;
import com.hersa.sample.project.dao.setting.Setting;

@ManagedBean(name="settingsBean")
@SessionScoped
public class SettingPageBean {

	private List<BaseSetting> allUserSettings;
	private List<ClientSettingsView> allClientSettings;
	private ClientSettingsView selectedSetting;
	private List<Setting> allAdminSettings;
	public SettingPageBean() {
		
		initializeVariables();
		loadSettings();
	}
	private void initializeVariables() {
		this.allUserSettings = new ArrayList<BaseSetting>();
		this.allClientSettings = new ArrayList<ClientSettingsView>();
		this.selectedSetting = new ClientSettingsView();
		this.allAdminSettings = new ArrayList<Setting>();
		
	}
	private void loadSettings() {
		BaseSettingManager sm = new BaseSettingManager();
		SettingManager asm = new SettingManager();
		ClientSettingsViewManager csvm = new ClientSettingsViewManager();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		ClientContext clientContext = (ClientContext) applicationContext.getBean("clientContext");
		try {
			this.allUserSettings = sm.retrieveAllBaseSettings();
			this.allClientSettings = csvm.retireveAllClientSettingsViewByClientIdPermission(clientContext.getClient().getClientId(), 3);
			this.allAdminSettings = asm.listAllSettings();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
	}
	public List<BaseSetting> getAllUserSettings() {
		return allUserSettings;
	}
	public void setAllUserSettings(List<BaseSetting> allUserSettings) {
		this.allUserSettings = allUserSettings;
	}
	public List<ClientSettingsView> getAllClientSettings() {
		return allClientSettings;
	}
	public void setAllClientSettings(List<ClientSettingsView> allClientSettings) {
		this.allClientSettings = allClientSettings;
	}
	public ClientSettingsView getSelectedSetting() {
		return selectedSetting;
	}
	public void setSelectedSetting(ClientSettingsView selectedSetting) {
		this.selectedSetting = selectedSetting;
	}
	public List<Setting> getAllAdminSettings() {
		return allAdminSettings;
	}
	public void setAllAdminSettings(List<Setting> allAdminSettings) {
		this.allAdminSettings = allAdminSettings;
	}
}
