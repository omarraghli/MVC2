package com.fstt.doa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fstt.model.HasManyCommandeProduit;

public class HasManyCommandeProduitDao extends BaseDao<HasManyCommandeProduit> {
	CommandeDao cmndDao =new CommandeDao();
	ProduitDao prodDao = new ProduitDao();

	public HasManyCommandeProduitDao() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(HasManyCommandeProduit objetc) throws SQLException {
		String request = "insert into commandeproduit (id_commande,id_produit) values (?, ?)" ;

		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getCmnd().getId_commande());
		preparedStatement.setInt(2, objetc.getProd().getId_produit());
		preparedStatement.execute() ;
	}

	@Override
	public void update(HasManyCommandeProduit objetc) throws SQLException {
		String request = "update  commandeproduit  set  id_commande  = ? ,id_produit = ?  where  id_commandeproduit = ?" ;
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getCmnd().getId_commande());
		preparedStatement.setInt(2, objetc.getProd().getId_produit());
		preparedStatement.setInt(3, objetc.getId_commandeproduit());
		preparedStatement.execute() ;
		
	}

	@Override
	public void delete(HasManyCommandeProduit objetc) throws SQLException {
		String request = "delete from  commandeproduit  where  id_commandeproduit = ?" ;
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getId_commandeproduit());
		preparedStatement.execute() ;
		
	}

	@Override
	public List<HasManyCommandeProduit> getAll() throws SQLException {
		List<HasManyCommandeProduit> list = new ArrayList<HasManyCommandeProduit>() ;
		stm = cnx.createStatement();
		String request = "select * from commandeproduit";
		resultSet =  stm.executeQuery(request);
		while(resultSet.next()) {
			// mapping objet relation
			list.add(new HasManyCommandeProduit(resultSet.getInt(1), cmndDao.getOne(resultSet.getInt(2)) , prodDao.getOne(resultSet.getInt(3))));
		}
		return list;
	}

	@Override
	public HasManyCommandeProduit getOne(Integer id) throws SQLException {
		String request = "select * from commandeproduit where  id_commandeproduit  = ? ";
		HasManyCommandeProduit cl  = new  HasManyCommandeProduit() ;
		preparedStatement =  cnx.prepareStatement(request);
		preparedStatement.setInt(1,id);
		
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			// mapping objet relation
			cl =  new HasManyCommandeProduit(resultSet.getInt(1), cmndDao.getOne(resultSet.getInt(2)) , prodDao.getOne(resultSet.getInt(3)));
		}
		return cl;
	}


}
