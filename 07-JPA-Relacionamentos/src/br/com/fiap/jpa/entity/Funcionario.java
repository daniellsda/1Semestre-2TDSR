package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="func", sequenceName = "SQ_TB_FUNCIONARIO",allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario", length = 30, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_admissao")
	private Calendar dataAdmissao;

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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
}
