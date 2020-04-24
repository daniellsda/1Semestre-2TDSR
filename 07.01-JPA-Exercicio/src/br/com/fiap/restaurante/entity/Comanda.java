package br.com.fiap.restaurante.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_COMANDA")
@SequenceGenerator(name="comanda", sequenceName = "SQ_TB_COMANDA", allocationSize = 1)
public class Comanda {
	
	@Id
	@Column(name="cd_comanda")
	@GeneratedValue(generator ="comanda", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_abertura")
	private Calendar dataAbertura;
	
	@Column(name="nr_mesa")
	private int mesa;
	
	@OneToMany(mappedBy = "comanda")
	private List<Pedido> pedidos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_cliente", nullable = false)
	private Cliente cliente;
	
	public Comanda(Calendar dataAbertura, int mesa, Cliente cliente) {
		super();
		this.dataAbertura = dataAbertura;
		this.mesa = mesa;
		this.cliente = cliente;
	}

	public Comanda() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
