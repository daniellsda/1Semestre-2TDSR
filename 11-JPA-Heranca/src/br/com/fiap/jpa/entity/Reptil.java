package br.com.fiap.jpa.entity;

import java.util.Calendar;

public class Reptil extends Animal {

	private boolean escamas;
	
	private int mesesGestacao;
	
	public Reptil() {}
	
	public Reptil(String nome, Calendar dataNascimento, 
				Genero genero, boolean escamas, int mesesGestacao) {
		super(nome, dataNascimento, genero);
		this.escamas = escamas;
		this.mesesGestacao = mesesGestacao;
	}

	public boolean isEscamas() {
		return escamas;
	}

	public void setEscamas(boolean escamas) {
		this.escamas = escamas;
	}

	public int getMesesGestacao() {
		return mesesGestacao;
	}

	public void setMesesGestacao(int mesesGestacao) {
		this.mesesGestacao = mesesGestacao;
	}
	
}
