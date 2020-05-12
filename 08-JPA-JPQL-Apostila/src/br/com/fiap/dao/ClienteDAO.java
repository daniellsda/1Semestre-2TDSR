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
	
	//Buscar por parte do nome do cliente e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//Buscar por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//Contar os clientes por estado
	long contarPorEstado(String estado);
	
}
