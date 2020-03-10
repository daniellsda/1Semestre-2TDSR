package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.LivroDAO;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.exception.DeuRuimNoBancoException;
import br.com.fiap.jpa.exception.NaoTemLivroException;

public class LivroDAOImpl implements LivroDAO {

	//Objeto que interage com o banco de dados
	private EntityManager em;
	
	//Construtor que recebe o EntityManager
	public LivroDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void inserir(Livro livro) {
		em.persist(livro);		
	}

	@Override
	public Livro pesquisar(int codigo) {
		return em.find(Livro.class, codigo);
	}

	@Override
	public void deletar(int codigo) throws NaoTemLivroException {
		Livro livro = pesquisar(codigo);//pesquisa o livro para remover
		//Validar se existe um livro para ser apagado
		if (livro ==null) {
			throw new NaoTemLivroException();
		}
		em.remove(livro);	
	}

	@Override
	public void atualizar(Livro livro) {
		em.merge(livro);		
	}

	@Override
	public void commit() throws DeuRuimNoBancoException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			//Desfaz a transação
			em.getTransaction().rollback();
			//Lançar uma exception 
			//para notificar as outras camadas
			throw new DeuRuimNoBancoException();
		}		
	}

	
	
}

