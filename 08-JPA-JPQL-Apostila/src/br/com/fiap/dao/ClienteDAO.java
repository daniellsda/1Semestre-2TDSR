package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	//List<Cliente> listar();
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorNome(String nome, int maximo, int primeiraPosicao);
	
	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDiasReserva(int dias);
	
	Cliente buscarPorCpf(String cpf);
	
}
