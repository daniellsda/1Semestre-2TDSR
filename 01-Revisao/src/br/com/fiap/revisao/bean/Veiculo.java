package br.com.fiap.revisao.bean;

//Classe abstrata -> não pode ser instanciada e
//pode conter métodos abstratos (sem implementação)
//serve para ser herdada
public abstract class Veiculo {
	
	private String cor;
	
	private Tamanho porte;
	
	private int passageiro;
	
	//Construtor
	public Veiculo(String cor){
		this.cor = cor;
	}
	
	public abstract void ligar();
	
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

	public Tamanho getPorte() {
		return porte;
	}

	public void setPorte(Tamanho porte) {
		this.porte = porte;
	}
	
}
