package br.com.fiap.restaurante.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRATO")
@SequenceGenerator(name="prato", sequenceName = "SQ_TB_PRATO", allocationSize = 1)
public class Prato {
	
	@Id
	@Column(name="cd_prato")
	@GeneratedValue(generator = "prato", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_prato", nullable = false, length = 100)
	private String nome;
	
	@Column(name="vl_prato", nullable = false)
	private float valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoPrato tipo;
	
	@ManyToMany(mappedBy = "pratos")
	private List<Pedido> pedidos;
	
	public Prato(String nome, float valor, TipoPrato tipo) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Prato() {
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TipoPrato getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrato tipo) {
		this.tipo = tipo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
