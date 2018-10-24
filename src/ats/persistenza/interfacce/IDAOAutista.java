package ats.persistenza.interfacce;

import java.util.List;

import ats.modello.Autista;
import ats.persistenza.implementazione.DAOException;

public interface IDAOAutista {
	public List<Autista> findAll() throws DAOException;
	public Autista findById(Long id) throws DAOException;
	public void update(Autista autista) throws DAOException;
}
