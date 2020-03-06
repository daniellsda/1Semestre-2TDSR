package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.exception.DeuRuimNoBancoException;

public interface LivroDAO {

	void inserir(Livro livro);
	
	Livro pesquisar(int codigo);
	
	void deletar(int codigo);
	
	void atualizar(Livro livro);
	
	void commit() throws DeuRuimNoBancoException;
	
}