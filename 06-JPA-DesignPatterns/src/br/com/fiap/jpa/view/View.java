package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.FilmeDAO;
import br.com.fiap.jpa.dao.impl.FilmeDAOImpl;
import br.com.fiap.jpa.entity.Classificacao;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Instanciar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DAO
		FilmeDAO dao = new FilmeDAOImpl(em);
		
		//Instanciar um filme
		Filme filme = new Filme("O Poderoso chefão", 175, 
				Genero.ACAO, Classificacao.MAIOR_18, 
				new GregorianCalendar(1972, Calendar.JANUARY, 1));
		
		try {
			//Cadastrar 
			dao.inserir(filme);
			dao.commit();
			System.out.println("Filme cadastrado!");
			
			//Pesquisar 
			Filme busca = dao.pesquisar(filme.getCodigo());
			System.out.println("Filme: " + busca.getNome());
			
			//Atualizar 
			busca.setGenero(Genero.AVENTURA);
			dao.atualizar(busca);
			dao.commit();
			System.out.println("Filme atualizado!");
			
			//Remover 
			dao.remover(busca.getCodigo());
			dao.commit();
			System.out.println("Filme removido!");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}

}