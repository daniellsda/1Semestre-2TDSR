package br.com.fiap.revisao.bean;

public class Carro extends Veiculo {

	public Carro(String cor) {
		super(cor);
	}
	
	//Sobrescrita do m�todo
	public void andar() {
		System.out.println("Carro andando");
	}
	
}