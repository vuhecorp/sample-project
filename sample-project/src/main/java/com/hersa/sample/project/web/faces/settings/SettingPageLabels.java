package com.hersa.sample.project.web.faces.settings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="settingLabelBean")
@SessionScoped
public class SettingPageLabels {
	
	private String heading;
	private String editSettingMessage;
	private String settingsTableHeader;
	
	public SettingPageLabels() {
		this.heading = "Settings Dashboard";
		this.editSettingMessage = "Choose a setting form the table to edit its value.";
		this.settingsTableHeader = "Settings";
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getEditSettingMessage() {
		return editSettingMessage;
	}

	public void setEditSettingMessage(String editSettingMessage) {
		this.editSettingMessage = editSettingMessage;
	}

	public String getSettingsTableHeader() {
		return settingsTableHeader;
	}

	public void setSettingsTableHeader(String settingsTableHeader) {
		this.settingsTableHeader = settingsTableHeader;
	}
}
