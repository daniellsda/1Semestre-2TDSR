package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.MedicoDAO;
import br.com.fiap.jpa.entity.Medico;

public class MedicoDAOImpl 
					extends GenericDAOImpl<Medico, Integer> 
												implements MedicoDAO {

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

}
