package br.com.fiap.model;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

@Tabela(nome="TB_CONDUTOR")
public class Condutor {

	@Coluna(nome="nm_condutor", obrigatorio = true)
	private String nome;
	
	@Coluna(nome="ds_idade")
	private int idade;
	
	@Coluna(nome="st_habilitado")
	private boolean habilitado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
}