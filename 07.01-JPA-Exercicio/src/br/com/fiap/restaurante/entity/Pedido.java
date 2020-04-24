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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido {
	
	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido")
	private Calendar data;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_garcom", nullable = false)
	private Garcom garcom;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_PEDIDO_PRATO",
			joinColumns = @JoinColumn(name="cd_pedido"),
			inverseJoinColumns = @JoinColumn(name="cd_prato"))
	private List<Prato> pratos;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_comanda", nullable = false)
	private Comanda comanda;
	
	public Pedido(Calendar data, Garcom garcom, List<Prato> pratos, Comanda comanda) {
		super();
		this.data = data;
		this.garcom = garcom;
		this.pratos = pratos;
		this.comanda = comanda;
	}

	public Pedido() {
		super();
	}

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

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	
}
