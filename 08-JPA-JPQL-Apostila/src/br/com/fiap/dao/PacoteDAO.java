package br.com.fiap.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
	double somarPrecoPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorDias(int dias);
	
	BigDecimal obterMediaPrecoPorData(int mes);
	
	double obterMediaPrecoPorQtdDias(int dias);
	
	//Retornar a média de preço, qtd dias
	List<Object[]> obterMediaPrecoPorQtdDias();
	
}
