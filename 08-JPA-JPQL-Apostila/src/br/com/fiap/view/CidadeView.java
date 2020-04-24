package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CidadeView {
	
	public static void main(String[] args) {
		
		//Instanciar o EntityManagerFactory e o EntityManager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DAO da cidade
		CidadeDAO dao = new CidadeDAOImpl(em);
		
		//Pesquisar todas as cidades
		List<Cidade> lista = dao.listar();
		
		//Exibir o nome e o estado da cidade
		for (Cidade cidade: lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		//Pesquisar as cidades por DDD
		
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
