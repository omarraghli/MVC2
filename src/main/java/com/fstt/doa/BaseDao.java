package com.fstt.doa;

import java.sql.*;
import java.util.List;

public abstract class BaseDao <T> {
protected Connection cnx ;
	
	protected Statement stm ;
	
	protected PreparedStatement preparedStatement ;
	
	
	protected ResultSet resultSet ;
	
	
	
	public BaseDao() throws SQLException, ClassNotFoundException {
		// singleton 
		this.cnx = GConnection.getConnection();
		
	}
	
	
	public abstract void save(T objetc) throws SQLException;
	
	public abstract void update(T objetc) throws SQLException;
	
	public abstract void delete (T objetc) throws SQLException;
	
	public abstract List<T> getAll () throws SQLException;
	
	public abstract T getOne(Integer id) throws SQLException;
}
