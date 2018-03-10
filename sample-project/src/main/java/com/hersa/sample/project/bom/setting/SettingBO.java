package com.hersa.sample.project.bom.setting;

import com.hersa.sample.project.dao.basesetting.BaseSetting;
import com.hersa.sample.project.dao.setting.Setting;

public class SettingBO {
	
	private BaseSetting baseSetting;
	private Setting setting;
	
	public SettingBO() {
		
	}
	public SettingBO(BaseSetting baseSetting, Setting adminSetting) {
		this.baseSetting = baseSetting;
		this.setting = adminSetting;
	}
	public BaseSetting getBaseSetting() {
		return baseSetting;
	}
	public void setBaseSetting(BaseSetting baseSetting) {
		this.baseSetting = baseSetting;
	}
	public Setting getSetting() {
		return setting;
	}
	public void setSetting(Setting setting) {
		this.setting = setting;
	}


	
}
