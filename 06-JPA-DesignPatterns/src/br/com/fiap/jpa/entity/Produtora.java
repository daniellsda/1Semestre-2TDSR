package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTORA")
@SequenceGenerator(name="prod",sequenceName = "SQ_TB_PRODUTORA", allocationSize = 1)
public class Produtora {

	@Id
	@Column(name="cd_produtora")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod")
	private int codigo;
	
	@Column(name="nr_cnpj", length = 20, nullable = false)
	private String cnpj;
	
	@Column(name="nm_produtora", length = 100, nullable = false)
	private String nome;
	
	@Column(name="ds_endereco", length = 80, nullable = false)
	private String endereco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
}
