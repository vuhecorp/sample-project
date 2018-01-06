package com.hersa.sample.project.bom;

import java.sql.Connection;

import com.hersa.sample.project.dao.client.ClientDAO;
import com.hersa.sample.project.dao.client.ClientDAOImpl;
import com.hersa.sample.project.dao.clientsettings.ClientSettingsDAO;
import com.hersa.sample.project.dao.clientsettings.ClientSettingsDAOImpl;
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
	
	public ClientSettingsDAO getClientSettingsDAO() {
		ClientSettingsDAO dao = new ClientSettingsDAOImpl(); 
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
 