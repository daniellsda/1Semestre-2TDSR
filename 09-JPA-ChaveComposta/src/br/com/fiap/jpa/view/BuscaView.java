package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ItemPedidoDAO;
import br.com.fiap.jpa.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.ItemPedidoPK;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaView {

	public static void main(String[] args) {
		//Instanciar fabrica, em e dao
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		ItemPedidoDAO dao = new ItemPedidoDAOImpl(em);
		
		//Pesquisar um item de pedido pela PK
		ItemPedidoPK pk = new ItemPedidoPK(1, 1);
		ItemPedido item = dao.pesquisar(pk);
	
		//Exibir o nome do medicamento e valor
		System.out.println(item.getMedicamento().getNome() + " " + item.getValor());
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
		
}
