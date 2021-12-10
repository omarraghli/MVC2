package com.fstt.doa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fstt.model.Commande;

public class CommandeDao extends BaseDao<Commande> {
	ClientDao cDao= new ClientDao();

	public CommandeDao() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Commande objetc) throws SQLException {
		String request = "insert into commande (id_client) values (?)" ;
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getClient().getId_client());
		preparedStatement.execute() ;
	}
	

	@Override
	public void update(Commande objetc) throws SQLException {
		String request = "update  commande  set  id_client  = ? where  id_commande = ? " ;
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getClient().getId_client());
		preparedStatement.setInt(2, objetc.getId_commande());
		preparedStatement.execute() ;
		
	}

	@Override
	public void delete(Commande objetc) throws SQLException {
		String request = "delete from  commande  where  id_commande = ? " ;
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getId_commande());
		preparedStatement.execute() ;
		
	}

	@Override
	public List<Commande> getAll() throws SQLException {
		List<Commande> list = new ArrayList<Commande>() ;
		stm = cnx.createStatement();
		String request = "select * from commande";
		resultSet =    stm.executeQuery(request);
		while(resultSet.next()) {
			// mapping objet relation
			list.add(new Commande(resultSet.getInt(1), cDao.getOne(resultSet.getInt(2)) ));
		}
		return list;
	}

	@Override
	public Commande getOne(Integer id) throws SQLException {
		String request = "select * from commande where  id_commande = ? ";
		Commande cm  = new  Commande() ;
		preparedStatement =  cnx.prepareStatement(request);
		preparedStatement.setInt(1,id);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			cm =  new Commande(resultSet.getInt(1), cDao.getOne(resultSet.getInt(2)));
		}
		return cm;
	}

}
