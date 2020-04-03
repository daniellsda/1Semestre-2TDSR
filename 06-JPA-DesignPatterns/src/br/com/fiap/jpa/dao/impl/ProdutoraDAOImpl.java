package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.entity.Produtora;

public class ProdutoraDAOImpl 
					extends GenericDAOImpl<Produtora, Integer> implements ProdutoDAO {

	public ProdutoraDAOImpl(EntityManager em) {
		super(em);
	}

}