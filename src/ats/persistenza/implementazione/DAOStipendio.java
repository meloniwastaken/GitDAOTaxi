package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ats.persistenza.interfacce.IDAOStipendio;

public class DAOStipendio implements IDAOStipendio {

	@Override
	public void insert(Long id, Double s) throws DAOException {
		String sql = "INSERT INTO STIPENDIO VALUES (?,?)";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setDouble(2, s);
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(statement);
			instance.close(connection);
		}

	}

	@Override
	public void update(Long id, Double s) throws DAOException {
		String sql = "UPDATE STIPENDIO SET ID=?, STIPENDIO=?";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setDouble(2, s);
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(statement);
			instance.close(connection);
		}

	}

}
