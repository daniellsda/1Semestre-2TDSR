package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.AreaGerente;
import br.com.fiap.jpa.entity.Departamento;
import br.com.fiap.jpa.entity.Gerente;
import br.com.fiap.jpa.entity.TipoDepartamento;

public class View {

	public static void main(String[] args) {
		//Instanciar EntityManagerFactory e o EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Persistir o departamento e o gerente
		
		//Instanciar o gerente
		Gerente gerente = new Gerente("Allen", AreaGerente.ADMINISTRATIVO);
		
		//Instanciar o departamento
		Departamento dep = new Departamento("Pessoas", TipoDepartamento.RH, gerente);
		
		em.persist(dep);

		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}
