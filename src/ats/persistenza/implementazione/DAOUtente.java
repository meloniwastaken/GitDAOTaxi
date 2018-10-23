package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ats.modello.Amministratore;
import ats.modello.Autista;
import ats.modello.Cliente;
import ats.modello.Utente;
import ats.persistenza.interfacce.IDAOUtente;

public class DAOUtente implements IDAOUtente {

	@Override
	public List<Utente> findAll() throws DAOException {
		List<Utente> utenti = new ArrayList<Utente>(0);
		utenti.addAll(new DAOAmministratore().findAll());
		utenti.addAll(new DAOCliente().findAll());
		utenti.addAll(new DAOAutista().findAll());
		return utenti;
	}

	@Override
	public Utente findById(Long id) throws DAOException {
		Utente utente = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer ruolo = resultSet.getInt("RUOLO");
				if (ruolo == 1)
					utente = new Amministratore();
				else if (ruolo == 2)
					utente = new Autista();
				else
					utente = new Cliente();

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

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return utente;
	}

	@Override
	public Utente findByUsernameAndPassword(String username, String password) throws DAOException {
		Utente utente = null;

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE USERNAME = ? AND PASSWORD = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer ruolo = resultSet.getInt("RUOLO");
				if (ruolo == 1)
					utente = new Amministratore();
				else if (ruolo == 2)
					utente = new Autista();
				else
					utente = new Cliente();

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
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utente;
	}

	@Override
	public void update(Utente utente) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(
					"UPDATE UTENTE SET NOME = ?, COGNOME = ?, CODICE_FISCALE = ?, DATA_DI_NASCITA = ?, INDIRIZZO = ?, TELEFONO = ?, EMAIL = ?, USERNAME = ?, PASSWORD = ? WHERE ID = ?");
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getCodiceFiscale());
			Integer gg = utente.getDataDiNascita().getDate();
			Integer mm = utente.getDataDiNascita().getMonth() + 1;
			Integer aaaa = utente.getDataDiNascita().getYear() + 1900;

			String giorno = gg.toString();
			String mese = mm.toString();
			String anno = aaaa.toString();

			if (gg < 10)
				giorno = "0" + giorno;
			if (mm < 10)
				mese = "0" + mese;

			String s = giorno + "-" + mese + "-" + anno;
			System.out.println(s);
			statement.setString(4, s);
			statement.setString(5, utente.getIndirizzo());
			statement.setString(6, utente.getTelefono());
			statement.setString(7, utente.getEmail());
			statement.setString(8, utente.getUsername());
			statement.setString(9, utente.getPassword());
			statement.setLong(10, utente.getId());
			statement.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void insert(Utente utente, Integer ruolo) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO UTENTE VALUES (SEQ_UTENTE.NEXTVAL, ? , ? , ? , TO_DATE(?,'DD-MM-YYYY'), ? , ? , ? , ? , ?, ?)",
					new String[] { "ID" });
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getCodiceFiscale());
			Integer gg = utente.getDataDiNascita().getDate();
			Integer mm = utente.getDataDiNascita().getMonth() + 1;
			Integer aaaa = utente.getDataDiNascita().getYear() + 1900;

			String giorno = gg.toString();
			String mese = mm.toString();
			String anno = aaaa.toString();

			if (gg < 10)
				giorno = "0" + giorno;
			if (mm < 10)
				mese = "0" + mese;

			String s = giorno + "-" + mese + "-" + anno;
			System.out.println(s);
			statement.setString(4, s);
			statement.setString(5, utente.getIndirizzo());
			statement.setString(6, utente.getTelefono());
			statement.setString(7, utente.getEmail());
			statement.setString(8, utente.getUsername());
			statement.setString(9, utente.getPassword());
			statement.setInt(10, ruolo);
			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				utente.setId(resultSet.getLong(1));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}

	@Override
	public void deleteById(Long id) throws DAOException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("DELETE FROM UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}

}
