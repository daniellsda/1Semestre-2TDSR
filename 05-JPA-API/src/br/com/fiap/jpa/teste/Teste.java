package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.LivroDAO;
import br.com.fiap.jpa.dao.impl.LivroDAOImpl;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.exception.DeuRuimNoBancoException;
import br.com.fiap.jpa.exception.NaoTemLivroException;

public class Teste {

	public static void main(String[] args) {
		//Instanciar uma fabrica
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		
		//Instanciar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um LivroDAOImpl
		LivroDAO dao = new LivroDAOImpl(em);
		
		//Instanciar um Livro
		Livro livro = new Livro("Java como Programar 12ed.", 
					Calendar.getInstance(), 800, Genero.ACAO);
		
		try {
			//Cadastrar um livro
			dao.inserir(livro);
			dao.commit();
			System.out.println("Livro cadastrado com sucesso");
		} catch (DeuRuimNoBancoException e) {
			System.out.println("Erro ao cadastrar..");
		}
		
		//Pesquisar um livro
		Livro busca = dao.pesquisar(livro.getCodigo());
		System.out.println(busca.getNome());
		
		try {
			//Atualizar um livro
			busca.setNome("Aprenda java em 21 dias");
			dao.atualizar(busca);
			dao.commit();
			System.out.println("Livro atualizado com sucesso");
		} catch (DeuRuimNoBancoException e) {
			System.out.println("Erro ao atualizar..");
		}
		
		//Remover um livro
		try {
			dao.deletar(livro.getCodigo());
			dao.commit();
			System.out.println("Livro removido com sucesso");
		} catch (NaoTemLivroException e) {
			System.out.println("Livro não encontrado");
		} catch (DeuRuimNoBancoException e) {
			System.out.println("Erro ao remover");
		}
		
		//Fechar as paradas
		em.close();
		fabrica.close();
	}
	
}