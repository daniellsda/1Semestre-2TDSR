package br.com.fiap.jpa.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.FilmeDAO;
import br.com.fiap.jpa.dao.impl.FilmeDAOImpl;
import br.com.fiap.jpa.entity.Classificacao;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

class FilmeDAOTest {
	
	static FilmeDAO dao;
	
	Filme filme;
	
	//Método que será executado antes de todos os testes
	@BeforeAll
	static void inicializar() {
		//Instanciar os objetos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new FilmeDAOImpl(em);
	}
	
	//Método que será executado antes de cada teste
	@BeforeEach
	void cadastrar() {
		filme = new Filme("Senhor dos anéis", 180, Genero.AVENTURA, 
				Classificacao.MAIOR_16, new GregorianCalendar(2001, Calendar.FEBRUARY, 10));
		
		//Cadastrar o filme
		dao.inserir(filme);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	@DisplayName("Atualização da duração do filme com sucesso")
	void atualizarSucessoTest() {
		//atualizar alguma informação do filme
		filme.setDuracao(210);
		
		dao.atualizar(filme);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no teste");
		}
		
		//Valida se o filme foi atualizado no banco
		Filme busca = dao.pesquisar(filme.getCodigo());
		
		assertEquals(filme.getDuracao(), busca.getDuracao());
		
	}
	
	@Test
	@DisplayName("Remoção de um filme com código inexistente no banco de dados")
	void removerCodigoInvalidoTest() {
		
		//valida se o método vai lançar a exceção
	 	assertThrows(KeyNotFoundException.class, () -> { dao.remover(-1); } );
		
	}
	
	@Test
	@DisplayName("Remoção de um filme com sucesso")
	void removerSucessoTest() {
		//remover o filme do banco
		try {
			dao.remover(filme.getCodigo());
			dao.commit();
		} catch (KeyNotFoundException | CommitException e) {
			fail("Falha no teste");
		}
		
		//validar se o filme foi removido
		Filme busca = dao.pesquisar(filme.getCodigo());
		assertNull(busca); //valida se não encontrou o filme no banco
	}
	
	@Test
	@DisplayName("Pesquisa de um filme com sucesso")
	void pequisarSucessoTest() {
		//Pesquisar o filme cadastrado
		Filme busca = dao.pesquisar(filme.getCodigo());
		//Validar se a busca funcionou
		assertNotNull(busca); //valida se a busca não está vazia (null)
		assertEquals(filme.getCodigo(), busca.getCodigo());
	}

	@Test
	@DisplayName("Inserir um filme com sucesso")
	void inserirSucessoTest() {
		//Validar se o cadastro foi realizado
		//Valida se foi gerado um valor do banco (Sequence) para o código 
		assertNotEquals(0, filme.getCodigo());
	}
	
}
