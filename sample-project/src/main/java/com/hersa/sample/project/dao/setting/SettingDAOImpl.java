package com.hersa.sample.project.dao.setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.DefaultConnectionProvider;
import com.hersa.sample.project.dao.clientsettingsview.ClientSettingsView;
import com.hersa.sample.project.utils.Constants;

public class SettingDAOImpl implements SettingDAO{
	private Connection connection = null;
	private boolean setByCaller;
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
		setByCaller = true;
	}

	@Override
	public Connection getConnection() {
		if (setByCaller) {
			return connection;
		}
		connection = DefaultConnectionProvider.setConnectionProvider(Constants.USER_PROVIDER);
		return connection;
	}

	@Override
	public Setting retrieveSettingsByClientIdSettingId(long settingId, String clientId) throws SQLException {
		Setting setting = new Setting();
		String whereClause = " WHERE clientid = ? and settingid = ?";
		Object[] params = {clientId, settingId};
		int[] paramTypes = {Types.VARCHAR, Types.BIGINT};
		
		try {
			setting = listClientSettings(whereClause, params, paramTypes, null).get(0);
		} catch (SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
		return setting;
	}

	@Override
	public void updateClientSetting(Setting adminSetting) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public List<Setting> listClientSettings(String whereClause, Object[] params, int[]types, String orderBy) throws Exception, SQLException{
		PreparedStatement stmt = null;
		Connection con = this.getConnection();
		ResultSet rs = null;
		List<Setting> list = new ArrayList<Setting>();
		
		if (whereClause == null) {
			whereClause = "";
		}
		if (orderBy == null) {
			orderBy = "";
		}
		
		try {
			String sql = SettingDB.SELECT_ADMINSETTING + whereClause;
			stmt = con.prepareStatement(sql);
			if (!whereClause.isEmpty()) {
				try {
					for (int i = 0; i < params.length; i++) {
						stmt.setObject(i+1, params[i], types[i]);
					}
				} catch (Exception e) {
					throw new Exception("Error setting params.");
				}
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				Setting setting = new Setting();
				setting = extractAdminSetting(rs);
				list.add(setting);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new SQLException("There was an error in retrieving client settings.");
		}finally {
			if (!setByCaller) {
				connection.close();
			}
		}
		return list;
	}
	
	private Setting extractAdminSetting(ResultSet rs) throws SQLException {
		
		Setting obj = new Setting();
			
		int i = 1;
		
		obj.setId(rs.getLong(i++));
		obj.setSettingId(rs.getLong(i++));
		obj.setClientId(rs.getString(i++));
		obj.setValue(rs.getString(i++));
		obj.setActive(Boolean.parseBoolean(rs.getString(i++)));
		obj.setDisplayOrder(rs.getInt(i++));
		obj.setModifiedOn(rs.getTimestamp(i++));
		obj.setLabelOverride(rs.getString(i++));
		obj.setAllowedOverride(rs.getString(i++));
		
		return obj;
	}
	
	public List<Setting> listAllSettings(){
		List<Setting> list = new ArrayList<Setting>();
		
		try {
			list = this.listClientSettings(null, null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Setting> listSettingsByClientIdSettingId(long settingId, String clientId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
