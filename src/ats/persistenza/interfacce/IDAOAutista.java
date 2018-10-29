package ats.persistenza.interfacce;

import java.util.List;
import java.util.Map;

import ats.modello.Autista;
import ats.modello.Taxi;
import ats.persistenza.implementazione.DAOException;

public interface IDAOAutista {
	public abstract List<Autista> findAll() throws DAOException;
	public abstract Map<Autista,Taxi> findAllWithTaxi() throws DAOException;
	public abstract Autista findById(Long id) throws DAOException;
	public abstract void update(Autista autista) throws DAOException;
	public abstract void insert(Autista autista) throws DAOException;
	public abstract void delete(Long id) throws DAOException;
}
