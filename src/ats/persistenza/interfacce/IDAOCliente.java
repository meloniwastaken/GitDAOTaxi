package ats.persistenza.interfacce;

import java.util.List;

import ats.modello.Cliente;
import ats.persistenza.implementazione.DAOException;

public interface IDAOCliente {
	public List<Cliente> findAll() throws DAOException;
	public Cliente findById(Long id) throws DAOException;
}
