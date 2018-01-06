package com.hersa.sample.project.dao.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hersa.sample.project.DuplicateUserException;
import com.hersa.sample.project.dao.util.ConnectionProvider;

public interface UserDAO {

	public void setConnection(Connection connection);
	public Connection getConnection();
	public void setConnectionProvider(ConnectionProvider factory);
	public List<User> retrieveUserByEmail(String Username);
	public void updateUser(User user) throws Exception;
	public void deleteUser(User user) throws SQLException;
	public User createUser(User user) throws DuplicateUserException, SQLException, Exception;
	public User listUserById(int id) throws Exception;
	public User[] listAllUsers();
}
