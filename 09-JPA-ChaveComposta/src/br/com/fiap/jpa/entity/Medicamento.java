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
@Table(name="TB_MEDICAMENTO")
@SequenceGenerator(name="med", sequenceName = "SQ_TB_MEDICAMENTO", allocationSize = 1)
public class Medicamento {
	
	@Id
	@Column(name="cd_medicamento")
	@GeneratedValue(generator = "med", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_medicamento", nullable = false, length = 80)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Calendar dataValidade;
	
	@Column(name="st_generico")
	private boolean generico;
	
	@OneToMany(mappedBy = "medicamento")
	private List<ItemPedido> itens;
	
	public Medicamento(String nome, Calendar dataValidade, boolean generico) {
		super();
		this.nome = nome;
		this.dataValidade = dataValidade;
		this.generico = generico;
	}

	public Medicamento() {
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

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public boolean isGenerico() {
		return generico;
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

}
