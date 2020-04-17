package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProjetoDAO;
import br.com.fiap.jpa.entity.Projeto;

public class ProjetoDAOImpl 
			extends GenericDAOImpl<Projeto, Integer> implements ProjetoDAO{

	public ProjetoDAOImpl(EntityManager em) {
		super(em);
	}

}
