package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class ClienteView {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		System.out.println("LISTAR");
		//Listar os clientes
		List<Cliente> lista = dao.listar();
		
		//Exibir o nome dos clientes
		lista.forEach(item -> System.out.println(item.getNome()));
		
		System.out.println("BUSCAR POR NOME");
		lista = dao.buscarPorNome("a",2,1); //pesquisa por clientes por parte do nome
		lista.forEach(item -> System.out.println(item.getNome())); //exibe o nome dos clientes
		
		System.out.println("BUSCAR POR ESTADO");
		lista = dao.buscarPorEstado("BA");
		lista.forEach(c -> System.out.println(c.getNome() + " " + 
				c.getEndereco().getCidade().getUf()));
		
		System.out.println("BUSCAR POR DIAS RESERVA");
		lista = dao.buscarPorDiasReserva(10);
		lista.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("BUSCAR CLIENTE POR CPF:");
		Cliente cliente = dao.buscarPorCpf("98728018736");
		System.out.println(cliente.getId() + " " + cliente.getNome() + " " + 
				cliente.getCpf() + " " + cliente.getDataNascimento());
		
		em.close();
		fabrica.close();
	}
}
