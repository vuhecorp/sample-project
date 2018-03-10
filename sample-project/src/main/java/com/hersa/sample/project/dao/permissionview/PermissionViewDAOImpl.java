package com.hersa.sample.project.dao.permissionview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.DefaultConnectionProvider;
import com.hersa.sample.project.dao.util.ConnectionProvider;
import com.hersa.sample.project.utils.Constants;

public class PermissionViewDAOImpl implements PermissionViewDAO{
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
	public void setConnectionProvider(ConnectionProvider factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PermissionView> listPermissionViewByResourceName(long roleId, String resourceName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermissionView> listPermissionViewByRoleId(long roleId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermissionView> listPermissionViewByModule(long roleId, String moduleName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<PermissionView> listPermissionView(String whereClause, Object[] params, int[]types, String orderBy) throws Exception, SQLException{
		PreparedStatement stmt = null;
		Connection con = this.getConnection();
		ResultSet rs = null;
		List<PermissionView> list = new ArrayList<PermissionView>();
		
		if (whereClause == null) {
			whereClause = "";
		}
		if (orderBy == null) {
			orderBy = "";
		}
		
		try {
			String sql = PermissionViewDB.SELECT_PERMISSION_VIEW + whereClause;
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
				PermissionView permission = new PermissionView();
				permission = extractPermissionView(rs);
				list.add(permission);
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

	private PermissionView extractPermissionView(ResultSet rs) throws SQLException {
		PermissionView obj = new PermissionView();
		int i = 1;
		
		obj.setRoleId(rs.getLong(i++));
		obj.setPermissionName(rs.getString(i++));
		obj.setResourceName(rs.getString(i++));
		obj.setResourceType(rs.getString(i++));
		obj.setAdminResource(Boolean.parseBoolean(rs.getString(i++)));
		obj.setAllowed(Boolean.parseBoolean(rs.getString(i++)));
		obj.setDescription(rs.getString(i++));
		return obj;
	}
	
	public List<PermissionView> listAllPermissionView() throws SQLException{
		List<PermissionView> list = new ArrayList<PermissionView>();
		try {
			list = listPermissionView(null, null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
