package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		//Criar a Query
		TypedQuery<Cidade> query = em.createQuery("from Cidade",Cidade.class);
		//Executar a Query
		return query.getResultList();
	}

	@Override
	public List<Cidade> buscarPorDdd(int ddd) {
		//Criar a TypedQuery
		TypedQuery<Cidade> query = 
				em.createQuery("from Cidade c where c.ddd = :churros", Cidade.class);
		//Setar o parâmetro na query
		query.setParameter("churros", ddd);
		//Executar a Query
		return query.getResultList();
	}

}
