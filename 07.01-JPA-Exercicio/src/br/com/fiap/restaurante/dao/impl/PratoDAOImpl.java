package br.com.fiap.restaurante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.restaurante.dao.PratoDAO;
import br.com.fiap.restaurante.entity.Prato;

public class PratoDAOImpl 
			extends GenericDAOImpl<Prato, Integer> implements PratoDAO {

	public PratoDAOImpl(EntityManager em) {
		super(em);
	}

}