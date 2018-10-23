package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ats.modello.Amministratore;
import ats.modello.Cliente;

public class DAOAmministratore {
	public List<Amministratore> findAll() throws DAOException {
		List<Amministratore> utenti = new ArrayList<Amministratore>(0);

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE RUOLO = 1");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Amministratore utente = new Amministratore();

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
	
	public Amministratore findById(Long id) throws DAOException {
		Amministratore a = null;
		String sql = "SELECT * FROM UTENTE WHERE RUOLO=1 AND ID=?";
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				a = new Amministratore();
				a.setId(resultSet.getLong(1));
				a.setNome(resultSet.getString(2));
				a.setCognome(resultSet.getString(3));
				a.setCodiceFiscale(resultSet.getString(4));
				a.setDataDiNascita(resultSet.getDate(5));
				a.setIndirizzo(resultSet.getString(6));
				a.setTelefono(resultSet.getString(7));
				a.setEmail(resultSet.getString(8));
				a.setUsername(resultSet.getString(9));
				a.setPassword(resultSet.getString(10));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return a;
	}
}
