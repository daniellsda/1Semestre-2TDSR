package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ItemPedidoDAO;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.ItemPedidoPK;

public class ItemPedidoDAOImpl 
					extends GenericDAOImpl<ItemPedido, ItemPedidoPK>
										implements ItemPedidoDAO {

	public ItemPedidoDAOImpl(EntityManager em) {
		super(em);
	}

}
