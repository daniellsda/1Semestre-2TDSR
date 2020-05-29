package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Inheritance(strategy = InheritanceType.JOINED)

//Configuração para SINGLE_TABLE
//Configura o nome da coluna que armazena o tipo de objeto (DTYPE)
//@DiscriminatorColumn(name="ds_tipo")
//Valor armazenado na coluna DTYPE quando um Animal for registrado
//@DiscriminatorValue("A")

@Entity
@Table(name="TB_ANIMAL")
@SequenceGenerator(name="animal",sequenceName = "SQ_TB_ANIMAL", allocationSize = 1)
public class Animal {

	@Id
	@Column(name="cd_animal")
	@GeneratedValue(generator = "animal", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_animal", nullable = false, length = 50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	public Animal() {}
	
	public Animal(String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
