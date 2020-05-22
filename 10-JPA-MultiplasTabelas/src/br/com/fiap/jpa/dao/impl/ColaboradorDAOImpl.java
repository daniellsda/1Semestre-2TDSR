package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ColaboradorDAO;
import br.com.fiap.jpa.entity.Colaborador;

public class ColaboradorDAOImpl 
					extends GenericDAOImpl<Colaborador, Integer>
											implements ColaboradorDAO {

	public ColaboradorDAOImpl(EntityManager em) {
		super(em);
	}

}
