package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Gerente;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GerenteDAO;

public class GerenteDAOImpl extends GenericDAOImpl<Gerente, Integer> implements GerenteDAO{

	public GerenteDAOImpl(EntityManager em) {
		super(em);
	}

}
