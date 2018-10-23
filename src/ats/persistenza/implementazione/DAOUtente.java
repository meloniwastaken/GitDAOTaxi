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
		utenti.addAll(this.findAllAmministratore());
		utenti.addAll(this.findAllCliente());
		utenti.addAll(this.findAllAutista());
		return utenti;
	}

	public List<Cliente> findAllCliente() throws DAOException {
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

	public List<Amministratore> findAllAmministratore() throws DAOException {
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

	public List<Autista> findAllAutista() throws DAOException {
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
			statement.setString(4, (utente.getDataDiNascita().toString()));
			statement.setString(5, utente.getIndirizzo());
			statement.setString(6, utente.getTelefono());
			statement.setString(7, utente.getEmail());
			statement.setString(8, utente.getUsername());
			statement.setString(9, utente.getPassword());
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

	@Override
	public Cliente findClienteById(Long id) throws DAOException {
		Cliente c = null;
		String sql = "SELECT * FROM UTENTE WHERE RUOLO=3 AND ID=?";
		System.out.println(sql);
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
