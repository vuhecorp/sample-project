package com.hersa.sample.project.bom.clientsettingsview;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.AbstractBaseManager;
import com.hersa.sample.project.dao.clientsettingsview.ClientSettingsView;

public class ClientSettingsViewManager extends AbstractBaseManager {
	
	public List<ClientSettingsView> retireveAllClientSettingsView() throws Exception{
		List<ClientSettingsView> list = new ArrayList<ClientSettingsView>();
		try {
			list = this.getClientSettingsViewDAO().retrieveAllClientSettings();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return list;
	}
	public List<ClientSettingsView> retireveAllClientSettingsViewByClientIdPermission(String clientId, long permission) throws Exception{
		List<ClientSettingsView> list = new ArrayList<ClientSettingsView>();
		try {
			list = this.getClientSettingsViewDAO().retrieveClientSettingByClientIdPermission(clientId, permission);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return list;
	}
}
