package ats.persistenza.interfacce;

import ats.persistenza.implementazione.DAOException;

import java.util.List;

import ats.modello.Taxi;

public interface IDAOTaxi {

	public abstract List<Taxi> findAll() throws DAOException;
	public abstract List<Taxi> findAllDisponibili() throws DAOException;
	public abstract Taxi findById(Long id) throws DAOException;
	public abstract void insert(Taxi t) throws DAOException;
	public abstract void update(Taxi t) throws DAOException;
	public abstract void deleteById(Long id) throws DAOException;
	public abstract List<Double> findStatistiche(Long id) throws DAOException;
	public abstract void deleteAutistaFromTaxi(Long id) throws DAOException;
	public abstract Taxi findByIdAutista(Long id) throws DAOException;
	public abstract Boolean canDeleteTaxi(Long id) throws DAOException;

}
