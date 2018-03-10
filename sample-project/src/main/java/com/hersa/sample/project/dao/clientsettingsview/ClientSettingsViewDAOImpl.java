package com.hersa.sample.project.dao.clientsettingsview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.DefaultConnectionProvider;
import com.hersa.sample.project.dao.usersignon.UserSignOn;
import com.hersa.sample.project.utils.Constants;

public class ClientSettingsViewDAOImpl implements ClientSettingsViewDAO {
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
	public List<ClientSettingsView> retrieveClientSettingsByClientId(String clientId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientSettingsView> retrieveClientSettingByClientIdPermission(String clientid, long permission) throws SQLException {
		List<ClientSettingsView> list = null;
		String whereClause = " WHERE clientid = ? and permission <= ?";
		Object[] params = {clientid, permission};
		int[] paramTypes = {Types.INTEGER, Types.BIGINT};
		String orderBy = "category, displayorder";
		try {
			list = listSettings(whereClause, params, paramTypes, orderBy);
		} catch (SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
		return list;
	}

	@Override
	public List<ClientSettingsView> retrieveAllClientSettings() throws Exception {
		List <ClientSettingsView> list = new ArrayList<ClientSettingsView>();
		try {
			list = this.listSettings(null, null, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}
	
	public List<ClientSettingsView> listSettings(String whereClause, Object[] params, int[]types, String orderBy) throws Exception, SQLException{
		PreparedStatement stmt = null;
		Connection con = this.getConnection();
		ResultSet rs = null;
		List<ClientSettingsView> list = new ArrayList<ClientSettingsView>();
		
		if (whereClause == null) {
			whereClause = "";
		}
		if (orderBy == null) {
			orderBy = "";
		}
		
		try {
			String sql = ClientSettingsViewDB.SELECT_CLIENTSETTINGVIEW + whereClause;
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
				ClientSettingsView setting = new ClientSettingsView();
				setting = extractClientSettingsView(rs);
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
	
	private ClientSettingsView extractClientSettingsView(ResultSet rs) throws SQLException {
		ClientSettingsView obj = new ClientSettingsView();
		int i = 1;
		obj.setClientSettingId(rs.getLong(i++));
		obj.setSettingId(rs.getLong(i++));
		obj.setClientId(rs.getString(i++));
		obj.setValue(rs.getString(i++));
		obj.setActive(Boolean.getBoolean(rs.getString(i++)));
		obj.setDisplayOrder(rs.getInt(i++));
		obj.setModifiedOn(rs.getTimestamp(i++));
		obj.setLabelOverride(rs.getString(i++));
		obj.setName(rs.getString(i++));
		obj.setLabel(rs.getString(i++));
		obj.setDescription(rs.getString(i++));
		obj.setCategory(rs.getLong(i++));
		obj.setPermission(rs.getLong(i++));
		return obj;
	}
	
	public List<ClientSettingsView> listAllClientSettings() throws Exception{
		List <ClientSettingsView> list = new ArrayList<ClientSettingsView>();
		try {
			list = this.listSettings(null, null, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}
}
