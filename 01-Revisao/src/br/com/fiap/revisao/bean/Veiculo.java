package br.com.fiap.revisao.bean;

public class Veiculo {
	
	private String cor;
	
	private int passageiro;
	
	//Construtor
	public Veiculo(String cor){
		this.cor = cor;
	}
	
	//Sobrecarga do método
	public void andar(int velocidade) {
		
	}	
	
	public void andar() {
		System.out.println("Veiculo andando");
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(int passageiro) {
		this.passageiro = passageiro;
	}
	
}
