package br.com.fiap.revisao.bean;

public class Carro extends Veiculo {

	//Constante no java
	public static final int CONSTANTE_TESTE = 1;
	
	public Carro(String cor) {
		super(cor);
	}
	
	//Sobrescrita do método
	public void andar() {
		System.out.println("Carro andando");
	}

	@Override
	public void ligar() {
		
	}
	
}