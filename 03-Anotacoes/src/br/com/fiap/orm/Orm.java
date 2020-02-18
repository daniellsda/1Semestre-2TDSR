package br.com.fiap.orm;

import br.com.fiap.anotacao.Tabela;

public class Orm {

	//gera o sql para realizar a pesquisa
	public String gerarQuery(Object o) {
		//Recuperar a anotação @Tabela
		Tabela anotacao = o.getClass().getAnnotation(Tabela.class);
		return "SELECT * FROM " + anotacao.nome();
	}
	
}