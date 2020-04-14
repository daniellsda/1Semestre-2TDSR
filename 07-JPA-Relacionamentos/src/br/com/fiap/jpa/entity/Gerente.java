package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GERENTE")
@SequenceGenerator(name="gerente", sequenceName = "SQ_TB_GERENTE", allocationSize = 1)
public class Gerente {

	@Id
	@Column(name="cd_gerente")
	@GeneratedValue(generator = "gerente", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_gerente", nullable = false, length = 80)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_area")
	private AreaGerente area;
	
	//Mapeamento bidirecional (um-para-um)
	//Sempre que for bidirecional um lado possui o mappedBy
	//mappedBy fica no lado que não tem a chave (FK) ou a tabela associativa
	//mappedBy -> nome do atributo que mapeia a FK (na classe Departamento)
	@OneToOne(mappedBy = "gerente", cascade = CascadeType.ALL)
	private Departamento departamento;
	
	public Gerente(String nome, AreaGerente area) {
		super();
		this.nome = nome;
		this.area = area;
	}

	public Gerente() {
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

	public AreaGerente getArea() {
		return area;
	}

	public void setArea(AreaGerente area) {
		this.area = area;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
}
