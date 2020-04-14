package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO")
@SequenceGenerator(name = "projeto", sequenceName = "SQ_TB_PROJETO", allocationSize = 1)
public class Projeto {

	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator = "projeto", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_projeto", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_projeto", length = 200)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrega")
	private Calendar dataEntrega;

	@ManyToMany(mappedBy = "projetos")
	private List<Funcionario> funcionarios;
	
	public Projeto(String nome, String descricao, Calendar dataEntrega) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataEntrega = dataEntrega;
	}

	public Projeto() {
		super();
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
