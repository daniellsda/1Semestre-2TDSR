package br.com.fiap.restaurante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.restaurante.dao.ClienteDAO;
import br.com.fiap.restaurante.entity.Cliente;

public class ClienteDAOImpl 
			extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO {

	public ClienteDAOImpl(EntityManager em) {
		super(em);
	}

}
