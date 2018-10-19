package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "DAOTaxi";
	private static final String PASSWORD = "DAOTaxi";
	private static DataSource instance;
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private DataSource() {
		super();
	}
	
	public static DataSource getInstance() {
		if(instance == null)
			instance = new DataSource();
		return instance;
	}
	
	public Connection getConnection() throws DAOException {
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(),e);
		}
	}
	
	public void close(Connection connection) {
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public void close(Statement statement) {
		if(statement!=null)
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public void close(ResultSet resultSet) {
		if(resultSet!=null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	
}
