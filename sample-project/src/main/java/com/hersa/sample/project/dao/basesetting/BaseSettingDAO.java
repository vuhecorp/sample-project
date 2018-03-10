package com.hersa.sample.project.dao.basesetting;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BaseSettingDAO {
	public void setConnection(Connection connection);
	public Connection getConnection();
	public List<BaseSetting> listAllSettings() throws SQLException, Exception;
	public List<BaseSetting> retrieveSettingByClientId(long id) throws SQLException;
	public List<BaseSetting> retrieveSettingByCategory(long categoryId) throws SQLException;
	public void updateSetting(BaseSetting setting) throws SQLException;
	public List<BaseSetting> listSettingsByType(long settingTypeId);
}
