package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ItemPedidoDAO;
import br.com.fiap.jpa.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.Medicamento;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroView {

	//Cadastrar um medicamento, pedido e item pedido
	public static void main(String[] args) {
		
		//Instanciar a fabrica, em e o dao do item de pedido
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		ItemPedidoDAO dao = new ItemPedidoDAOImpl(em);
		
		//Instanciar um medicamento
		Medicamento medicamento = new Medicamento("Novalgina",
						new GregorianCalendar(2021, Calendar.JANUARY, 1), false);
		
		//Instanciar um pedido
		Pedido pedido = new Pedido(Calendar.getInstance(), 10);
		
		//Instanciar um item de pedido
		ItemPedido item = new ItemPedido(medicamento, pedido, 10, 1);
		
		try {
			//Cadastrar o item de pedido
			dao.inserir(item);
			dao.commit();
			System.out.println("Cadastro realizado!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}