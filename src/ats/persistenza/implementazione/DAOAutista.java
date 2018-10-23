package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ats.modello.Autista;
import ats.modello.Cliente;

public class DAOAutista {
	public List<Autista> findAll() throws DAOException {
		List<Autista> utenti = new ArrayList<Autista>(0);

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM UTENTE RIGHT JOIN STIPENDIO ON UTENTE.ID = STIPENDIO.ID");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Autista utente = new Autista();

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
				utente.setStipendio(resultSet.getDouble(13));
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
	
	public Autista findById(Long id) throws DAOException {
		Autista a = null;
		String sql = "SELECT * FROM UTENTE RIGHT JOIN STIPENDIO ON UTENTE.ID = STIPENDIO.ID WHERE UTENTE.ID = ?";
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				a = new Autista();
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
				a.setStipendio(resultSet.getDouble(12));

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
