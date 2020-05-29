package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.AnimalDAO;
import br.com.fiap.jpa.dao.impl.AnimalDAOImpl;
import br.com.fiap.jpa.entity.Animal;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Mamifero;
import br.com.fiap.jpa.entity.Reptil;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroView {

	//Cadastrar um animal, reptil e um mamifero
	public static void main(String[] args) {
		
		//Instanciar a fabrica, em e o dao do animal
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		AnimalDAO dao = new AnimalDAOImpl(em);
		
		//Instanciar um animal, um reptil e um mamifero
		Animal animal = 
			new Animal("Pardal", new GregorianCalendar(2020, Calendar.JANUARY, 3), Genero.FEMEA);
		
		Mamifero mamifero = 
			new Mamifero("Cachorro", Calendar.getInstance(), Genero.MACHO, true, "Branco");
		
		Reptil reptil = 
			new Reptil("Cobra", Calendar.getInstance(), Genero.FEMEA, true, 2);
		
		//Cadastrar os 3 animais
		dao.inserir(animal);
		dao.inserir(reptil);
		dao.inserir(mamifero);
		
		try {
			//Commit
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro..");
		}
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
