package com.hersa.sample.project.bom;

import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.setting.SettingBO;
import com.hersa.sample.project.bom.setting.SettingManager;
import com.hersa.sample.project.dao.setting.Setting;

public class MasterSettingManager {
	

	
	public MasterSettingManager() {
		
	}
	
	public List<SettingBO> loadAdminSettingBO(){
		List<Setting> settingList = new ArrayList<Setting>();
		SettingManager sm = new SettingManager();
		
		return null;
	}
}
