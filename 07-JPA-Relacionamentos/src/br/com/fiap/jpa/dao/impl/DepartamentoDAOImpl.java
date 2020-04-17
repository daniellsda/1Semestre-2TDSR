package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.DepartamentoDAO;
import br.com.fiap.jpa.entity.Departamento;

public class DepartamentoDAOImpl 
			extends GenericDAOImpl<Departamento, Integer>
									implements DepartamentoDAO {

	public DepartamentoDAOImpl(EntityManager em) {
		super(em);
	}

}
