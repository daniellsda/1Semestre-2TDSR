package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	/*
	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}
	 */
	
	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = 
			em.createQuery("from Cliente c where c.nome like :pNome", Cliente.class);
		query.setParameter("pNome", "%"+ nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		TypedQuery<Cliente> query =
			em.createQuery("from Cliente c where c.endereco.cidade.uf = :e", Cliente.class);
		query.setParameter("e", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		TypedQuery<Cliente> query =
			em.createQuery("select r.cliente from Reserva r where r.numeroDias = :p",Cliente.class);
		query.setParameter("p", dias);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome, int maximo, int primeiraPosicao) {	
//		TypedQuery<Cliente> query = 
//				em.createQuery("from Cliente c where c.nome like :n",Cliente.class);
//		query.setParameter("n", "%" + nome + "%");
//		query.setMaxResults(maximo);
//		query.setFirstResult(primeiraPosicao);
//		return query.getResultList();
		
		return em.createQuery("from Cliente c where c.nome like :n", Cliente.class)
				.setParameter("n", "%"+ nome + "%")
				.setMaxResults(maximo)
				.setFirstResult(primeiraPosicao)
				.getResultList();
	}

	//Retornar somente o nome e cpf do cliente
	@Override
	public Cliente buscarPorCpf(String cpf) {
		return em.createQuery("select new Cliente(c.nome, c.cpf) from Cliente c where c.cpf = :pCpf",Cliente.class)
				.setParameter("pCpf", cpf)
				.getSingleResult();
	}

}











