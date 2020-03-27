package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

//GenericDAO<Cliente,Integer>

//<T> representa a classe que mapeia a tabela
//<K> representa o tipo da chave primária da tabela

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	T pesquisar(K id);
	
	void remover(K id) throws KeyNotFoundException;
	
	void commit() throws CommitException;
	
}