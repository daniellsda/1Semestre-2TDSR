package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name="prod",sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator ="prod" , strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto", nullable = false, length = 100)
	private String nome;
	
	@Column(name="qt_produto")
	private int quantidade;
	
	//name -> nome da coluna
	//nullable = false -> coluna obrigatória
	@Column(name="vl_produto", nullable = false)
	private float preco;
	
	//Armazena somente a data no banco
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Calendar dataValidade;
	
	//Atributo que não será mapeado para uma coluna
	@Transient
	private double valorEstoque;
	
	@Lob //mapeia um campo para gravar arquivos no bd
	@Column(name="img_produto")
	private byte[] foto;
	
	//grava a string e não a posição da constante
	@Enumerated(EnumType.STRING)
	@Column(name="ds_categoria")
	private Categoria categoria;

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public double getValorEstoque() {
		return valorEstoque;
	}

	public void setValorEstoque(double valorEstoque) {
		this.valorEstoque = valorEstoque;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}



