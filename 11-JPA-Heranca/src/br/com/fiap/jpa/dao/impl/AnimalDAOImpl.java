package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.AnimalDAO;
import br.com.fiap.jpa.entity.Animal;

public class AnimalDAOImpl extends GenericDAOImpl<Animal, Integer>
													implements AnimalDAO {

	public AnimalDAOImpl(EntityManager em) {
		super(em);
	}

}
