package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEPARTAMENTO")
@SequenceGenerator(name="dep",sequenceName = "SQ_TB_DEPARTAMENTO", allocationSize = 1)
public class Departamento {
	
	@Id
	@Column(name="cd_departamento")
	@GeneratedValue(generator = "dep", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_departamento", length = 80, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoDepartamento tipo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDepartamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDepartamento tipo) {
		this.tipo = tipo;
	}
	
}