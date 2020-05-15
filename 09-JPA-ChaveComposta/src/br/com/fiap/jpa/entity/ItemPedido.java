package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ITEM_PEDIDO")
public class ItemPedido {

	@ManyToOne
	@JoinColumn(name="cd_medicamento")
	private Medicamento medicamento;
	
	@ManyToOne
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	@Column(name="vl_item")
	private double valor;
	
	@Column(name="qt_item")
	private int quantidade;

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
