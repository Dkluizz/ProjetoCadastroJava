package br.com.cadastro.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.modelo.Cadastro;

public class CadastroDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private EntityManager em;
	
	public CadastroDao() {
		this.em = JPAUtil.getEntityManager();
	}

	public void adicionar(Cadastro cadastro) {
		em.getTransaction().begin();
		em.persist(cadastro);
		em.getTransaction().commit();
		em.close();

	}

	public void remover(Cadastro cadastro) {
		em.getTransaction().begin();
		em.remove(em.merge(cadastro));
		em.getTransaction().commit();
		em.close();

	}

	public void atualiza(Cadastro cadastro) {
		em.getTransaction().begin();
		em.merge(cadastro);
		em.getTransaction().commit();
		em.close();

	}

	public List<Cadastro> listaTodos() {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		List<Cadastro> cadastros = em.createQuery("from Cadastro ", Cadastro.class).getResultList();
		return cadastros;

	}

	public List<Cadastro> listaBusca(String busca) {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		List<Cadastro> cadastros = em.createQuery("from Cadastro p where p.nome like '%" + busca + "%' ", Cadastro.class).getResultList();
		em.close();
		return cadastros;
	}

}
