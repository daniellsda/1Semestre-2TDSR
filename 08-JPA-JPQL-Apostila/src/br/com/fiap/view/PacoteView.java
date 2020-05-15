package br.com.fiap.view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PacoteView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PacoteDAO pDao = new PacoteDAOImpl(em);
		TransporteDAO tDao = new TransporteDAOImpl(em);
		
		//Pesquisa o transporte de código 1
		Transporte transporte = tDao.pesquisar(1); 
		
		//Pesquisa todos os pacotes com o transporte de código 1
		List<Pacote> lista = pDao.buscarPorTransporte(transporte);
		
		//Exibir a descrição do pacote e o nome da empresa do transporte
		lista.forEach(pacote -> 
			System.out.println(pacote.getDescricao() + " " + pacote.getTransporte().getEmpresa()));
		
		//Instancia duas datas específicas para realizar a pesquisa
		Calendar inicio = new GregorianCalendar(2017, Calendar.AUGUST, 1);
		Calendar fim = new GregorianCalendar(2018, Calendar.JANUARY, 1);
		
		//Pesquisa o pacote por data
		lista = pDao.buscarPorDatas(inicio, fim);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibir a descrição do pacote e a data de saída
		lista.forEach(p -> System.out.println(p.getDescricao() + " " +
											sdf.format(p.getDataSaida().getTime() )));
		
		//Exibir a soma dos preços dos pacotes do transporte de código 1
		double total = pDao.somarPrecoPorTransporte(transporte);
		System.out.println("Total dos preços: " + total);
		
		//Exibir os pacotes com qtd de dias igual a 10
		lista = pDao.buscarPorDias(10);
		lista.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias()));
		
		//Exibir o preço médio por qtd de dias
		double media = pDao.obterMediaPrecoPorQtdDias(10);
		System.out.println("Preço médio por 10 dias: " + media);
		
		//Exibir o preço médio por mês
		BigDecimal m = pDao.obterMediaPrecoPorData(9);
		System.out.println("Preço médio no mês 9: " + m);
		
		//Listar a média de preços e qtd de dias dos pacotes
		List<Object[]> objs = pDao.obterMediaPrecoPorQtdDias();
		//Percorre a lista e exibe os valores da primeira e segunda posição do vetor
		objs.forEach(item -> System.out.println(item[0] + " " + item[1]));
		
		em.close();
		fabrica.close();
	}
	
}
