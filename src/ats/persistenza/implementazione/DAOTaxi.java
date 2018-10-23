package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ats.modello.Autista;
import ats.modello.Taxi;
import ats.persistenza.interfacce.IDAOTaxi;

public class DAOTaxi implements IDAOTaxi {

	@Override
	public List<Taxi> findAll() throws DAOException {
		List<Taxi> listaTaxi = new ArrayList<Taxi>();
		String sql = "SELECT * FROM TAXI INNER JOIN UTENTE ON TAXI.AUTISTA=UTENTE.ID WHERE RUOLO=2";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Taxi t = new Taxi();
				t.setId(resultSet.getLong(1));
				t.setModello(resultSet.getString(2));
				t.setMarca(resultSet.getString(3));
				t.setTarga(resultSet.getString(4));
				t.setAnnoDiImmatricolazione(resultSet.getInt(5));
				t.setPosti(resultSet.getInt(6));
				t.setPrezzoPerKilometro(resultSet.getDouble(7));
				Integer disponibile = resultSet.getInt(8);
				if (disponibile == 0)
					t.setDisponibile(false);
				else if (disponibile == 1)
					t.setDisponibile(true);

				Autista a = new Autista();
				a.setId(resultSet.getLong(9));
				a.setNome(resultSet.getString(11));
				a.setCognome(resultSet.getString(12));
				a.setCodiceFiscale(resultSet.getString(13));
				a.setDataDiNascita(resultSet.getDate(14));
				a.setIndirizzo(resultSet.getString(15));
				a.setTelefono(resultSet.getString(16));
				a.setEmail(resultSet.getString(17));
				a.setUsername(resultSet.getString(18));
				a.setPassword(resultSet.getString(19));
				t.setAutista(a);
				listaTaxi.add(t);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return listaTaxi;

	}

	@Override
	public Taxi findById(Long id) throws DAOException {
		Taxi t = null;
		String sql = "SELECT * FROM TAXI INNER JOIN UTENTE ON TAXI.AUTISTA=UTENTE.ID WHERE RUOLO=2 AND TAXI.ID=?";
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				t = new Taxi();
				t.setId(id);
				t.setModello(resultSet.getString(2));
				t.setMarca(resultSet.getString(3));
				t.setTarga(resultSet.getString(4));
				t.setAnnoDiImmatricolazione(resultSet.getInt(5));
				t.setPosti(resultSet.getInt(6));
				t.setPrezzoPerKilometro(resultSet.getDouble(7));
				Integer disponibile = resultSet.getInt(8);
				if (disponibile == 0)
					t.setDisponibile(false);
				else if (disponibile == 1)
					t.setDisponibile(true);

				Autista a = new Autista();
				a.setId(resultSet.getLong(9));
				a.setNome(resultSet.getString(11));
				a.setCognome(resultSet.getString(12));
				a.setCodiceFiscale(resultSet.getString(13));
				a.setDataDiNascita(resultSet.getDate(14));
				a.setIndirizzo(resultSet.getString(15));
				a.setTelefono(resultSet.getString(16));
				a.setEmail(resultSet.getString(17));
				a.setUsername(resultSet.getString(18));
				a.setPassword(resultSet.getString(19));
				t.setAutista(a);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return t;

	}

	@Override
	public void insert(Taxi t) throws DAOException {
		String sql = "INSERT INTO TAXI VALUES (SEQ_TAXI.NEXTVAL,?,?,?,?,?,?,?)";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql, new String[] { "ID" });
			statement.setString(1, t.getModello());
			statement.setString(2, t.getMarca());
			statement.setString(3, t.getTarga());
			statement.setInt(4, t.getAnnoDiImmatricolazione());
			statement.setInt(5, t.getPosti());
			statement.setDouble(6, t.getPrezzoPerKilometro());
			Boolean disponibile = t.getDisponibile();
			if (disponibile == true)
				statement.setInt(7, 1);
			else
				statement.setInt(7, 0);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				t.setId(resultSet.getLong(1));
			}
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
	}

	@Override
	public void update(Taxi t) throws DAOException {
		String sql = "UPDATE TAXI SET MODELLO=?, MARCA=?, TARGA=?, anno_immatricolazione=?, POSTI=?, prezzo_km=?, DISPONIBILE=?, AUTISTA=? WHERE ID=?";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, t.getModello());
			statement.setString(2, t.getMarca());
			statement.setString(3, t.getTarga());
			statement.setInt(4, t.getAnnoDiImmatricolazione());
			statement.setInt(5, t.getPosti());
			statement.setDouble(6, t.getPrezzoPerKilometro());
			Boolean disponibile = t.getDisponibile();
			if (disponibile == true)
				statement.setInt(7, 1);
			else
				statement.setInt(7, 0);
			statement.setLong(8, t.getAutista().getId()); //FK autista
			statement.setLong(9, t.getId());
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
	public void deleteById(Long id) throws DAOException {
		String sql = "DELETE FROM TAXI WHERE ID=?";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(statement);
			instance.close(connection);
		}
	}
	
	public List<Taxi> findAllDisponibili() throws DAOException {
		List<Taxi> listaTaxi = new ArrayList<Taxi>();
		String sql = "SELECT * FROM TAXI INNER JOIN UTENTE ON TAXI.AUTISTA=UTENTE.ID WHERE RUOLO=2 AND DISPONIBILE=1";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Taxi t = new Taxi();
				t.setId(resultSet.getLong(1));
				t.setModello(resultSet.getString(2));
				t.setMarca(resultSet.getString(3));
				t.setTarga(resultSet.getString(4));
				t.setAnnoDiImmatricolazione(resultSet.getInt(5));
				t.setPosti(resultSet.getInt(6));
				t.setPrezzoPerKilometro(resultSet.getDouble(7));
				Integer disponibile = resultSet.getInt(8);
				if (disponibile == 0)
					t.setDisponibile(false);
				else if (disponibile == 1)
					t.setDisponibile(true);

				Autista a = new Autista();
				a.setId(resultSet.getLong(9));
				a.setNome(resultSet.getString(11));
				a.setCognome(resultSet.getString(12));
				a.setCodiceFiscale(resultSet.getString(13));
				a.setDataDiNascita(resultSet.getDate(14));
				a.setIndirizzo(resultSet.getString(15));
				a.setTelefono(resultSet.getString(16));
				a.setEmail(resultSet.getString(17));
				a.setUsername(resultSet.getString(18));
				a.setPassword(resultSet.getString(19));
				t.setAutista(a);
				listaTaxi.add(t);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return listaTaxi;

	}

}
