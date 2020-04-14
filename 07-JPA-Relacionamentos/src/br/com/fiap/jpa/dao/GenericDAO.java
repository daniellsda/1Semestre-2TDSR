package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

//Criar o GenericDAO e o GenericDAOImpl (Criar as exceções)
//Criar o EntityManagerFactorySingleton
//Criar um DAO para cada entidade

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	void commit() throws CommitException;
	
}