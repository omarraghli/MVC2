package com.fstt.doa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fstt.model.Produit;

public class ProduitDao extends BaseDao<Produit> {

	public ProduitDao() throws SQLException, ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Produit objetc) throws SQLException {
		String request = "insert into produit (nom_produit, prix_produit) values (?, ?)" ;
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setString(1, objetc.getNom_produit());
		preparedStatement.setInt(2, objetc.getPrix_produit());
		preparedStatement.execute() ;
	}

	@Override
	public void update(Produit objetc) throws SQLException {
		String request = "update  produit  set  nom_produit  = ?,prix_produit = ?  where  id_produit  = ? " ;
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setString(1, objetc.getNom_produit());
		preparedStatement.setInt(2, objetc.getPrix_produit());
		preparedStatement.setInt(3, objetc.getId_produit());
		preparedStatement.execute() ;
		
	}

	@Override
	public void delete(Produit objetc) throws SQLException {
		String request = "delete from  produit  where  id_produit = ? " ;
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setInt(1, objetc.getId_produit());
		preparedStatement.execute() ;
		
	}

	@Override
	public List<Produit> getAll() throws SQLException {
		List<Produit> list = new ArrayList<Produit>() ;
		stm = cnx.createStatement();
		String request = "select * from produit";
		resultSet =    stm.executeQuery(request);
		while(resultSet.next()) {
			// mapping objet relation
			list.add(new Produit(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3)));
		}
		return list;
	}

	@Override
	public Produit getOne(Integer id) throws SQLException {
		String request = "select * from produit where  id_produit = ? ";
		Produit prod  = new  Produit() ;
		preparedStatement =  cnx.prepareStatement(request);
		preparedStatement.setInt(1,id);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			// mapping objet relation
			prod =  new Produit(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));
		}
		return prod;
	}

}
