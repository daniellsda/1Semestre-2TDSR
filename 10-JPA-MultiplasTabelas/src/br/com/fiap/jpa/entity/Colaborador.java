package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SecondaryTable(name="TB_COLABORADOR_FINANCEIRO")

@Entity
@Table(name="TB_COLABORADOR")
@SequenceGenerator(name="colaborador", sequenceName = "SQ_TB_COLABORADOR", allocationSize = 1)
public class Colaborador {

	@Id
	@Column(name="cd_colaborador")
	@GeneratedValue(generator = "colaborador", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_colaborador", length = 60, nullable = false)
	private String nome;
	
	@Column(name="ds_cargo", nullable = false, length = 40)
	private String cargo;
	
	@Column(name="vl_salario", nullable = false, table = "TB_COLABORADOR_FINANCEIRO")
	private double salario;
	
	@Column(name="nr_conta", nullable = false, table="TB_COLABORADOR_FINANCEIRO")
	private int conta;
	
	@Column(name="nr_agencia", nullable = false, table="TB_COLABORADOR_FINANCEIRO")
	private int agencia;

	public Colaborador() {}
	
	public Colaborador(String nome, String cargo, double salario, int conta, int agencia) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.conta = conta;
		this.agencia = agencia;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
}
