package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Loja;

public class RemoveTeste {

	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar uma loja no banco
		Loja loja = em.find(Loja.class, 1);
		
		//Remover a loja
		em.remove(loja);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}