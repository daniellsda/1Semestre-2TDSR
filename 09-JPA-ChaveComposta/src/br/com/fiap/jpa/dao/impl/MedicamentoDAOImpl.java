package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MedicamentoDAO;
import br.com.fiap.jpa.entity.Medicamento;

public class MedicamentoDAOImpl
					extends GenericDAOImpl<Medicamento, Integer> 
											implements MedicamentoDAO {

	public MedicamentoDAOImpl(EntityManager em) {
		super(em);
	}

}
