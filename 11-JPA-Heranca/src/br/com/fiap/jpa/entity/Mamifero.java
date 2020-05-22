package br.com.fiap.jpa.entity;

import java.util.Calendar;

public class Mamifero extends Animal {

	private boolean terrestre;
	
	private String corPelagem;
	
	public Mamifero() {}
	
	public Mamifero(String nome, Calendar dataNascimento, Genero genero, boolean terrestre, String corPelagem) {
		super(nome, dataNascimento, genero);
		this.terrestre = terrestre;
		this.corPelagem = corPelagem;
	}

	public boolean isTerrestre() {
		return terrestre;
	}

	public void setTerrestre(boolean terrestre) {
		this.terrestre = terrestre;
	}

	public String getCorPelagem() {
		return corPelagem;
	}

	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}
	
}
