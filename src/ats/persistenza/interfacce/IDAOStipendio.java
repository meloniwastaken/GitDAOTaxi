package ats.persistenza.interfacce;

import ats.persistenza.implementazione.DAOException;

public interface IDAOStipendio {

	public abstract void insert(Long id, Double s) throws DAOException;

	public abstract void update(Long id, Double s) throws DAOException;

}
