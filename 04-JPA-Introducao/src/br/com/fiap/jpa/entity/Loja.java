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
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_LOJA")
@SequenceGenerator(name="loja",sequenceName = "SQ_TB_LOJA", allocationSize = 1)
public class Loja {

	@Id
	@Column(name="cd_loja")
	@GeneratedValue(generator = "loja", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_loja", length = 50, nullable = false)
	private String nome;
	
	@Column(name="ds_endereco", nullable = false)
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura")
	private Calendar dataAbertura;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Column(name="vl_faturamento")
	private float faturamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_qualidade")
	private Qualidade qualidade;
	
	@Transient
	private float faturamentoAnual;
	
	//Método que é executado após um select
	@PostLoad
	public void carregar() {
		System.out.println("Carregando informações...");
		faturamentoAnual = faturamento * 12;
	}
	
	public Loja() {
		super();
	}

	public Loja(String nome, String endereco, Calendar dataAbertura, byte[] logo, float faturamento,
			Qualidade qualidade) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.dataAbertura = dataAbertura;
		this.logo = logo;
		this.faturamento = faturamento;
		this.qualidade = qualidade;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public float getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}

	public Qualidade getQualidade() {
		return qualidade;
	}

	public void setQualidade(Qualidade qualidade) {
		this.qualidade = qualidade;
	}

	public float getFaturamentoAnual() {
		return faturamentoAnual;
	}

	public void setFaturamentoAnual(float faturamentoAnual) {
		this.faturamentoAnual = faturamentoAnual;
	}
	
	
	
}


