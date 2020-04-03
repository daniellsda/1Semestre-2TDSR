package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

//Classe abstrata -> não pode ser instanciada (serve para a herança)
//métodos abstratos (sem implementação)

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K> {

	private EntityManager em;
	
	//atributo que armazena em tempo de execução o .class T (usado na pesquisa)
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		
		//recupera o .class da classe T 
		this.clazz = (Class<T>) 
				((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		
	}

	@Override
	public void inserir(T entidade) {
		em.persist(entidade); //cadastra
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade); //cadastra ou atualiza
	}

	@Override
	public T pesquisar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void remover(K id) throws KeyNotFoundException {
		T entidade = pesquisar(id);
		//valida se existe o dado no banco para ser removido
		if (entidade == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entidade);//remove recebe o objeto
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin(); //começa uma transação
			em.getTransaction().commit();//realiza o commit
		}catch(Exception e) { 
			e.printStackTrace(); //exibindo o erro
			em.getTransaction().rollback(); //se deu erro, realiza o rollback
			throw new CommitException();//lança uma exceção para avisar que deu erro
		}
	}
	
}