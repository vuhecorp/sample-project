package com.hersa.sample.project.dao.clientsettingsview;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ClientSettingsViewDAO {
	public void setConnection(Connection connection);
	public Connection getConnection();
	public List<ClientSettingsView> retrieveClientSettingsByClientId(String clientId) throws SQLException;
	public List<ClientSettingsView> retrieveClientSettingByClientIdPermission(String clientId, long permission) throws SQLException;
	public List<ClientSettingsView> retrieveAllClientSettings() throws Exception;
}
