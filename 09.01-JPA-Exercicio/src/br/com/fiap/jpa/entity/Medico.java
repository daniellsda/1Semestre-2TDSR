package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEDICO")
public class Medico {

	@Id
	@Column(name="nr_crm")
	private int crm;
	
	@Column(name="nm_medico", nullable = false, length = 80)
	private String nome;
	
	@Column(name="ds_especialidade", length = 40)
	private String especialidade;
	
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
	public Medico() {}
	
	public Medico(int crm, String nome, String especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
