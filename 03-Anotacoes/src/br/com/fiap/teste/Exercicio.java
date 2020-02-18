package br.com.fiap.teste;

import br.com.fiap.model.Aluno;
import br.com.fiap.model.Condutor;
import br.com.fiap.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um aluno e condutor
		Aluno aluno = new Aluno();
		Condutor condutor = new Condutor();
		
		//Instanciar um orm
		Orm orm = new Orm();
		
		//Chamar o método gerarQuery
		System.out.println(orm.gerarQuery(condutor));
		System.out.println(orm.gerarQuery(aluno));
		
	}
	
}
