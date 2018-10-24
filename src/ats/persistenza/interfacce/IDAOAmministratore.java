package ats.persistenza.interfacce;

import java.util.List;

import ats.modello.Amministratore;
import ats.persistenza.implementazione.DAOException;

public interface IDAOAmministratore {
	public List<Amministratore> findAll() throws DAOException;
	public Amministratore findById(Long id) throws DAOException;
}
