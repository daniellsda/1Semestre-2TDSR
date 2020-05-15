package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName = "SQ_TB_PEDIDO",allocationSize = 1)
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido")
	private Calendar data;
	
	@Column(name="vl_pedido")
	private double valor;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
}
