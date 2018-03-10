package com.hersa.sample.project.dao.setting;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SettingDAO {
	public void setConnection(Connection connection);
	public Connection getConnection();
	public List<Setting> listSettingsByClientIdSettingId(long settingId, String clientId) throws SQLException;
	public void updateClientSetting(Setting adminSetting) throws SQLException;
	public List<Setting> listAllSettings() throws SQLException;
	public Setting retrieveSettingsByClientIdSettingId(long settingId, String clientId) throws SQLException;
	/*public void setConnection(Connection connection);
	public Connection getConnection();
	public ClientSettings retrieveClientSettingsByClientId(String clientId) throws SQLException;
	public List<ClientSettings> listClientSettings(String whereClause, Object[] params, int[]types, String orderBy) 
			throws SQLException;*/
}
