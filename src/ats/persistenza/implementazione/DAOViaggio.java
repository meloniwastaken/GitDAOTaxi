package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.Date;
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
			statement = connection.prepareStatement("SELECT * FROM VIAGGIO LEFT JOIN UTENTE AUTISTA ON VIAGGIO.AUTISTA = AUTISTA.ID LEFT JOIN TAXI ON VIAGGIO.TAXI = TAXI.ID LEFT JOIN UTENTE CLIENTE ON VIAGGIO.CLIENTE = CLIENTE.ID ORDER BY STATO");
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
				c.setDataDiNascita(resultSet.getDate(36));
				c.setIndirizzo(resultSet.getString(37));
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
				v.setData(resultSet.getTimestamp(5));
				v.setPartenza(resultSet.getString(6));
				v.setDestinazione(resultSet.getString(7));
				v.setKilometri(resultSet.getDouble(8));
				v.setPrezzo(resultSet.getDouble(9));
				v.setStato(resultSet.getInt(10));
				if(resultSet.getInt(11)!=0)
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
			statement = connection.prepareStatement("SELECT * FROM VIAGGIO LEFT JOIN UTENTE AUTISTA ON VIAGGIO.AUTISTA = AUTISTA.ID LEFT JOIN TAXI ON VIAGGIO.TAXI = TAXI.ID LEFT JOIN UTENTE CLIENTE ON VIAGGIO.CLIENTE = CLIENTE.ID WHERE VIAGGIO.ID = ?");
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
				c.setDataDiNascita(resultSet.getDate(36));
				c.setIndirizzo(resultSet.getString(37));
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
				if(v.getFeedback()!=null)
					statement.setInt(10, v.getFeedback());
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
			statement.setDate(4, (Date) v.getData());
			statement.setString(5, v.getPartenza());
			statement.setString(6, v.getDestinazione());
			statement.setDouble(7, v.getKilometri());
			statement.setDouble(8, v.getPrezzo());
			statement.setInt(9, v.getStato());
			if(v.getFeedback()!=null)
				statement.setInt(10, v.getFeedback());
			else
				statement.setNull(10, 0);
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

	@SuppressWarnings("deprecation")
	@Override
	public void insert(Viaggio v) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("INSERT INTO VIAGGIO VALUES (SEQ_VIAGGIO.NEXTVAL,?,?,?,TO_DATE(?,'DD-MM-YYYY HH24:MI:SS'),?,?,?,?,?,?)", new String[] {"ID"});
			statement.setLong(1, v.getAutista().getId());
			statement.setLong(2, v.getTaxi().getId());
			statement.setLong(3, v.getCliente().getId());
			
			Integer gg = v.getData().getDate();
			Integer mm = v.getData().getMonth() + 1;
			Integer aaaa = v.getData().getYear() + 1900;
			Integer hh = v.getData().getHours();
			Integer mi = v.getData().getMinutes();

			String giorno = gg.toString();
			String mese = mm.toString();
			String anno = aaaa.toString();
			String ore = hh.toString();
			String minuti = mi.toString();

			if (gg < 10)
				giorno = "0" + giorno;
			if (mm < 10)
				mese = "0" + mese;
			if(hh<10)
				ore = "0" + ore;
			if(mi<10)
				minuti = "0" + minuti;

			String s = giorno + "-" + mese + "-" + anno + " " + ore + ":" + minuti + ":00";

			statement.setString(4, s);
			statement.setString(5, v.getPartenza());
			statement.setString(6, v.getDestinazione());
			statement.setDouble(7, v.getKilometri());
			statement.setDouble(8, v.getPrezzo());
			statement.setInt(9, v.getStato());
			if(v.getFeedback()!=null)
				statement.setInt(10, v.getFeedback());
			else
				statement.setString(10, null);
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

	@Override
	public List<Viaggio> findByCliente(Long id) throws DAOException {

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
			statement = connection.prepareStatement("SELECT * FROM VIAGGIO LEFT JOIN UTENTE AUTISTA ON VIAGGIO.AUTISTA = AUTISTA.ID LEFT JOIN TAXI ON VIAGGIO.TAXI = TAXI.ID LEFT JOIN UTENTE CLIENTE ON VIAGGIO.CLIENTE = CLIENTE.ID WHERE CLIENTE.ID = ? ORDER BY STATO");
			statement.setLong(1, id);
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
				c.setDataDiNascita(resultSet.getDate(36));
				c.setIndirizzo(resultSet.getString(37));
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
				if(resultSet.getInt(11)!=0)
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
	public List<Viaggio> findByAutista(Long id) throws DAOException {

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
			statement = connection.prepareStatement("SELECT * FROM VIAGGIO LEFT JOIN UTENTE AUTISTA ON VIAGGIO.AUTISTA = AUTISTA.ID LEFT JOIN TAXI ON VIAGGIO.TAXI = TAXI.ID LEFT JOIN UTENTE CLIENTE ON VIAGGIO.CLIENTE = CLIENTE.ID WHERE AUTISTA.ID = ? ORDER BY STATO");
			statement.setLong(1, id);
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
				c.setDataDiNascita(resultSet.getDate(36));
				c.setIndirizzo(resultSet.getString(37));
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
				if(resultSet.getInt(11)!=0)
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
	public List<Double> findStatisticheCliente(Long id) throws DAOException {
		String sql = "SELECT COUNT(CLIENTE) AS VIAGGI_TOTALI, SUM(KILOMETRI) AS SOMMA_KILOMETRI, SUM(PREZZO) AS SOMMA_PREZZO, SUM(FEEDBACK)/(SELECT COUNT(*) FROM VIAGGIO WHERE CLIENTE = ? AND FEEDBACK IS NOT NULL) AS MEDIA_FEEDBACK FROM VIAGGIO WHERE CLIENTE = ? AND STATO=4 GROUP BY(CLIENTE)";
		List<Double> statisticheCliente = new ArrayList<Double>(0);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setLong(2, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				statisticheCliente.add(0,resultSet.getDouble(1));
				statisticheCliente.add(1,resultSet.getDouble(2));
				statisticheCliente.add(2,resultSet.getDouble(3));
				statisticheCliente.add(3,resultSet.getDouble(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return statisticheCliente;
	}
	
	@Override
	public List<Double> findStatisticheAutista(Long id) throws DAOException {
		String sql = "SELECT COUNT(AUTISTA) AS VIAGGI_TOTALI, SUM(KILOMETRI) AS SOMMA_KILOMETRI, SUM(PREZZO) AS SOMMA_PREZZO, SUM(FEEDBACK)/(SELECT COUNT(*) FROM VIAGGIO WHERE AUTISTA = ? AND FEEDBACK IS NOT NULL) AS MEDIA_FEEDBACK FROM VIAGGIO WHERE AUTISTA = ? AND STATO=4 GROUP BY(AUTISTA)";
		List<Double> statisticheCliente = new ArrayList<Double>(0);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.setLong(2, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				statisticheCliente.add(0,resultSet.getDouble(1));
				statisticheCliente.add(1,resultSet.getDouble(2));
				statisticheCliente.add(2,resultSet.getDouble(3));
				statisticheCliente.add(3,resultSet.getDouble(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return statisticheCliente;
	}
	
	public List<Double> findStatisticheTotali() throws DAOException {
		String sql = "SELECT COUNT(*) AS VIAGGI_TOTALI, SUM(KILOMETRI) AS SOMMA_KILOMETRI, SUM(PREZZO) AS SOMMA_PREZZO, SUM(FEEDBACK)/(SELECT COUNT(*) FROM VIAGGIO WHERE FEEDBACK IS NOT NULL) AS MEDIA_FEEDBACK FROM VIAGGIO GROUP BY()";
		List<Double> statisticheCliente = new ArrayList<Double>(0);
		DataSource instance = DataSource.getInstance();
		Connection connection = instance.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				statisticheCliente.add(0,resultSet.getDouble(1));
				statisticheCliente.add(1,resultSet.getDouble(2));
				statisticheCliente.add(2,resultSet.getDouble(3));
				statisticheCliente.add(3,resultSet.getDouble(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage(), e);
		} finally {
			instance.close(resultSet);
			instance.close(statement);
			instance.close(connection);
		}
		return statisticheCliente;
	}
}
