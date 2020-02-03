package br.com.fiap.revisao.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Carro;

public class TesteColecao {

	public static void main(String[] args) {
		//Lista de carro
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(new Carro("Branco"));
		carros.add(new Carro("Azul"));
		
		//Exibir as cores dos carros
		for (Carro batata : carros) {
			System.out.println(batata.getCor());
		}
		
		//Mapa<Chave,Valor>
		Map<String, Carro> mapa = new HashMap<String, Carro>();
		mapa.put("gol", new Carro("Cinza"));
		
		//Recuperar o objeto carro do mapa
		Carro carro = mapa.get("gol");
		System.out.println(carro.getCor());
		
	}
	
}


