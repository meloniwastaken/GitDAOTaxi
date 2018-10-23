package ats.persistenza.interfacce;

import java.util.List;

import ats.modello.Amministratore;
import ats.modello.Autista;
import ats.modello.Cliente;
import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;

public interface IDAOUtente {
	public abstract List<Utente> findAll() throws DAOException;

	public abstract List<Amministratore> findAllAmministratore() throws DAOException;

	public abstract List<Cliente> findAllCliente() throws DAOException;

	public abstract List<Autista> findAllAutista() throws DAOException;

	public abstract Utente findById(Long id) throws DAOException;

	public abstract Utente findByUsernameAndPassword(String username, String password) throws DAOException;

	public abstract void update(Utente u) throws DAOException;

	public abstract void insert(Utente u, Integer ruolo) throws DAOException;

	public abstract void deleteById(Long id) throws DAOException;
	
	public abstract Cliente findClienteById(Long id) throws DAOException;
}
