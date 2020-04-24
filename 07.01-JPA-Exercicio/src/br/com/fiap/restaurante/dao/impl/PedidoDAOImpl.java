package br.com.fiap.restaurante.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.restaurante.dao.PedidoDAO;
import br.com.fiap.restaurante.entity.Pedido;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido, Integer> implements PedidoDAO {

	public PedidoDAOImpl(EntityManager em) {
		super(em);
	}

}
