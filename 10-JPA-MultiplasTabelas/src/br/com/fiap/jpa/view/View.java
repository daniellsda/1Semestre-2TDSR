package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ColaboradorDAO;
import br.com.fiap.jpa.dao.impl.ColaboradorDAOImpl;
import br.com.fiap.jpa.entity.Colaborador;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	//Cadastrar um colaborador
	public static void main(String[] args) {
		
		//Instanciar a fabrica, em e dao do colaborador
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		ColaboradorDAO dao = new ColaboradorDAOImpl(em);
		
		//Instanciar um colaborador
		Colaborador colaborador = new Colaborador("Anderson", "Analista Sr",
				10000, 123, 321);
		
		try {
			//Cadastrar um colaborador
			dao.inserir(colaborador);
			dao.commit();
			System.out.println("Colaborador cadatrado!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		//Pesquisar o colaborador de código 1
		Colaborador busca = dao.pesquisar(1);
		System.out.println(busca.getNome() + " " + busca.getSalario());
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
