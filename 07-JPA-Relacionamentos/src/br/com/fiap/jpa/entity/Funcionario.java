package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	//Pensar: da classe que estamos para a classe do relacionamento
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_departamento", nullable = false)
	private Departamento departamento;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	//name -> nome da tabela associativa
	//joinColumns -> coluna que armazena a PK da classe que estamos
	//inverseJoinColumns -> coluna que armazena a PK da outra classe (projeto)
	@JoinTable(name="TB_PROJETO_FUNCIONARIO",
			joinColumns = @JoinColumn(name="cd_funcionario"),
			inverseJoinColumns = @JoinColumn(name="cd_projeto"))
	private List<Projeto> projetos;
	
	public Funcionario(String nome, Calendar dataAdmissao) {
		super();
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
	}

	public Funcionario() {
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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
}
