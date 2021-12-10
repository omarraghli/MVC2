package com.fstt.doa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fstt.model.Client;

public class ClientDao extends BaseDao<Client> {

	public ClientDao() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Client objetc) throws SQLException {
		String request = "insert into client (nom ,prenom,age) values (?, ?, ?)" ;
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setString(1, objetc.getNom());
		preparedStatement.setString(2, objetc.getPrenom());
		preparedStatement.setInt(3, objetc.getAge());
		preparedStatement.execute() ;
	}

	@Override
	public void update(Client objetc) throws SQLException {
		String request = "update  client  set  nom  = ?,prenom = ? , age = ?  where  id_client = ? " ;
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setString(1, objetc.getNom());
		preparedStatement.setString(2, objetc.getPrenom());
		preparedStatement.setInt(3, objetc.getAge());
		preparedStatement.setInt(4, objetc.getId_client());
		preparedStatement.execute() ;
	}

	@Override
	public void delete(Client objetc) throws SQLException {
		String request = "delete from  client  where  id_client = ? " ;
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getId_client());
		preparedStatement.execute() ;
		
	}

	@Override
	public List<Client> getAll() throws SQLException {
		List<Client> list = new ArrayList<Client>() ;
		stm = cnx.createStatement();
		String request = "select * from client";
		resultSet =    stm.executeQuery(request);
		while(resultSet.next()) {
			// mapping objet relation
			list.add(new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4)));
		}
		return list;
	}

	
	@Override
	public Client getOne(Integer id) throws SQLException {
		String request = "select * from client where  id_client = ? ";
		Client cl  = new  Client() ;
		preparedStatement =  cnx.prepareStatement(request);
		preparedStatement.setInt(1,id);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			// mapping objet relation
			cl =  new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
		}
		return cl;
	}
}
