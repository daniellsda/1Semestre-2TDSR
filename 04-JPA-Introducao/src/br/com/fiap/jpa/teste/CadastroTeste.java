package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Loja;
import br.com.fiap.jpa.entity.Qualidade;

public class CadastroTeste {

	public static void main(String[] args) {
		//Criar uma fabrica de Entity Manager
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		
		//Criar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar uma Loja
		Loja loja = new Loja("Fiap Store", 
				"Lins de Vasconcelos",
				Calendar.getInstance(), null,
				10000, Qualidade.BOA);
		
		//Cadastrar
		em.persist(loja);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}

