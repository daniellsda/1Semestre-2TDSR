package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MamiferoDAO;
import br.com.fiap.jpa.entity.Mamifero;

public class MamiferoDAOImpl 
					extends GenericDAOImpl<Mamifero, Integer>
										implements MamiferoDAO {

	public MamiferoDAOImpl(EntityManager em) {
		super(em);
	}

}
