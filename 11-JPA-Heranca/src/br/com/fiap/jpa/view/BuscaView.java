package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.AnimalDAO;
import br.com.fiap.jpa.dao.ReptilDAO;
import br.com.fiap.jpa.dao.impl.AnimalDAOImpl;
import br.com.fiap.jpa.dao.impl.ReptilDAOImpl;
import br.com.fiap.jpa.entity.Animal;
import br.com.fiap.jpa.entity.Reptil;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaView {

	//Pesquisar um animal pelo código
	public static void main(String[] args) {
		
		//Instanciar a fabrica, em e dao do animal
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		AnimalDAO dao = new AnimalDAOImpl(em);
		
		//Pesquisar o animal pelo codigo
		Animal animal = dao.pesquisar(3);
		
		//Exibir o nome e genero
		System.out.println(animal.getNome() + " " + animal.getGenero());
		
		//Instanciar o dao do reptil
		ReptilDAO reptilDao = new ReptilDAOImpl(em);
		
		//Pesquisar um reptil pelo código
		Reptil reptil = reptilDao.pesquisar(3);
		
		//Valida se encontrou um reptil
		if (reptil != null) {
			System.out.println(reptil.getNome() + " " + reptil.isEscamas());
		}else {
			System.out.println("Reptil não encontrado");
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
