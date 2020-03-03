package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Loja;

public class RefreshTeste {

	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar uma loja
		Loja loja = em.find(Loja.class, 1);
		
		//Exibir o nome
		System.out.println(loja.getNome());
		
		//Alterar o nome (setNome)
		loja.setNome("Loja Teste");
		
		//Exibir o nome
		System.out.println(loja.getNome());
		
		//Fazer o refresh
		em.refresh(loja);
		
		//Exibir o nome
		System.out.println(loja.getNome());
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}