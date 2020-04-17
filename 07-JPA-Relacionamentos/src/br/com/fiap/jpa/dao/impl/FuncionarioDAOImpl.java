package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.FuncionarioDAO;
import br.com.fiap.jpa.entity.Funcionario;

public class FuncionarioDAOImpl extends GenericDAOImpl<Funcionario, Integer> implements FuncionarioDAO{

	public FuncionarioDAOImpl(EntityManager em) {
		super(em);
	}

}
