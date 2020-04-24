package br.com.fiap.restaurante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.restaurante.dao.GarcomDAO;
import br.com.fiap.restaurante.entity.Garcom;

public class GarcomDAOImpl 
		extends GenericDAOImpl<Garcom, Integer> implements GarcomDAO {

	public GarcomDAOImpl(EntityManager em) {
		super(em);
	}

}
