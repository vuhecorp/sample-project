package com.hersa.sample.project.bom.basesetting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.AbstractBaseManager;
import com.hersa.sample.project.dao.basesetting.BaseSetting;

public class BaseSettingManager extends AbstractBaseManager{
	public List<BaseSetting> retrieveAllBaseSettings() throws Exception{
		List <BaseSetting> list = new ArrayList<BaseSetting>();
		try {
			list = this.getBaseSettingDAO().listAllSettings();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("An error occured while retrieving settings.");
		}
		return list;
		
	}
}
