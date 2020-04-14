package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.AreaGerente;
import br.com.fiap.jpa.entity.Departamento;
import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.entity.Gerente;
import br.com.fiap.jpa.entity.Projeto;
import br.com.fiap.jpa.entity.TipoDepartamento;

public class View {

	public static void main(String[] args) {
		//Instanciar EntityManagerFactory e o EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Persistir o departamento e o gerente
		
		//Instanciar o gerente
		Gerente gerente = new Gerente("Allen", AreaGerente.ADMINISTRATIVO);
		
		//Instanciar o departamento
		Departamento dep = new Departamento("Pessoas", TipoDepartamento.RH, gerente);
		
		//Instanciar 2 funcionários
		Funcionario f1 = new Funcionario("Thiago", Calendar.getInstance());
		Funcionario f2 = new Funcionario("Maria", 
				new GregorianCalendar(2019, Calendar.JANUARY, 12));
		
		//Adicionar no departamento
		dep.addFuncionario(f1);
		dep.addFuncionario(f2);
		
		//Criar uma lista de projetos
		List<Projeto> lista = new ArrayList<Projeto>();
		lista.add(new Projeto("AM", "Salvar vidas", Calendar.getInstance()));
		lista.add(new Projeto("Startup One", "Ganhar dinheiro", Calendar.getInstance()));
		
		//Adicionar a lista de projetos nos funcionarios
		f1.setProjetos(lista);
		f2.setProjetos(lista);
		
		em.persist(dep);

		em.getTransaction().begin();
		em.getTransaction().commit();
		
		/*
		//Pesquisar o departamento de código 1
		Departamento dep = em.find(Departamento.class, 1);
		System.out.println(dep.getNome());
		System.out.println(dep.getGerente().getNome());
		*/
		//Fechar as paradas
		
		em.close();
		fabrica.close();
	}
	
}
