package ats.persistenza.interfacce;

import java.util.List;

import ats.modello.Viaggio;
import ats.persistenza.implementazione.DAOException;

public interface IDAOViaggio {
	public abstract List<Viaggio> findAll() throws DAOException;
	public abstract List<Viaggio> findByCliente(Long id) throws DAOException;
	public abstract List<Viaggio> findByAutista(Long id) throws DAOException;
	public abstract Viaggio findById(Long id) throws DAOException;
	public abstract void update(Viaggio v) throws DAOException;
	public abstract void insert(Viaggio v) throws DAOException;
	public abstract void deleteById(Long id) throws DAOException;
	public List<Double> findStatisticheAutista(Long id) throws DAOException;
	public List<Double> findStatisticheCliente(Long id) throws DAOException;
	public List<Double> findStatisticheTotali() throws DAOException;
}
