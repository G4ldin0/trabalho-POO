package br.edu.ufersa.hospital.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class BaseDAO{
	Connection conn = null;
	String url = "jdbc:mysql://localhost/hospital";
	String user = "root";
	String password = "senha123";

	synchronized public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		else return conn;
	}
}
