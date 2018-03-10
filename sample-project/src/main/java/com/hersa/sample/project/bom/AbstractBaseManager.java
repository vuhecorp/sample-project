package com.hersa.sample.project.bom;

import java.sql.Connection;

import com.hersa.sample.project.dao.basesetting.BaseSettingDAO;
import com.hersa.sample.project.dao.basesetting.BaseSettingDAOImpl;
import com.hersa.sample.project.dao.client.ClientDAO;
import com.hersa.sample.project.dao.client.ClientDAOImpl;
import com.hersa.sample.project.dao.clientsettingsview.ClientSettingsViewDAO;
import com.hersa.sample.project.dao.clientsettingsview.ClientSettingsViewDAOImpl;
import com.hersa.sample.project.dao.permissionview.PermissionViewDAO;
import com.hersa.sample.project.dao.permissionview.PermissionViewDAOImpl;
import com.hersa.sample.project.dao.setting.SettingDAO;
import com.hersa.sample.project.dao.setting.SettingDAOImpl;
import com.hersa.sample.project.dao.user.UserDAO;
import com.hersa.sample.project.dao.user.UserDAOImpl;
import com.hersa.sample.project.dao.usersignon.UserSignOnDAO;
import com.hersa.sample.project.dao.usersignon.UserSignOnDAOImpl;

public class AbstractBaseManager {
	
	private Connection connection;
	public AbstractBaseManager() {
//		this.connection = getConnectionProvider();
	}
	
	public Connection getConnectionProvider() {
		return DefaultConnectionProvider.setConnectionProvider(null);
	}
	
	public UserDAO getUserDAO(){
		UserDAO dao = new UserDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;		
	}
	
	public UserSignOnDAO getUserSignOnDAO() {
		UserSignOnDAO dao = new UserSignOnDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;
	}
	public ClientDAO getClientDAO() {
		ClientDAO dao = new ClientDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;
	}
	
	public BaseSettingDAO getBaseSettingDAO() {
		BaseSettingDAO dao = new BaseSettingDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;
	}
	
	public ClientSettingsViewDAO getClientSettingsViewDAO() {
		ClientSettingsViewDAO dao = new ClientSettingsViewDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;
	}
	public PermissionViewDAO getPermissionViewDAO() {
		PermissionViewDAO dao = new PermissionViewDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;
	}
	
	public SettingDAO getSettingDAO() {
		SettingDAO dao = new SettingDAOImpl(); 
		dao.setConnection(getConnectionProvider());
		if (connection != null) {
			dao.setConnection(connection);
		}
		return dao;
	}

	public Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		return getConnectionProvider();
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
 