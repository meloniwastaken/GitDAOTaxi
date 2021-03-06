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
		String sql = "SELECT * FROM TAXI LEFT JOIN UTENTE ON TAXI.AUTISTA=UTENTE.ID";
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
				if(resultSet.getLong(9)!=0) {
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
				else
					t.setAutista(null);
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
		String sql = "SELECT * FROM TAXI LEFT JOIN UTENTE ON TAXI.AUTISTA=UTENTE.ID WHERE TAXI.ID=?";
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
				if(resultSet.getLong(9)!=0) {
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
				else
					t.setAutista(null);
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
		String sql = "INSERT INTO TAXI VALUES (SEQ_TAXI.NEXTVAL,?,?,?,?,?,?,?,NULL)";
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
		String sql = "UPDATE TAXI SET MODELLO=?, MARCA=?, TARGA=?, ANNO_IMMATRICOLAZIONE=?, POSTI=?, PREZZO_PER_KILOMETRO=?, DISPONIBILE=?, AUTISTA=? WHERE ID=?";
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
			System.out.println(disponibile);
			if (disponibile == true)
				statement.setInt(7, 1);
			else if (disponibile==false) 
				statement.setInt(7, 0);
			if(t.getAutista()==null)
				statement.setNull(8, 0);
			else
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
	public List<Double> findStatistiche(Long id) throws DAOException {
		String sql = "SELECT COUNT(TAXI.ID) AS VIAGGI_TOTALI, SUM(KILOMETRI) AS SOMMA_KILOMETRI FROM TAXI INNER JOIN VIAGGIO ON TAXI.ID = VIAGGIO.TAXI WHERE TAXI.ID = ? GROUP BY (TAXI.ID)";
		List<Double> statistiche = new ArrayList<Double>(0);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				statistiche.add(0,resultSet.getDouble(1));
				statistiche.add(1,resultSet.getDouble(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return statistiche;
	}

	@Override
	public void deleteAutistaFromTaxi(Long id) throws DAOException {
		String sql = "UPDATE TAXI SET AUTISTA = NULL WHERE AUTISTA = ?";
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

	@Override
	public Taxi findByIdAutista(Long id) throws DAOException {
		Taxi t = null;
		String sql = "SELECT * FROM TAXI LEFT JOIN UTENTE ON TAXI.AUTISTA=UTENTE.ID WHERE UTENTE.ID=?";
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
				if(resultSet.getLong(9)!=0) {
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
				else
					t.setAutista(null);
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
	public Boolean canDeleteTaxi(Long id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(*) FROM VIAGGIO WHERE TAXI = ? AND STATO <> 4 GROUP BY TAXI");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getInt(1)!=0)
					return false;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return true;
	}

}
