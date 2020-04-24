package br.com.fiap.restaurante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.restaurante.dao.ComandaDAO;
import br.com.fiap.restaurante.entity.Comanda;

public class ComadaDAOImpl 
			extends GenericDAOImpl<Comanda, Integer> implements ComandaDAO {

	public ComadaDAOImpl(EntityManager em) {
		super(em);
	}

}
