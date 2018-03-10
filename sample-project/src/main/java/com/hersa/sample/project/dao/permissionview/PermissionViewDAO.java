package com.hersa.sample.project.dao.permissionview;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hersa.sample.project.dao.util.ConnectionProvider;

public interface PermissionViewDAO {
	public void setConnection(Connection connection);
	public Connection getConnection();
	public void setConnectionProvider(ConnectionProvider factory);
	public List<PermissionView> listPermissionViewByResourceName(long roleId, String resourceName) throws SQLException;
	public List<PermissionView> listPermissionViewByRoleId(long roleId) throws SQLException;
	public List<PermissionView> listPermissionViewByModule(long roleId, String moduleName) throws SQLException;
	public List<PermissionView> listAllPermissionView() throws SQLException;
}
