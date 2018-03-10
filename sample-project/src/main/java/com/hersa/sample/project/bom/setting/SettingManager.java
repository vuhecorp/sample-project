package com.hersa.sample.project.bom.setting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.AbstractBaseManager;
import com.hersa.sample.project.dao.setting.Setting;

public class SettingManager extends AbstractBaseManager{

	public List<Setting> listAllSettings(){
		List<Setting> list = new ArrayList<Setting>();
		try {
			list = this.getSettingDAO().listAllSettings();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Setting getSettingById(String clientId, long settingId) {
		Setting setting = new Setting();
		try {
			setting = this.getSettingDAO().retrieveSettingsByClientIdSettingId(settingId, clientId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setting;
	}
}
