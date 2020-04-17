package br.com.fiap.restaurante.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GARCOM")
@SequenceGenerator(name="garcom", sequenceName = "SQ_TB_GARCOM", allocationSize = 1)
public class Garcom {
	
	@Id
	@Column(name="cd_garcom")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garcom")
	private int codigo;
	
	@Column(name="nm_garcom", nullable = false, length = 70)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_funcao")
	private Funcao funcao;
	
	@OneToMany(mappedBy = "garcom")
	private List<Pedido> pedidos;

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

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
