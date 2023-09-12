package br.com.cadastro.dao;

import javax.persistence.EntityManager;

import br.com.cadastro.modelo.Contato;

public class ContatosDao {

	private EntityManager em;

	public ContatosDao() {
		this.em = JPAUtil.getEntityManager();
	}

	public void adicionar(Contato contato) {

		em.getTransaction().begin();

		em.persist(contato);

		em.getTransaction().commit();

		em.close();

	}

	public void remover(Contato contato) {

		em.getTransaction().begin();

		em.remove(contato);

		em.getTransaction().commit();

		em.close();

	}

	public void atualiza(Contato contato) {

		em.getTransaction().begin();

		em.merge(contato);

		em.getTransaction().commit();

		em.close();

	}

	public void listaTodos() {

	}

}