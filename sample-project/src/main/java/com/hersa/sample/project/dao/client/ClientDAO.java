package com.hersa.sample.project.dao.client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



public interface ClientDAO {
	public void setConnection(Connection connection);
	public Connection getConnection();
	public List<Client> retrieveClientById(long id) throws SQLException;
	public List<Client> retrieveClientByClientId(String clientId) throws SQLException;
	public void updateClient(Client client);
	public void deleteClient(Client client);
	public Client createClient(Client client);
	public List<Client> listAllClients();
}
