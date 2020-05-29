package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ReptilDAO;
import br.com.fiap.jpa.entity.Reptil;

public class ReptilDAOImpl 
				extends GenericDAOImpl<Reptil, Integer>
								implements ReptilDAO {

	public ReptilDAOImpl(EntityManager em) {
		super(em);
	}

}
