package br.com.fiap.jpa.view;

import javax.persistence.EntityManagerFactory;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		
		
		//Fechar as paradas
		fabrica.close();
	}

}