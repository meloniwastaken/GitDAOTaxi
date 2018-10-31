package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ats.modello.Autista;
import ats.modello.Taxi;
import ats.modello.Utente;
import ats.persistenza.interfacce.IDAOAutista;
import ats.persistenza.interfacce.IDAOTaxi;
import ats.persistenza.interfacce.IDAOUtente;

public class DAOAutista implements IDAOAutista {
	public List<Autista> findAll() throws DAOException {
		List<Autista> utenti = new ArrayList<Autista>(0);

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM UTENTE RIGHT JOIN STIPENDIO ON UTENTE.ID = STIPENDIO.ID ORDER BY UTENTE.COGNOME");
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
				a.setStipendio(resultSet.getDouble(13));

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

	@Override
	public void update(Autista autista) throws DAOException {
		IDAOUtente daoUtente = new DAOUtente();
		daoUtente.update(autista);

		Connection connection = null;
		PreparedStatement statement = null;
		connection = DataSource.getInstance().getConnection();
		try {
			statement = connection.prepareStatement("UPDATE STIPENDIO SET STIPENDIO = ? WHERE ID = ?");
			statement.setDouble(1, autista.getStipendio());
			statement.setLong(2, autista.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}

	@Override
	public void insert(Autista autista) throws DAOException {
		IDAOUtente daoUtente = new DAOUtente();
		daoUtente.insert(autista, 2);
		String sql = "INSERT INTO STIPENDIO VALUES (?,?)";
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement=null;
		System.out.println(autista.getId());
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, autista.getId());
			statement.setDouble(2, autista.getStipendio());
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
	public void delete(Long id) throws DAOException {
		IDAOUtente daoUtente = new DAOUtente();
		IDAOTaxi daoTaxi = new DAOTaxi();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT TAXI.ID FROM TAXI INNER JOIN UTENTE ON TAXI.AUTISTA = UTENTE.ID WHERE UTENTE.ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Long taxiId = resultSet.getLong(1);
				Taxi t = daoTaxi.findById(taxiId);
				t.setDisponibile(false);
				t.setAutista(null);
				daoTaxi.update(t);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public Map<Autista, Taxi> findAllWithTaxi() throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Map<Autista,Taxi> map = new HashMap<Autista,Taxi>();
		

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE LEFT JOIN TAXI ON UTENTE.ID = TAXI.AUTISTA LEFT JOIN STIPENDIO ON UTENTE.ID = STIPENDIO.ID WHERE UTENTE.RUOLO = 2");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Autista a = new Autista();
				Taxi t = null;
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
				a.setStipendio(resultSet.getDouble(22));
				
				if(resultSet.getLong(12)!=0) {
					t = new Taxi();
					t.setId(resultSet.getLong(12));
					t.setModello(resultSet.getString(13));
					t.setMarca(resultSet.getString(14));
					t.setTarga(resultSet.getString(15));
					t.setAnnoDiImmatricolazione(resultSet.getInt(16));
					t.setPosti(resultSet.getInt(17));
					t.setPrezzoPerKilometro(resultSet.getDouble(18));
					Integer disponibile = resultSet.getInt(19);
					if (disponibile == 0)
						t.setDisponibile(false);
					else if (disponibile == 1)
						t.setDisponibile(true);
				}
				
				map.put(a, t);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return map;
	}
}
