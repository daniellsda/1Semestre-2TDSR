package br.com.fiap.jpa.entity;

import java.io.Serializable;

//Classe que mapeia a chave composta
//Deve implementar Serializable
//Deve conter somente os atributos que formam a chave composta
public class ItemPedidoPK implements Serializable {

	//Mesmo nomes dos atributos da classe da entidade
	private int medicamento;
	
	private int pedido;
	
	//Construtores
	public ItemPedidoPK() {}
	
	public ItemPedidoPK(int medicamento, int pedido) {
		super();
		this.medicamento = medicamento;
		this.pedido = pedido;
	}
	
	//Sobrescrever os métodos equals() e hashCode()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + medicamento;
		result = prime * result + pedido;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (medicamento != other.medicamento)
			return false;
		if (pedido != other.pedido)
			return false;
		return true;
	}

	//Gets e Sets
	public int getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(int medicamento) {
		this.medicamento = medicamento;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
}