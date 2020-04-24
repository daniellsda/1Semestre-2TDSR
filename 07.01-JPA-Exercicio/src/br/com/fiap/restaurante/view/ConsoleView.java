package br.com.fiap.restaurante.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.restaurante.dao.PedidoDAO;
import br.com.fiap.restaurante.dao.impl.PedidoDAOImpl;
import br.com.fiap.restaurante.entity.Cliente;
import br.com.fiap.restaurante.entity.Comanda;
import br.com.fiap.restaurante.entity.Funcao;
import br.com.fiap.restaurante.entity.Garcom;
import br.com.fiap.restaurante.entity.Pedido;
import br.com.fiap.restaurante.entity.Prato;
import br.com.fiap.restaurante.entity.TipoPrato;

public class ConsoleView {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		
		//Instanciar o EntityManagerFactory e EntityManager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um Garçom
		Garcom garcom = new Garcom("Thiago", Funcao.BEBIDAS);
		
		//Instanciar um Cliente
		Cliente cliente = new Cliente("Sérgio");
		
		//Instanciar uma Comanda com o cliente
		Comanda comanda = new Comanda(Calendar.getInstance(), 2, cliente);
		
		//Instaciar uma lista de pratos e adicionar 2 pratos
		List<Prato> pratos = new ArrayList<Prato>();
		pratos.add(new Prato("Lasanha", 20, TipoPrato.TRADICIONAL));
		pratos.add(new Prato("Parmegiana", 25, TipoPrato.VEGETARIANO));
		
		//Instanciar o pedido com o garçom, o cliente e a lista de pratos
		Pedido pedido = new Pedido(Calendar.getInstance(), garcom, pratos, comanda);
		
		//Instanciar o PedidoDAOImpl
		PedidoDAO dao = new PedidoDAOImpl(em);
		
		try {
			dao.inserir(pedido); //Cadastrar o pedido
			dao.commit(); 	//Commit
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
