package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = 
				em.createQuery("from Pacote p where p.transporte = :p", Pacote.class);
		query.setParameter("p", transporte);//Seta o parametro na querie
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public double somarPrecoPorTransporte(Transporte transporte) {
		return em.createQuery("select sum(p.preco) from Pacote p "
				+ "where p.transporte = :t", Double.class)
				.setParameter("t", transporte)
				.getSingleResult();
	}

	@Override
	public List<Pacote> buscarPorDias(int dias) {
		return em.createNamedQuery("Pacote.porDias", Pacote.class)
				.setParameter("qtd", dias)
				.getResultList();
	}

}
