package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	//Cadastrar todas as entidades
	public static void main(String[] args) {
		
		//Instanciar a fabrica, em e dao da consulta
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		ConsultaDAO dao = new ConsultaDAOImpl(em);
		
		//Instanciar um médico
		Medico medico = new Medico(123, "Drauzio", "Geral");
		
		//Instanciar um paciente
		Paciente paciente = new Paciente("Mariazinha",
				new GregorianCalendar(1999, Calendar.JULY, 9));
		
		//Instanciar uma consulta
		Consulta consulta = new Consulta(medico, paciente, 
				new GregorianCalendar(2020, Calendar.MAY, 25, 10, 30));
		
		try {
			//Cadastrar a consulta (médico e paciente por cascata)
			dao.inserir(consulta);
			dao.commit();
			System.out.println("Consulta agendada!");
		} catch (CommitException e) {
			System.out.println("Deu erro..");
		}
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
