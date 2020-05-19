package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Configura a classe que mapeia a chave composta
@IdClass(ItemPedidoPK.class)

@Entity
@Table(name="TB_ITEM_PEDIDO")
public class ItemPedido {

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_medicamento")
	private Medicamento medicamento;
	
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	@Column(name="vl_item")
	private double valor;
	
	@Column(name="qt_item")
	private int quantidade;
	
	public ItemPedido() {}

	public ItemPedido(Medicamento medicamento, Pedido pedido, double valor, int quantidade) {
		this.medicamento = medicamento;
		this.pedido = pedido;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
