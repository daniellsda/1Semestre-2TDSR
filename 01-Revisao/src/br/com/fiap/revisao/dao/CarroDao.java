package br.com.fiap.revisao.dao;

import java.util.List;
import br.com.fiap.revisao.bean.Carro;

public interface CarroDao {

	void inserir(Carro carro);
	
	List<Carro> buscarPorNome(String nome);
	
}