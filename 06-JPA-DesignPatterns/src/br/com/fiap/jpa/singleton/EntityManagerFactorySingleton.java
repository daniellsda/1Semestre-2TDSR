package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	//Construtor privado -> somente a classe pode instanciar
	private EntityManagerFactorySingleton() {}
	
	//Método estático que cria o único objeto e o retorna
	public static EntityManagerFactory getInstance() {
		//validar se a fabrica já foi criada (a fabrica é criada uma única vez)
		if (fabrica == null) {
			//persistence.xml -> configuração do banco de dados ("oracle")
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}