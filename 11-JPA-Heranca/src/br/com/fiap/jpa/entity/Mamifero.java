package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@DiscriminatorValue("M")

@Table(name="TB_MAMIFERO")
//Nome da coluna da PK/FK da tabela (JOINED)
@PrimaryKeyJoinColumn(name="cd_mamifero")

@Entity
public class Mamifero extends Animal {

	@Column(name="st_terrestre")
	private boolean terrestre;
	
	@Column(name="sd_cor_pelagem", length = 30)
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
