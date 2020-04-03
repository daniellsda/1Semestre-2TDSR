package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.jpa.entity.Classificacao;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View2 {

	public static void main(String[] args) {
		//Criar a fabrica e o entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar uma classe anomima que é filha do GenericDAOImpl
		GenericDAO<Filme,Integer> dao = new GenericDAOImpl<Filme, Integer>(em){};
			
		Filme filme = new Filme("Frozen", 100, Genero.ROMANCE, Classificacao.LIVRE,
				new GregorianCalendar(2020, Calendar.JANUARY, 1));
		
		dao.inserir(filme);
		try {
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}
