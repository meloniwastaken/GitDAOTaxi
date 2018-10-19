package ats.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ats.modello.Amministratore;
import ats.modello.Autista;
import ats.modello.Cliente;
import ats.modello.Utente;
import ats.persistenza.interfacce.IDAOUtente;

public class DAOUtente implements IDAOUtente {

	@Override
	public List<Utente> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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
			
			if(resultSet.next()) {
				Integer ruolo = resultSet.getInt("RUOLO");
				if(ruolo==1)
					utente = new Amministratore();
				else if (ruolo==2)
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
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utente;
	}

	@Override
	public void update(Utente u) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Utente u) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
