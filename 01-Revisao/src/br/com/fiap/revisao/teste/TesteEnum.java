package br.com.fiap.revisao.teste;

import br.com.fiap.revisao.bean.Carro;
import br.com.fiap.revisao.bean.Tamanho;

public class TesteEnum {

	public static void main(String[] args) {
		//Criar um objeto carro
		Carro carro = new Carro("Vermelho");
		//Atribuir um valor para o tamanho 
		carro.setPorte(Tamanho.GRANDE);
		
		//Validar se o carro é grande
		if (carro.getPorte() == Tamanho.GRANDE) {
			System.out.println("Carrão");
		}
		
	}
	
}



