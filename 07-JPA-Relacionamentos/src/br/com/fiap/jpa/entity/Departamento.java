package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	//Mapear a FK
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_gerente")
	private Gerente gerente;
	
	//Mapear o relacionamento bidirecional com o funcionario
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	//Somente para o OneToMany 
	//Método para adicionar funcionario
	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario); //adiciona o funcionario na lista
		funcionario.setDepartamento(this); //seta o departamento no funcionario (FK)
	}
	
	public Departamento(String nome, TipoDepartamento tipo, Gerente gerente) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.gerente = gerente;
	}

	public Departamento() {
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

	public TipoDepartamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDepartamento tipo) {
		this.tipo = tipo;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}