package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Loja;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Criar a fabrica de entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar a loja de c�digo 1
		Loja loja = em.find(Loja.class, 21);
		
		//Exibir o nome da loja
		System.out.println(loja.getNome());
		System.out.println(loja.getFaturamentoAnual());
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}