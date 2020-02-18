package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.model.Condutor;

public class Teste {

	public static void main(String[] args) {
		
		//Instanciar uma classe Condutor
		Condutor condutor = new Condutor();
		
		//Recuperar os atributos da classe condutor
		Field[] atributos = condutor.getClass().getDeclaredFields();
		//Percorrer os atributos
		for (Field a : atributos) {
			
			//Recuperar a anota��o @Coluna dos atributos
			Coluna anotacao = a.getAnnotation(Coluna.class);
			
			//Exibir o nome dos atributos
			System.out.println(a.getName() + " - " +
				anotacao.nome() + " " + anotacao.tamanho() + " "
				+ anotacao.obrigatorio());
		}
	
		//Recuperar os m�todos da classe condutor
		Method[] metodos = condutor.getClass().getDeclaredMethods();
		//Percorrer os m�todos
		for (Method m : metodos) {
			//Exibir o nome dos m�todos
			System.out.println(m.getName());
		}
		
	}
	
}





