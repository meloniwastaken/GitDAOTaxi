package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ats.modello.Cliente;
import ats.persistenza.interfacce.IDAOCliente;

public class DAOCliente implements IDAOCliente {

	public List<Cliente> findAll() throws DAOException {
		List<Cliente> utenti = new ArrayList<Cliente>(0);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE RUOLO = 3");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cliente utente = new Cliente();
				utente.setId(resultSet.getLong(1));
				utente.setNome(resultSet.getString(2));
				utente.setCognome(resultSet.getString(3));
				utente.setCodiceFiscale(resultSet.getString(4));
				utente.setDataDiNascita(resultSet.getDate(5));
				utente.setIndirizzo(resultSet.getString(6));
				utente.setTelefono(resultSet.getString(7));
				utente.setEmail(resultSet.getString(8));
				utente.setUsername(resultSet.getString(9));
				utente.setPassword(resultSet.getString(10));
				utenti.add(utente);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utenti;
	}

	public Cliente findById(Long id) throws DAOException {
		Cliente c = null;
		String sql = "SELECT * FROM UTENTE WHERE RUOLO=3 AND ID=?";
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				c = new Cliente();
				c.setId(resultSet.getLong(1));
				c.setNome(resultSet.getString(2));
				c.setCognome(resultSet.getString(3));
				c.setCodiceFiscale(resultSet.getString(4));
				c.setDataDiNascita(resultSet.getDate(5));
				c.setIndirizzo(resultSet.getString(6));
				c.setTelefono(resultSet.getString(7));
				c.setEmail(resultSet.getString(8));
				c.setUsername(resultSet.getString(9));
				c.setPassword(resultSet.getString(10));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return c;
	}

}
