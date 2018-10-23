package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ats.modello.Autista;
import ats.modello.Cliente;
import ats.modello.Taxi;
import ats.modello.Viaggio;
import ats.persistenza.interfacce.IDAOViaggio;

public class DAOViaggio implements IDAOViaggio{

	@Override
	public List<Viaggio> findAll() throws DAOException {

		List<Viaggio> listaViaggi = new ArrayList<Viaggio>(0);
		Viaggio v = null;
		Cliente c = null;
		Autista a = null;
		Taxi t = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM VIAGGIO INNER JOIN UTENTE AUTISTA ON VIAGGIO.AUTISTA = AUTISTA.ID INNER JOIN TAXI ON VIAGGIO.TAXI = TAXI.ID INNER JOIN UTENTE CLIENTE ON VIAGGIO.CLIENTE = CLIENTE.ID");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				a = new Autista();
				a.setId(resultSet.getLong(12));
				a.setNome(resultSet.getString(13));
				a.setCognome(resultSet.getString(14));
				a.setCodiceFiscale(resultSet.getString(15));
				a.setDataDiNascita(resultSet.getDate(16));
				a.setIndirizzo(resultSet.getString(17));
				a.setTelefono(resultSet.getString(18));
				a.setEmail(resultSet.getString(19));
				a.setUsername(resultSet.getString(20));
				a.setPassword(resultSet.getString(21));
				//22 ruolo
				
				t = new Taxi();
				t.setId(resultSet.getLong(23));
				t.setModello(resultSet.getString(24));
				t.setMarca(resultSet.getString(25));
				t.setTarga(resultSet.getString(26));
				t.setAnnoDiImmatricolazione(resultSet.getInt(27));
				t.setPosti(resultSet.getInt(28));
				t.setPrezzoPerKilometro(resultSet.getDouble(29));
				if(resultSet.getInt(30) == 1) 
					t.setDisponibile(true);
				else
					t.setDisponibile(false);
				t.setAutista(a);
				//31 autista
				
				c = new Cliente();
				c.setId(resultSet.getLong(32));
				c.setNome(resultSet.getString(33));
				c.setCognome(resultSet.getString(34));
				c.setCodiceFiscale(resultSet.getString(35));
				c.setIndirizzo(resultSet.getString(36));
				c.setDataDiNascita(resultSet.getDate(37));
				c.setTelefono(resultSet.getString(38));
				c.setEmail(resultSet.getString(39));
				c.setUsername(resultSet.getString(40));
				c.setPassword(resultSet.getString(41));
				//42 ruolo
				
				v = new Viaggio();
				v.setId(resultSet.getLong(1));
				v.setAutista(a);
				v.setTaxi(t);
				v.setCliente(c);
				v.setData(resultSet.getDate(5));
				v.setPartenza(resultSet.getString(6));
				v.setDestinazione(resultSet.getString(7));
				v.setKilometri(resultSet.getDouble(8));
				v.setPrezzo(resultSet.getDouble(9));
				v.setStato(resultSet.getInt(10));
				v.setFeedback(resultSet.getInt(11));
				
				listaViaggi.add(v);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return listaViaggi;
	}

	@Override
	public Viaggio findById(Long id) throws DAOException {
		Viaggio v = null;
		Cliente c = null;
		Autista a = null;
		Taxi t = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM VIAGGIO INNER JOIN UTENTE AUTISTA ON VIAGGIO.AUTISTA = AUTISTA.ID INNER JOIN TAXI ON VIAGGIO.TAXI = TAXI.ID INNER JOIN UTENTE CLIENTE ON VIAGGIO.CLIENTE = CLIENTE.ID WHERE VIAGGIO.ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				a = new Autista();
				a.setId(resultSet.getLong(12));
				a.setNome(resultSet.getString(13));
				a.setCognome(resultSet.getString(14));
				a.setCodiceFiscale(resultSet.getString(15));
				a.setDataDiNascita(resultSet.getDate(16));
				a.setIndirizzo(resultSet.getString(17));
				a.setTelefono(resultSet.getString(18));
				a.setEmail(resultSet.getString(19));
				a.setUsername(resultSet.getString(20));
				a.setPassword(resultSet.getString(21));
				//22 ruolo
				
				t = new Taxi();
				t.setId(resultSet.getLong(23));
				t.setModello(resultSet.getString(24));
				t.setMarca(resultSet.getString(25));
				t.setTarga(resultSet.getString(26));
				t.setAnnoDiImmatricolazione(resultSet.getInt(27));
				t.setPosti(resultSet.getInt(28));
				t.setPrezzoPerKilometro(resultSet.getDouble(29));
				if(resultSet.getInt(30) == 1) 
					t.setDisponibile(true);
				else
					t.setDisponibile(false);
				t.setAutista(a);
				//31 autista
				
				c = new Cliente();
				c.setId(resultSet.getLong(32));
				c.setNome(resultSet.getString(33));
				c.setCognome(resultSet.getString(34));
				c.setCodiceFiscale(resultSet.getString(35));
				c.setIndirizzo(resultSet.getString(36));
				c.setDataDiNascita(resultSet.getDate(37));
				c.setTelefono(resultSet.getString(38));
				c.setEmail(resultSet.getString(39));
				c.setUsername(resultSet.getString(40));
				c.setPassword(resultSet.getString(41));
				//42 ruolo
				
				v = new Viaggio();
				v.setId(resultSet.getLong(1));
				v.setAutista(a);
				v.setTaxi(t);
				v.setCliente(c);
				v.setData(resultSet.getDate(5));
				v.setPartenza(resultSet.getString(6));
				v.setDestinazione(resultSet.getString(7));
				v.setKilometri(resultSet.getDouble(8));
				v.setPrezzo(resultSet.getDouble(9));
				v.setStato(resultSet.getInt(10));
				v.setFeedback(resultSet.getInt(11));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return v;
	}

	@Override
	public void update(Viaggio v) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("UPDATE VIAGGIO SET AUTISTA = ?, TAXI = ?, CLIENTE = ?, DATA = ?, PARTENZA = ?, DESTINAZIONE = ?, KILOMETRI = ?, PREZZO = ?, STATO = ?, FEEDBACK = ? WHERE ID = ?");
			statement.setLong(1, v.getAutista().getId());
			statement.setLong(2,v.getTaxi().getId());
			statement.setLong(3, v.getCliente().getId());
			statement.setString(4, v.getData().toString());
			statement.setString(5, v.getPartenza());
			statement.setString(6, v.getDestinazione());
			statement.setDouble(7, v.getKilometri());
			statement.setDouble(8, v.getPrezzo());
			statement.setInt(9, v.getStato());
			statement.setInt(10, v.getFeedback());
			statement.setLong(11, v.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}

	@Override
	public void insert(Viaggio v) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("INSERT INTO VIAGGIO VALUES (SEQ_VIAGGIO.NEXTVAL,?,?,?,?,?,?,?,?,?,?)", new String[] {"ID"});
			statement.setLong(1, v.getAutista().getId());
			statement.setLong(2,v.getTaxi().getId());
			statement.setLong(3, v.getCliente().getId());
			statement.setString(4, v.getData().toString());
			statement.setString(5, v.getPartenza());
			statement.setString(6, v.getDestinazione());
			statement.setDouble(7, v.getKilometri());
			statement.setDouble(8, v.getPrezzo());
			statement.setInt(9, v.getStato());
			statement.setInt(10, v.getFeedback());
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) 
				v.setId(resultSet.getLong(1));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		finally {
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
			statement = connection.prepareStatement("DELETE FROM VIAGGIO WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
}