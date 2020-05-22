package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@IdClass(ConsultaPK.class)

@Entity
@Table(name="TB_CONSULTA")
public class Consulta {
	
	@Id
	@ManyToOne
	@JoinColumn(name="nr_crm")
	private Medico medico;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_paciente")
	private Paciente paciente;
	
	@Id
	@Column(name="dt_consulta")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="ds_consulta", length = 200)
	private String descricao;
	
	public Consulta() {}
	
	public Consulta(Medico medico, Paciente paciente, Calendar data) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
	}



	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
