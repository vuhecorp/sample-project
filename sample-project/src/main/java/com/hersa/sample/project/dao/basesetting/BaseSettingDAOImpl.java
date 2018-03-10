package com.hersa.sample.project.dao.basesetting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.DefaultConnectionProvider;
import com.hersa.sample.project.utils.Constants;

public class BaseSettingDAOImpl implements BaseSettingDAO {
	private Connection connection;
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
	public List<BaseSetting> retrieveSettingByClientId(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseSetting> retrieveSettingByCategory(long categoryId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSetting(BaseSetting setting) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public List<BaseSetting> listSettings(String whereClause, Object[] params, int[]types, String orderBy) throws Exception, SQLException{
		PreparedStatement stmt = null;
		Connection con = this.getConnection();
		ResultSet rs = null;
		List<BaseSetting> list = new ArrayList<BaseSetting>();
		
		if (whereClause == null) {
			whereClause = "";
		}
		if (orderBy == null) {
			orderBy = "";
		}
		
		try {
			String sql = BaseSettingDB.SELECT_SETTING + whereClause;
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
				BaseSetting setting = new BaseSetting();
				setting = extractSetting(rs);
				list.add(setting);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new SQLException("There was an error in retrieving settings.");
		}finally {
			if (!setByCaller) {
				connection.close();
			}
		}
		return list;
	}
	private BaseSetting extractSetting(ResultSet rs) throws SQLException {
		BaseSetting obj = new BaseSetting();
		int i = 1;
		obj.setId(rs.getLong(i++));;
		obj.setBaseSettingTypeId(rs.getLong(i++));
		obj.setName(rs.getString(i++));
		obj.setLabel(rs.getString(i++));
		obj.setDescription(rs.getString(i++));
		obj.setCategory(rs.getLong(i++));
		obj.setDataType(rs.getString(i++));
		obj.setAllowedValues(rs.getString(i++));
		return obj;
	}

	@Override
	public List<BaseSetting> listAllSettings() throws Exception {
		List<BaseSetting> list = new ArrayList<BaseSetting>();
		try {
			list = this.listSettings(null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return list;
	}

	@Override
	public List<BaseSetting> listSettingsByType(long settingTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
