package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Loja;
import br.com.fiap.jpa.entity.Qualidade;

public class AtualizaTeste {

	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		//Criar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Criar uma Loja com um código que existe no banco
		Loja loja = new Loja("Casas Alagoas", "Av Paulista",
				Calendar.getInstance(), null, 50000, Qualidade.MEDIA);
		loja.setCodigo(1);
		
		//Atualizar a loja
		em.merge(loja);

		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}
